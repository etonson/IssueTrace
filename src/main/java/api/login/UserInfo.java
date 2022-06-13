package api.login;

import dao.factory.DAOFactory;
import dao.vo.Course;
import dao.vo.Issue;
import dao.vo.User;

public class UserInfo {
	public UserInfo() {
	}

	public String findEmailByUserId(String userID) {
		User user = null;
		try {
			user = DAOFactory.getInstance().findById(userID);
			return user.getEmail();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String findPwdByUserId(String userID) {
		User user = null;
		try {
			user = DAOFactory.getInstance().findById(userID);
			return user.getPwd();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public User getAssignedUserByIssueID(String issueID) {
		try {
			Issue issue = DAOFactory.getIssueInstance().findById(Integer.parseInt(issueID));
			User user = DAOFactory.getInstance().findById(issue.getRecipient());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getRecipientedUserByIssueID(String issueID) {
		try {
			Issue issue = DAOFactory.getIssueInstance().findById(Integer.parseInt(issueID));
			User user = DAOFactory.getInstance().findById(issue.getRecipient());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		UserInfo ui = new UserInfo();
		User user = ui.getAssignedUserByIssueID("14");
		System.out.println(user.getPwd());
	}
}
