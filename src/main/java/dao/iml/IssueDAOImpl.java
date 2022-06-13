package dao.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.dao.IssueDAO;
import dao.vo.Issue;

public class IssueDAOImpl implements IssueDAO {
	private Connection con;
	private PreparedStatement stat = null;

	public IssueDAOImpl(Connection con) {
		this.con = con;
	}

	public boolean doCreate(Issue issue) throws Exception {
		String sql = "INSERT INTO IIssue(issueTitle," 
					+ " issueDescribe,status,recipient,"
					+ "  assigness,startDate,deadDate)" 
					+ " VALUES(?,?,?,?,?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setNString(1, issue.getiIssueTitle());
		stat.setNString(2, issue.getIssueDescribe());
		stat.setInt(3, issue.getStatus());
		stat.setString(4, issue.getRecipient());
		stat.setString(5, issue.getAssigness());
		stat.setString(6, issue.getStartDate());
		stat.setString(7, issue.getDeadDate());
		int update = stat.executeUpdate();
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Issue> findAll() throws Exception {
		String sql = "SELECT issueID,issueTitle,issueDescribe,status,recipient,"
				+ " assigness,startDate,deadDate FROM IIssue ORDER BY issueID";
		stat = con.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		List<Issue> list = new ArrayList<Issue>();
		while (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			String issueDescribe = rs.getString(3);
			int status = Integer.parseInt(rs.getString(4));
			String recipient = rs.getString(5);
			String assigness = rs.getString(6);
			String startDate = rs.getString(7);
			String deadDate = rs.getString(8);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setIssueDescribe(issueDescribe);
			issue.setStatus(status);
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
			list.add(issue);
		}
		return list;
	}
	public List<Issue> findAllByAssigned(String assigness) throws Exception {
		String sql = "SELECT issueID,issueTitle,status,recipient,"
				+ " assigness,startDate,deadDate FROM IIssue WHERE assigness=? ORDER BY issueID";
		stat = con.prepareStatement(sql);
		stat.setString(1, assigness);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		List<Issue> list = new ArrayList<Issue>();
		while (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			int status = Integer.parseInt(rs.getString(3));
			String recipient = rs.getString(4);
			String startDate = rs.getString(5);
			String deadDate = rs.getString(6);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setStatus(status);
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
			list.add(issue);
		}
		return list;
	}
	public List<Issue> findAllByRecipient(String recipient) throws Exception {
		String sql = "SELECT issueID,issueTitle,status,recipient,"
				+ " assigness,startDate,deadDate FROM IIssue WHERE recipient=? ORDER BY issueID";
		stat = con.prepareStatement(sql);
		stat.setString(1, recipient);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		List<Issue> list = new ArrayList<Issue>();
		while (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			int status = Integer.parseInt(rs.getString(3));
			String assigness = rs.getString(5);
			String startDate = rs.getString(6);
			String deadDate = rs.getString(7);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setStatus(status);
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
			list.add(issue);
		}
		return list;
	}

	public Issue findByrRecipient(String recipient) throws Exception {
		String sql = "SELECT issueID,issueTitle,issueDescribe,status,recipient,"
				+ " assigness,startDate,deadDate FROM IIssue WHERE recipient=?";
		stat = con.prepareStatement(sql);
		stat.setString(1, recipient);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		if (rs.next()) {
			int issueID = Integer.parseInt(rs.getString(1));
			String issueTitle = rs.getString(2);
			String issueDescribe = rs.getString(3);
			String status = rs.getString(4);
			String assigness = rs.getString(6);
			String startDate = rs.getString(7);
			String deadDate = rs.getString(8);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setIssueDescribe(issueDescribe);
			issue.setStatus(Integer.parseInt(status));
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
		}
		return issue;
	}
	public Issue findById(int issueID) throws Exception {
		String sql = "SELECT issueID,issueTitle,issueDescribe,status,recipient,"
				+ "assigness,startDate,deadDate FROM IIssue WHERE issueID=?";
		stat = con.prepareStatement(sql);
		stat.setInt(1, issueID);
		ResultSet rs = stat.executeQuery();
		Issue issue = null;
		if (rs.next()) {
			String issueTitle = rs.getString(2);
			String issueDescribe = rs.getString(3);
			String status = rs.getString(4);
			String recipient = rs.getString(5);
			String assigness = rs.getString(6);
			String startDate = rs.getString(7);
			String deadDate = rs.getString(8);

			issue = new Issue();
			issue.setIssueID(issueID);
			issue.setIssueTitle(issueTitle);
			issue.setIssueDescribe(issueDescribe);
			issue.setStatus(Integer.parseInt(status));
			issue.setRecipient(recipient);
			issue.setAssigness(assigness);
			issue.setStartDate(startDate);
			issue.setDeadDate(deadDate);
		}
		return issue;
	}
}
