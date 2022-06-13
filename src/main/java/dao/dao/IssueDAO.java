package dao.dao;

import java.util.List;

import dao.vo.Issue;

public interface IssueDAO {
	public boolean doCreate(Issue issue) throws Exception;

	public List<Issue> findAll() throws Exception;

	public Issue findByrRecipient(String recipient) throws Exception;

	public List<Issue> findAllByRecipient(String recipient) throws Exception;
	
	public List<Issue> findAllByAssigned(String assigness) throws Exception;
	
	public Issue findById(int issueID) throws Exception;
}
