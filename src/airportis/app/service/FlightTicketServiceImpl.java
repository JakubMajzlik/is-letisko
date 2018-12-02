package airportis.app.service;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import airportis.app.dao.DestinationDAO;
import airportis.app.dao.FlightDAO;
import airportis.app.dao.FlightTicketDAO;
import airportis.app.dao.UserDAO;
import airportis.app.entity.FlightTicket;

@Service
public class FlightTicketServiceImpl implements FlightTicketService{

	@Autowired
	FlightTicketDAO flightTicketDAO;
	
	@Autowired
	FlightDAO flightDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	DestinationDAO destinationDAO;

	@Override
	@Transactional
	public void save(FlightTicket flightTicket) {
		flightTicketDAO.save(flightTicket);
		
	}

	@Override
	@Transactional
	public void remove(FlightTicket flightTicket) {
		flightTicketDAO.remove(flightTicket);
		
	}

	@Override
	@Transactional
	public int getEconomicTickets(int id) {
		return flightTicketDAO.getEconomicTickets(id);
	}

	@Override
	@Transactional
	public int getBusinessTickets(int id) {
		return flightTicketDAO.getBusinessTickets(id);
	}

	@Override
	@Transactional
	public int getFirstTickets(int id) {
		return flightTicketDAO.getFirstTickets(id);
	}

	@Override
	@Transactional
	public List<FlightTicket> getAllFlightTickets(String identificationNumber) {
		return flightTicketDAO.getAllTickets(identificationNumber);
		
	}

	@Override
	@Transactional
	public FlightTicket getFlightTicket(int id) {
		return flightTicketDAO.getFlightTicket(id);
	}

	@Override
	@Transactional
	public void generatePDF(FlightTicket flightTicket){
		try {
		ClassLoader classLoader= getClass().getClassLoader();
		PdfReader reader = new PdfReader("file:" + classLoader.getResource("resources/flightTicket.pdf").getPath());
		System.out.println(classLoader.getResource("../").getPath());
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(classLoader.getResource("../").getPath() + "tickets/flightTicket" + flightTicket.getId() + ".pdf"));
		BaseFont font = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		PdfContentByte over = stamper.getOverContent(1);
		
		BarcodeQRCode QRcode = new BarcodeQRCode(Integer.toString(flightTicket.getId()),120,120,null);
		Image image = QRcode.getImage();
		image.setAbsolutePosition(440, 35);
		over.beginText();
		over.setFontAndSize(font, 20);
		over.setTextMatrix(175,305);
		over.showText(Integer.toString(flightTicket.getId()));
		
		over.setTextMatrix(390,305);
		over.showText(flightDAO.getFlight(flightTicket.getFlight()).getTakeoffDate());
		
		over.setTextMatrix(175,240);
		over.showText(Integer.toString(flightTicket.getFlight()));
		
		over.setTextMatrix(390,240);
		over.showText(flightTicket.getSeatClass());
		
		over.setTextMatrix(175,208);
		over.showText("Jamník, Slovakia");
		
		over.setTextMatrix(175,176);
		over.showText(destinationDAO.getDestination(flightDAO.getFlight(flightTicket.getFlight()).getDestination()).getCity()+", "+destinationDAO.getDestination(flightDAO.getFlight(flightTicket.getFlight()).getDestination()).getCountry());
		
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		over.setTextMatrix(175,112);
		over.showText(userDAO.getUserName(userEmail));
		
		over.setTextMatrix(175,80);
		over.showText(userDAO.getUserSurname(userEmail));
		
		over.setFontAndSize(font, 10);
		over.setTextMatrix(325,8);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm");
		Date date = new Date();
		
		over.showText(dateFormat.format(date));
		
		over.addImage(image);
		
		over.endText();
		
		stamper.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
