package api.email;

import javax.mail.MessagingException;
import javax.mail.Transport;

import email.obj.EmailSessionObj;
import email.obj.MsgObj;

public class SpendEmail {
	public SpendEmail() {
	}

	public boolean spendEmail(MsgObj msgObj, EmailSessionObj sessionObj) {
		try {
			Transport.send(msgObj.getMsgObj(sessionObj), sessionObj.UserName, sessionObj.Password);
			return true;
		} catch (MessagingException mex) {
			System.out.println("send failed, exception: " + mex);
			return false;
		}
	}
}
