package airportis.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import airportis.app.service.FlightService;

@Controller
public class PageController {
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("flights", flightService.getAllFlights());
		return "index";
	}
	
	@GetMapping("/contact")
	public String showContacts() {
		return "contacts";
	}

}
