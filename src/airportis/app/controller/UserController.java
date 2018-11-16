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
import airportis.app.model.UserRegisterModel;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
			List<String> countryList = new ArrayList<String>();
			String[] locales = Locale.getISOCountries();
			for (String countryCode : locales) {
				Locale obj = new Locale("", countryCode);
				countryList.add(obj.getDisplayCountry(Locale.ENGLISH));
			}
			Collections.sort(countryList);
			model.addAttribute("userRegisterModel", new UserRegisterModel());
			model.addAttribute("countryList", countryList);
			return "register";
		}
		return "redirect:/";
	}
	
	@PostMapping("/register/process")
	public String processRegistration(@Valid @ModelAttribute("userRegisterModel") UserRegisterModel userModel,
										BindingResult result, Model model) {
		if(result.hasErrors()) {
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
}
