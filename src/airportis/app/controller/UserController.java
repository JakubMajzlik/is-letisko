package airportis.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import airportis.app.entity.User;
import airportis.app.model.NewPasswordModel;
import airportis.app.model.UserEditModel;
import airportis.app.model.UserRegisterModel;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
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

	@GetMapping("/login")
	public String showLoginForm() {
		if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return "login";
			
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			model.addAttribute("userRegisterModel", new UserRegisterModel());
			model.addAttribute("countryList", getCountryList());
			return "register";
		}
		return "redirect:/";
	}
	
	@PostMapping("/register/process")
	public String processRegistration(@Valid @ModelAttribute("userRegisterModel") UserRegisterModel userModel,
										BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
			return "register";
		}
		
		User user = userService.findUserByEmail(userModel.getEmail());
		
		if(user != null) {
			model.addAttribute("errorUserAlreadyExists", "User with given email already exists");
			return "register";
		}
		
		userService.save(userModel);
		model.addAttribute("successfullyRegistred", true);
		return "redirect:/user/login";
	}
	
	@GetMapping("/editprofile")
	public String showEditProfileFormular(Model model) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(userEmail);
		UserEditModel userModel = userService.getUserModel(user.getId());
		NewPasswordModel passwordModel = new NewPasswordModel();
		passwordModel.setOldUserPassword(user.getPassword());
		System.out.println(passwordModel.getOldUserPassword());
		passwordModel.setId(user.getId());
		
		model.addAttribute("countryList", getCountryList());
		model.addAttribute("userModel", userModel);
		model.addAttribute("passwordModel", passwordModel);
		
		return "user-edituser-formular";
	}
	
	@PostMapping("/editprofile/save")
	public String saveProfile(@Valid @ModelAttribute("userModel") UserEditModel userModel,
								BindingResult result,
								Model model) {
		
		if(result.hasErrors()) {
			NewPasswordModel passwordModel = new NewPasswordModel();
			passwordModel.setOldUserPassword(userModel.getPassword1());
			passwordModel.setId(userModel.getId());
			model.addAttribute("passwordModel", passwordModel);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		userService.update(userModel);
		model.addAttribute("profileChanged", true);
		return "redirect:/user/editprofile";
	}
	
	@PostMapping("/editprofile/savepassword")
	public String saveNewPassword(@Valid @ModelAttribute("passwordModel") NewPasswordModel passwordModel,
									BindingResult result,
									Model model) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(userEmail);
		UserEditModel userModel = userService.getUserModel(user.getId());
		
		if(result.hasErrors()) {
			model.addAttribute("userModel", userModel);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		
		if(!passwordEncoder.matches(passwordModel.getOldPassword(), passwordModel.getOldUserPassword())) {
			model.addAttribute("userModel", userModel);
			model.addAttribute("passwordError", true);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		
		userModel.setPassword1(passwordEncoder.encode(passwordModel.getNewPassword()));
		userService.update(userModel);
		model.addAttribute("passwordChanged", true);
		return "redirect:/user/editprofile";
	}
}
