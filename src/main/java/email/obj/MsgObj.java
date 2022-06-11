package email.obj;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MsgObj {
	String recipients;
	String subject;
	String context;

	public MsgObj(String recipients, String subject, String context) {
		this.recipients = recipients;
		this.subject = subject;
		this.context = context;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public MimeMessage getMsgObj(EmailSessionObj sessionobj) {
		MimeMessage msg = null;
		try {
			msg = new MimeMessage(sessionobj.getSessionObj());
			msg.setFrom(sessionobj.UserName);
			msg.setRecipients(Message.RecipientType.TO, this.recipients);
			msg.setSubject(this.subject);
			msg.setSentDate(new Date());
			msg.setText(this.context);
			Transport.send(msg, sessionobj.UserName, sessionobj.Password);
			return msg;
		} catch (MessagingException mex) {
			System.out.println("send failed, exception: " + mex);
			return msg;
		}
	}

}
