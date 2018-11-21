package airportis.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/contact")
	public String showContacts() {
		return "contacts";
	}

}
