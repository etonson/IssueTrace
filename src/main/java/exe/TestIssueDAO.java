package exe;

import dao.factory.DAOFactory;
import dao.vo.Issue;

public class TestIssueDAO {

	public static void main(String[] args) {
		Issue emp = null;
		try {
			emp = new Issue();
			emp.setIssueTitle("測試文件");
			emp.setIssueDescribe("測試內容");
			emp.setStatus(1);
			emp.setRecipient("eton");
			emp.setAssigness("kevin");
			emp.setStartDate("2022-06-23");
			emp.setDeadDate("2022-06-30");
			DAOFactory.getIssueInstance().doCreate(emp);
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

}
