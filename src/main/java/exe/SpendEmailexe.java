package exe;

import api.email.SpendEmail;
import email.obj.EmailSessionObj;
import email.obj.MsgObj;

public class SpendEmailexe {

	public static void main(String[] args) {
		String user="eton.lin@1177tech.com.tw";
		String pwd="R303bg135";
		EmailSessionObj session = new EmailSessionObj(user,pwd);
		MsgObj msgObj = new MsgObj(user, "this is a mail", "Hello, world!");
		SpendEmail spendDriver = new SpendEmail();
		spendDriver.spendEmail(msgObj, session);
	}


}
