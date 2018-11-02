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

import airportis.app.dao.PlaneService;
import airportis.app.model.FlightModel;
import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;
import airportis.app.service.GateService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired 
	PlaneService planseService;
	
	@Autowired 
	GateService gateService;
	
	@GetMapping("/addflight")
	public String showFlightForm(Model model) {
		model.addAttribute("flightModel", new FlightModel());
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("planeService", planseService);
		model.addAttribute("gateService", gateService);
		return "addflight-formular";
	}

	@PostMapping("/addflight/process")
	public String processAddFlight(@Valid @ModelAttribute("flightModel") FlightModel flightModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "addflightaaaaaa-formular";
		}else {
			flightService.save(flightModel);
			model.addAttribute("addSuccess", true);
			return "redirect:/admin/addflight";
		}
	}
	
	//TODO
	
	@GetMapping("/updateflight")
	public String showUpdateFlightForm(@RequestParam("id") int id, Model model) {
		FlightModel flightModel= flightService.getFlight(id);
		model.addAttribute("destinationService", destinationService);
		if(flightModel== null) {
			model.addAttribute("flightModel", new FlightModel());
			model.addAttribute("errorFlightNotFound", true);
		}else {
			model.addAttribute("flightModel", flightModel);
		}
		return "updateflight-formular";
	}
	
	@PostMapping("/updateflight/process")
	public String processUpdateFlight(@Valid @ModelAttribute("flightModel") FlightModel flightModel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "updateflight-formular";
		}else {
			flightService.save(flightModel);
			model.addAttribute("addSuccess", true);
			return "updateflight-formular";		
		}
	}
	
}
