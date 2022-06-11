package exe;

import email.obj.EmailSessionObj;

public class ExercieSpendEmail {

	public static void main(String[] args) {
		String user="eton.lin@1177tech.com.tw";
		String pwd="R303bg135";
		EmailSessionObj session = new EmailSessionObj(user,pwd);
		session.setSMTPport("100");
		System.out.println(session.getSMTPport());
	}

}
