package airportis.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import airportis.app.entity.FlightTicket;
import airportis.app.model.FilterModel;
import airportis.app.model.FlightModel;
import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;
import airportis.app.service.FlightTicketService;
import airportis.app.service.PlaneService;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	PlaneService planeService;
	
	@Autowired
	FlightTicketService flightTicketService;
	
	@RequestMapping("/findflight")
	public String showFindFlightForm(@RequestParam(value="id", required=false)Integer id, @ModelAttribute("filterModel")FilterModel filterModel, Model model) {
		if(id == null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
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
		FlightModel flightModel= flightService.getFlightModel(id);
		double minutes, hours;
		hours= destinationService.getDestinationDistance(flightModel.getDestination())/650.0;
		minutes= (destinationService.getDestinationDistance(flightModel.getDestination())%650.0/650.0*60)+20;
		if(minutes>=60) {
			hours++;
			minutes-=60;
		}
		model.addAttribute("flightModel", flightModel);
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("minutes", minutes);
		model.addAttribute("hours", hours);
		model.addAttribute("id", id);
		model.addAttribute("economic", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsEconomic() - flightTicketService.getEconomicTickets(id));
		model.addAttribute("business", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsBusiness() - flightTicketService.getBusinessTickets(id));
		model.addAttribute("first", planeService.getPlane(flightModel.getPlane()).getNumberOfSeatsFirst() - flightTicketService.getFirstTickets(id));
		
		return "flightdetails";
		
	}
	
	@RequestMapping("/orderflight")
	public String showOrderFlightForm(@RequestParam(value="class", required=false)Integer ticket_class,  @ModelAttribute("flightModel")FlightModel flightModel, Model model) {
		if(ticket_class == null) {
			return "findflight";
		}
		double minutes, hours;
		hours= destinationService.getDestinationDistance(flightModel.getDestination())/650.0;
		minutes= (destinationService.getDestinationDistance(flightModel.getDestination())%650.0/650.0*60)+20;
		if(minutes>=60) {
			hours++;
			minutes-=60;
		}
		model.addAttribute("flightModel", flightModel);
		model.addAttribute("destinationService", destinationService);
		model.addAttribute("minutes", minutes);
		model.addAttribute("hours", hours);
		model.addAttribute("id", flightModel.getId());
		model.addAttribute("ticket_class", ticket_class);
		return "orderflight";
	}
	
	@RequestMapping("/orderflight/process")
	public String processOrderFlight(@RequestParam(value="class", required=false)Integer ticket_class, @ModelAttribute("flightModel")FlightModel flightModel) {
		
		String email= SecurityContextHolder.getContext().getAuthentication().getName();
		String idNumber= userService.findUserByEmail(email).getDetails().getIdentificationNumber();
		FlightTicket flightTicket;
		if(ticket_class==1) {
			flightTicket= new FlightTicket(
					flightModel.getId(),
					"Economic",
					idNumber);
		}else if(ticket_class==2) {
			flightTicket= new FlightTicket(
					flightModel.getId(),
					"Business",
					idNumber);
		}else {
			flightTicket= new FlightTicket(
					flightModel.getId(),
					"First",
					idNumber);
		}
		
		flightTicketService.save(flightTicket);
		flightTicketService.generatePDF(flightTicket);

		return "redirect:/flight/orderconfirmation?id="+flightTicket.getId();
	}
	
	@RequestMapping("/orderconfirmation")
	public String showOrderConfirmation(@RequestParam(value="id", required=false)Integer id, Model model) {
		System.out.println("TEST");
		model.addAttribute("id", id);
		return "orderconfirmation";
	}
}
