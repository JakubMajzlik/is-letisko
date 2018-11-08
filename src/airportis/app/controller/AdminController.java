package airportis.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import airportis.app.entity.User;
import airportis.app.model.UserEditModel;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
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
		
		model.addAttribute("userModel", userModel);
		
		return "admin-edituser-formular";
	}
	
	@PostMapping("/manageusers/edit/save")
	public String saveUserDetails(
			@Valid @ModelAttribute("userModel")UserEditModel userModel, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/manageusers/edituser?id="+userModel.getId();
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
	
}
