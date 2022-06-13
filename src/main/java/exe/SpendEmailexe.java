package exe;

import api.email.SpendEmail;
import email.obj.EmailSessionObj;
import email.obj.MsgObj;

public class SpendEmailexe {

	public static void main(String[] args) {
		String user="eton.lin@1177tech.com.tw";
		String pwd="R303bg135";
		EmailSessionObj sessionObj = new EmailSessionObj(user,pwd);
		MsgObj msgObj = new MsgObj(user, "這是一封測是郵件", "測試是否有亂碼");
		SpendEmail spendDriver = new SpendEmail();
		spendDriver.spendEmail(msgObj, sessionObj);
	}
}
