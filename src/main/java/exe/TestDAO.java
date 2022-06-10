package exe;

import dao.factory.DAOFactory;
import dao.vo.User;

public class TestDAO {
	public static void main(String args[]) throws Exception {
		User emp = null;
		try {
			emp = new User();
			emp.setAccount("remon");
			emp.setEmail("spen@123");
			emp.setName("remon");
			emp.setPwd("123456");

			DAOFactory.getInstance().doCreate(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			emp = new User();
			emp.setAccount("kevin");
			emp.setEmail("spen@123");
			emp.setName("kevin");
			emp.setPwd("123456");

			DAOFactory.getInstance().doCreate(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}