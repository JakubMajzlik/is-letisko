package airportis.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import airportis.app.model.FilterModel;
import airportis.app.model.FlightModel;
import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;
import airportis.app.service.FlightTicketService;
import airportis.app.service.PlaneService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	PlaneService planeService;
	
	@Autowired
	FlightTicketService flightTicketService;
	
	@RequestMapping("/findflight")
	public String showFindFlightForm(@RequestParam(value="id", required=false)Integer id, @ModelAttribute("filterModel")FilterModel filterModel, Model model) {
		if(id == null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
			Date date = new Date();
			System.out.println("MODEL DATE: "+filterModel.getTakeoffDate());
			if(filterModel.getTakeoffDate()==null && filterModel.getDestination()==0) {	
				model.addAttribute("flights", flightService.getAllFlights(dateFormat.format(date),0));
			}else {
				if(filterModel.getTakeoffDate()==null || filterModel.getTakeoffDate()=="") {
					model.addAttribute("flights", flightService.getAllFlights(dateFormat.format(date),filterModel.getDestination()));
				}else {
					model.addAttribute("flights", flightService.getAllFlights(filterModel.getTakeoffDate(),filterModel.getDestination()));
				}
				
			}
			model.addAttribute("destinationService", destinationService);
			model.addAttribute("flightTicketService", flightTicketService);
			
			return "findflight";
		}
		FlightModel flightModel= flightService.getFlight(id);
		model.addAttribute("flightModel", flightModel);
		model.addAttribute("economic", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsEconomic() - flightTicketService.getEconomicTickets(id));
		model.addAttribute("business", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsBusiness() - flightTicketService.getBusinessTickets(id));
		model.addAttribute("first", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsFirst() - flightTicketService.getFirstTickets(id));
		return "orderflight";
		
	}
	
	@RequestMapping("/orderflight")
	public String showOrderFlightForm(@ModelAttribute("flightModel")FlightModel flightModel, Model model) {
		return "orderflight";
	}
	
}
