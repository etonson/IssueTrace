package email.obj;

import java.util.Properties;

public class EmailObj {
	private String SMTPhost = "smtp.office365.com";
	private String SMTPport = "587";
	private String SmtpStarttlsEnable = "true";
	private boolean Auth = true;

	public EmailObj() {
	}

	public EmailObj(String SMTPhost, String SMTPport, String SmtpStarttlsEnable) {
		this.SMTPhost = SMTPhost;
		this.SMTPport = SMTPport;
		this.SmtpStarttlsEnable = SmtpStarttlsEnable;
	}

	public String getSMTPhost() {
		return SMTPhost;
	}

	public String getSMTPport() {
		return SMTPport;
	}

	public String getSmtpStarttlsEnable() {
		return SmtpStarttlsEnable;
	}

	public boolean getAuth(boolean Auth) {
		return Auth;
	}

	public void setSMTPhost(String SMTPhost) {
		this.SMTPhost = SMTPhost;
	}

	public void setSMTPport(String SMTPport) {
		this.SMTPport = SMTPport;
	}

	public void setSmtpStarttlsEnable(String SmtpStarttlsEnable) {
		this.SmtpStarttlsEnable = SmtpStarttlsEnable;
	}

	public void setAuth(boolean Auth) {
		this.Auth = Auth;
	}

	public Properties getProperties() {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", this.Auth);
		prop.put("mail.smtp.starttls.enable", this.SmtpStarttlsEnable);
		prop.put("mail.smtp.host", this.SMTPhost);
		prop.put("mail.smtp.port", this.SMTPport);
		prop.setProperty("mail.smtp.host", this.SMTPhost);
		return prop;
	}
}
