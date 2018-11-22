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
		return "admin-panel";
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
			System.out.println(result.getAllErrors());
			return "addflight-formular";
		}else {
			planeService.save(planeModel);
			model.addAttribute("addSuccess", true);
			return "redirect:/admin/addplane";
		}
	}
	
	@GetMapping("/updateplane")
	public String showUpdatePlaneForm(
			@RequestParam(value="serialNumber", required=false) String serialNumber,
			Model model) {
		if(serialNumber == null) {
			model.addAttribute("planes", planeService.getPlanesList());
			return "updateplane";
		}
		PlaneModel planeModel= planeService.getPlane(serialNumber);
		model.addAttribute("planeService", planeService);
		if(planeModel== null) {
			model.addAttribute("planeModel", new PlaneModel());
			model.addAttribute("errorPlaneNotFound", true);
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
			System.out.println(planeModel.getSerialNumber());
			planeService.save(planeModel);
			model.addAttribute("addSuccess", true);
			return "redirect:/admin/updateplane";		
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
	
}
