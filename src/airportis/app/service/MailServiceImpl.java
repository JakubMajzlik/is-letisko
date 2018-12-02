package airportis.app.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import airportis.app.dao.UserDAO;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public void sendMail(String email) {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("jamnikairport@gmail.com","chikibriki");
		    }
		});
		
		Message message = new MimeMessage(session);
		try {
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Account confirmation");
			userDAO.saveToken(userDAO.findUserByEmail(email));
			String msg = "You have successfuly created account on Jamnik Airport Information System.<br>"+
						 "To activate your account please follow the link below or copy it into your web browser.<br>"+
						 "http://localhost:8080/Airportis/user/activate?token=" + userDAO.getToken(userDAO.findUserByEmail(email));
			 
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			 
			message.setContent(multipart);
			 
			Transport.send(message);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
