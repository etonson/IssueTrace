package email.obj;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailSessionObj extends EmailObj {
	public String UserName;
	public String Password;

	public EmailSessionObj(String UserName, String Password) {
		this.UserName = UserName;
		this.Password = Password;
	}

	public Session getSessionObj() {
		Properties pro = super.getProperties();
		String Name = this.UserName;
		String Password = this.Password;
		Session session = Session.getInstance(pro, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Name, Password);
			}
		});
		return session;
	}
}
