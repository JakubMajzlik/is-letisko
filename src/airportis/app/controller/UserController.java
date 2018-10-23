package airportis.app.controller;

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
		
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("userRegisterModel", new UserRegisterModel());
		return "register";
	}
	
	@PostMapping("/register/process")
	public String processRegistration(@Valid @ModelAttribute("userRegistrationModel") UserRegisterModel userModel,
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
		
		return "register-confirmation";
	}
}
