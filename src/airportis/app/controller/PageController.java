package airportis.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;

@Controller
public class PageController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	DestinationService destinationService;
	
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("flights", flightService.getAllFlights(dateFormat.format(date),0));
		return "index";
	}
	
	@GetMapping("/contact")
	public String showContacts() {
		return "contacts";
	}

}
