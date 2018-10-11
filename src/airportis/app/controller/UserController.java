package airportis.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import airportis.app.model.UserLoginModel;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("userLoginModel", new UserLoginModel());
		return "login";
	}
	
}
