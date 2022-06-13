package exe;

import dao.factory.DAOFactory;
import dao.vo.Issue;

public class TestSelectDAO {
	public static void main(String[] args) {
		try {

			Issue issue = DAOFactory.getIssueInstance().findById(Integer.parseInt("18"));
			System.out.println(issue.getIssueID());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}