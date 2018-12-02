package airportis.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import airportis.app.entity.User;
import airportis.app.model.DestinationModel;
import airportis.app.model.PlaneModel;
import airportis.app.model.UserEditModel;
import airportis.app.model.UserRegisterModel;
import airportis.app.service.DestinationService;
import airportis.app.service.PlaneService;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlaneService planeService;
	

	@Autowired 
	DestinationService destinationService;
	
	List<String> getCountryList() {
		List<String> countryList = new ArrayList<String>();
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			countryList.add(obj.getDisplayCountry(Locale.ENGLISH));
		}
		Collections.sort(countryList);
		return countryList;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping
	public String showAdminPanel() {	
		return "redirect:/";
	}
	
	@GetMapping("/manageusers")
	public String showManageUsers(Model model) {
		model.addAttribute("usersList", userService.getAllUsers());
		return "manage-users";
	}
	
	@GetMapping("/manageusers/edituser")
	public String showUserEdit(@RequestParam("id")Integer id, Model model) {
		if(id == null) {
			return "redirect:/admin/manageusers";
		}
		
		UserEditModel userModel = userService.getUserModel(id.intValue());
		
		if(userModel == null) {
			return "redirect:/admin/manageusers";
		}
		
		model.addAttribute("countryList", getCountryList());
		model.addAttribute("userModel", userModel);
		
		return "admin-edituser-formular";
	}
	
	@PostMapping("/manageusers/edit/save")
	public String saveUserDetails(
			@Valid @ModelAttribute("userModel")UserEditModel userModel, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
			return "admin-edituser-formular"; 
		}
		
		userService.update(userModel);
		model.addAttribute("updateSuccess", true);
		return "redirect:/admin/manageusers";
		
	}
	
	@GetMapping("/manageusers/deleteuser")
	public String deleteUsert(@RequestParam("id")Integer id, Model model) {
		if(id == null) {
			return "redirect:/admin/manageusers";
		}
		
		User user = userService.findUserById(id.intValue()); 
		if(user != null) {
			userService.remove(user);
			model.addAttribute("deleteSuccess", true);
		}
		
		return "redirect:/admin/manageusers";
	}
	
	@GetMapping("/manageusers/enableuser")
	public String enableUsert(@RequestParam("id")Integer id, Model model) {
		if(id == null) {
			return "redirect:/admin/manageusers";
		}
		
		User user = userService.findUserById(id.intValue()); 
		if(user != null) {
			user.setEnabled(true);
			userService.save(user);
			model.addAttribute("enableSuccess", true);
		}
		
		return "redirect:/admin/manageusers";
	}
	
	@GetMapping("/manageusers/disableuser")
	public String disableUsert(@RequestParam("id")Integer id, Model model) {
		if(id == null) {
			return "redirect:/admin/manageusers";
		}
		
		User user = userService.findUserById(id.intValue()); 
		if(user != null) {
			user.setEnabled(false);
			userService.save(user);
			model.addAttribute("disableSuccess", true);
		}
		
		return "redirect:/admin/manageusers";
	}
	
	@GetMapping("/addplane")
	public String showPlaneForm(Model model) {
		model.addAttribute("planeModel", new PlaneModel());
		return "addplane-formular";
	}

	@PostMapping("/addplane/process")
	public String processAddPlane(@Valid @ModelAttribute("planeModel") PlaneModel planeModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addplane-formular";
		}else {
			planeService.save(planeModel);
			model.addAttribute("addSuccess", true);
			return "redirect:/admin/showplanes";
		}
	}
	
	@GetMapping("/showplanes")
	public String showUpdatePlaneForm(Model model) {
		model.addAttribute("planes", planeService.getPlanesList());
		return "showplanes";
	}
	
	@GetMapping("/updateplane")
	public String showUpdatePlaneForm(
			@RequestParam(value="serialNumber", required=false) String serialNumber,
			Model model) {
		if(serialNumber == null) {
			return "redirect:/admin/showplanes";
		}
		PlaneModel planeModel= planeService.getPlane(serialNumber);
		model.addAttribute("planeService", planeService);
		if(planeModel== null) {
			return "redirect:/admin/updateplane";
		}else {
			System.out.println(planeModel);
			model.addAttribute("planeModel", planeModel);
		}
		return "updateplane-formular";
	}
	
	@PostMapping("/updateplane/process")
	public String processUpdatePlane(@Valid @ModelAttribute("planeModel") PlaneModel planeModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "updateplane-formular";
		}else {
			System.out.println(planeModel);
			planeService.save(planeModel);
			model.addAttribute("updateSuccess", true);
			return "redirect:/admin/showplanes";		
		}
	}
	
	@GetMapping("/adddestination")
	public String showAddDestination(Model model) {
		DestinationModel destinationModel= new DestinationModel();
		model.addAttribute("destinationModel", destinationModel);
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("countryList", getCountryList());
		return "adddestination-formular";
	}
	
	@PostMapping("/adddestination/process")
	public String processAddDestination(@Valid @ModelAttribute("destinationModel") DestinationModel destinationModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
			return "adddestination-formular";
		}else {
			destinationService.save(destinationModel);
			model.addAttribute("addSuccess", true);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/registeremployee")
	public String showEmployeeForm(Model model) {
		model.addAttribute("countryList", getCountryList());
		model.addAttribute("userRegisterModel", new UserRegisterModel());
		return "employee-register";
	}
	
	@PostMapping("/registeremployee/process")
	public String createEmployee(@Valid @ModelAttribute("userRegisterModel") UserRegisterModel userModel,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
		return "employee-register";
		}
		
		User user = userService.findUserByEmail(userModel.getEmail());
		
		if(user != null) {
			model.addAttribute("errorUserAlreadyExists", "User with given email already exists");
		return "employee-register";
		}
		
		userService.createEmployee(userModel);
		model.addAttribute("registeredSuccess", true);
		return "redirect:/admin/manageusers";
	}
	
	@RequestMapping("/destinations")
	public String showDestinations(Model model) {
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("destinations", destinationService.getListOfDestinations());
		return "showdestinations";
	}
	
	@RequestMapping("/updatedestination")
	public String showUpdateDestination(@RequestParam(value="id", required=false) Integer id, Model model) {
		if(id==null) {
			return "redirect:/";
		}
		DestinationModel destinationModel= destinationService.getDestinationModel(id.intValue());
		System.out.println(destinationModel);
		if(destinationModel==null) {
			return "redirect:/admin/destinations";
		}else {
			model.addAttribute("destinationModel", destinationModel);
		}
		model.addAttribute("countryList", getCountryList());
		return "updatedestination-formular";
	}
	
	@RequestMapping("/updatedestination/process")
	public String processUpdateDestination(@Valid @ModelAttribute("destinationModel") DestinationModel destinationModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
			return "updatedestination-formular";
		}else {
			destinationService.save(destinationModel);
			model.addAttribute("updateSuccess", true);
			return "redirect:/admin/destinations";		
		}
	}
	
}
