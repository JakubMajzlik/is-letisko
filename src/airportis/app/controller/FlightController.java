package airportis.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import airportis.app.model.FilterModel;
import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	DestinationService destinationService;
	
	@RequestMapping("/findflight")
	public String showOrderFlightForm(@ModelAttribute("filterModel")FilterModel filterModel, Model model) {
		if(filterModel.getTakeoffDate()==null || filterModel.getDestination()==0) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			model.addAttribute("flights", flightService.getAllFlights(dateFormat.format(date),0));
		}else {
			model.addAttribute("flights", flightService.getAllFlights(filterModel.getTakeoffDate(),filterModel.getDestination()));
		}
		model.addAttribute("destinationService", destinationService);
		
		return "findflight";
	}
	
}
