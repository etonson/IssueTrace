package dao.iml;

import java.util.List;

import dao.dao.IssueDAO;
import dao.vo.Issue;
import db.conn.DatabaseConnection;

public class IssueDAOPoxy implements IssueDAO {
	private DatabaseConnection dbc;
	private IssueDAOImpl dao = null;

	public IssueDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new IssueDAOImpl(dbc.getConnection());
	}

	public boolean doCreate(Issue issue) throws Exception {
		boolean flag = false;
			flag = dao.doCreate(issue);
		dbc.close();
		return flag;
	}

	public List<Issue> findAll() throws Exception {
		List<Issue> list = dao.findAll();
		dbc.close();
		return list;
	}

	public List<Issue> findAllByRecipient(String recipient) throws Exception {
		List<Issue> list = dao.findAllByRecipient(recipient);
		dbc.close();
		return list;
	}
	public List<Issue> findAllByAssigned(String assigness) throws Exception {
		List<Issue> list = dao.findAllByRecipient(assigness);
		dbc.close();
		return list;
	}
	public Issue findById(int issueID) throws Exception {
		Issue issue = dao.findById(issueID);
		dbc.close();
		return issue;
	}
	
	public Issue findByrRecipient(String recipient) throws Exception
	{
		Issue issue = dao.findByrRecipient(recipient);
		dbc.close();
		return issue;
	}
}