package exe;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class SEmail {

	public static void main(String[] args) {
	      String to = "eton052096@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "eton.lin@1177tech.com.tw";

	      // Assuming you are sending email from localhost
	      String host = "smtp.office365.com";
	      Properties prop = new Properties();
	      prop.put("mail.smtp.auth", true);
	      prop.put("mail.smtp.starttls.enable", "true");
	      prop.put("mail.smtp.host", host);
	      prop.put("mail.smtp.port", "587");

	      // Setup mail server
	      prop.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getInstance(prop, new Authenticator() {
	    	    @Override
	    	    protected PasswordAuthentication getPasswordAuthentication() {
	    	        return new PasswordAuthentication(from, "R303bg135");
	    	    }
	    	});


	    try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom("eton.lin@1177tech.com.tw");
	        msg.setRecipients(Message.RecipientType.TO,
	                          "eton.lin@1177tech.com.tw");
	        msg.setSubject("JavaMail hello world example");
	        msg.setSentDate(new Date());
	        msg.setText("Hello, world!\n");
	        Transport.send(msg, to, "R303bg135");
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	    }
	}

}
