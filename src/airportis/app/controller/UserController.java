package airportis.app.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import airportis.app.dao.UserDAO;
import airportis.app.entity.FlightTicket;
import airportis.app.entity.User;
import airportis.app.model.NewPasswordModel;
import airportis.app.model.UserEditModel;
import airportis.app.model.UserRegisterModel;
import airportis.app.service.DestinationService;
import airportis.app.service.FlightService;
import airportis.app.service.FlightTicketService;
import airportis.app.service.MailService;
import airportis.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	FlightTicketService flightTicketService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	List<String> getCountryList() {
		List<String> countryList = new ArrayList<String>();
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			countryList.add(obj.getDisplayCountry(Locale.ENGLISH));
		}
		Collections.sort(countryList);
		return countryList;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/login")
	public String showLoginForm() {
		if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return "login";
			
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			model.addAttribute("userRegisterModel", new UserRegisterModel());
			model.addAttribute("countryList", getCountryList());
			return "register";
		}
		return "redirect:/";
	}
	
	@PostMapping("/register/process")
	public String processRegistration(@Valid @ModelAttribute("userRegisterModel") UserRegisterModel userModel,
										BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("countryList", getCountryList());
			return "register";
		}
		
		User user = userService.findUserByEmail(userModel.getEmail());
		
		if(user != null) {
			model.addAttribute("errorUserAlreadyExists", "User with given email already exists");
			return "register";
		}
		
		userService.save(userModel);
		mailService.sendMail(userModel.getEmail());
		model.addAttribute("successfullyRegistred", true);
		return "registersuccess";
	}
	
	@GetMapping("/editprofile")
	public String showEditProfileFormular(Model model) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(userEmail);
		UserEditModel userModel = userService.getUserModel(user.getId());
		NewPasswordModel passwordModel = new NewPasswordModel();
		passwordModel.setOldUserPassword(user.getPassword());
		System.out.println(passwordModel.getOldUserPassword());
		passwordModel.setId(user.getId());
		
		model.addAttribute("countryList", getCountryList());
		model.addAttribute("userModel", userModel);
		model.addAttribute("passwordModel", passwordModel);
		
		return "user-edituser-formular";
	}
	
	@PostMapping("/editprofile/save")
	public String saveProfile(@Valid @ModelAttribute("userModel") UserEditModel userModel,
								BindingResult result,
								Model model) {
		
		if(result.hasErrors()) {
			NewPasswordModel passwordModel = new NewPasswordModel();
			passwordModel.setOldUserPassword(userModel.getPassword1());
			passwordModel.setId(userModel.getId());
			model.addAttribute("passwordModel", passwordModel);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		userService.update(userModel);
		model.addAttribute("profileChanged", true);
		return "redirect:/user/editprofile";
	}
	
	@PostMapping("/editprofile/savepassword")
	public String saveNewPassword(@Valid @ModelAttribute("passwordModel") NewPasswordModel passwordModel,
									BindingResult result,
									Model model) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(userEmail);
		UserEditModel userModel = userService.getUserModel(user.getId());
		
		if(result.hasErrors()) {
			model.addAttribute("userModel", userModel);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		
		if(!passwordEncoder.matches(passwordModel.getOldPassword(), passwordModel.getOldUserPassword())) {
			model.addAttribute("userModel", userModel);
			model.addAttribute("passwordError", true);
			model.addAttribute("countryList", getCountryList());
			return "user-edituser-formular";
		}
		
		userModel.setPassword1(passwordEncoder.encode(passwordModel.getNewPassword()));
		userService.update(userModel);
		model.addAttribute("passwordChanged", true);
		return "redirect:/user/editprofile";
	}
	
	@RequestMapping("/history")
	public String showHistory(Model model) {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		String idNumber= userService.findUserByEmail(userEmail).getDetails().getIdentificationNumber();
		List<FlightTicket> flightTickets= flightTicketService.getAllFlightTickets(idNumber);
		model.addAttribute("flightTickets", flightTickets);
		model.addAttribute("flightService", flightService);
		model.addAttribute("destinationService", destinationService);
		Map<Integer, Boolean> stornoMap= new HashMap<Integer, Boolean>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd kk:mm");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate= LocalDate.parse(dateFormat.format(date), formatter1);
		for (FlightTicket flightTicket : flightTickets) {
			LocalDate takeoffDate= LocalDate.parse(flightService.getFlight(flightTicket.getFlight()).getTakeoffDate(), formatter);
			if(localDate.compareTo(takeoffDate)<0) {
				stornoMap.put(flightTicket.getId(), true);
			}else {
				stornoMap.put(flightTicket.getId(), false);
			}
		}
		model.addAttribute("stornoMap", stornoMap);
		return "history";
	}
	
	@RequestMapping("/history/downloadticket")
	public void downloadTicket(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id", required=false)Integer id) {
		if(id!=null) {
			FlightTicket flightTicket= flightTicketService.getFlightTicket(id);
			if(flightTicket!=null) {
				String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
				String idNumber= userService.findUserByEmail(userEmail).getDetails().getIdentificationNumber();
				if(flightTicket.getUserIdentificationNumber().equals(idNumber)) {
					ClassLoader classLoader= getClass().getClassLoader();
					File file = new File(classLoader.getResource("../").getPath() + "tickets/flightTicket"+id+".pdf");
					String mimeType = URLConnection.guessContentTypeFromName(file.getName());
					response.setContentType(mimeType);
					response.setHeader("Content-Disposition", String.format("attachment;filename=\""+file.getName()+"\""));
					response.setContentLength((int)file.length());
					try {
						BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
						try {
							FileCopyUtils.copy(inputStream, response.getOutputStream());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}else {
					try {
						response.sendRedirect(request.getContextPath());
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				try {
					response.sendRedirect(request.getContextPath());
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}else {
			try {
				response.sendRedirect(request.getContextPath());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/history/storno")
	public String stornoTicket(@RequestParam(value="id", required=false)Integer id) {
		if(id==null) {
			return "history";
		}
		FlightTicket flightTicket= flightTicketService.getFlightTicket(id);
		flightTicketService.remove(flightTicket);
		return "redirect:/user/history";
	}
	
	@RequestMapping("/activate")
	public String activateAccount(@RequestParam(value="token", required=true)String token) {
		User user = userService.getUserByToken(token);
		if(user==null) {
			return "redirect:/";
		}else {
			user.setEnabled(true);
			userService.removeToken(user);
			userService.save(user);
			return "redirect:/user/login";
		}
	}
}
