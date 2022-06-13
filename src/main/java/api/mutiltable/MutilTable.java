package api.mutiltable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import db.conn.DatabaseConnection;

public class MutilTable {
	public DatabaseConnection dbc;

	public MutilTable() throws Exception {
		dbc = new DatabaseConnection();
	}

	public JSONObject findCourseListByCourseID(int courseID) {
		JSONObject requestData = null;
		try {
			String sql = "select C.courseID, reply, replyDate, I.issueID, issueTitle"
					+ ", issueDescribe, assigness, startDate, deadDate"
					+ " from IIssue I Right join ICourse C on I.issueID=C.issueID " 
					+ " where C.courseID=? ORDER BY C.courseID";
			PreparedStatement stat;
			stat = dbc.getConnection().prepareStatement(sql);
			stat.setInt(1, courseID);
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				requestData = new JSONObject();
				requestData.put("courseID", rs.getString(1));
				requestData.put("reply", rs.getString(2));
				requestData.put("replyDate", rs.getString(3));
				requestData.put("issueID", rs.getString(4));
				requestData.put("issueTitle", rs.getString(5));
				requestData.put("issueDescribe", rs.getString(6));
				requestData.put("assigness", rs.getString(7));
				requestData.put("startDate", rs.getString(8));
				requestData.put("deadDate", rs.getString(9));
			}
			
			dbc.close();
			return requestData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestData;
	}
	public JSONArray findCourseListByIssueID(int issueID) {
		JSONArray requestArray = null;
		JSONObject requestData = null;
		try {
			String sql = "select C.courseID, I.issueID, issueTitle ,assigness ,replyDate,ststus"
					+ " from IIssue I Right join ICourse C on I.issueID=C.issueID " 
					+ " where I.issueID=? ORDER BY C.courseID";
			PreparedStatement stat;
			stat = dbc.getConnection().prepareStatement(sql);
			stat.setInt(1, issueID);
			ResultSet rs = stat.executeQuery();
			
			requestArray = new JSONArray();
			while (rs.next()) {
				requestData = new JSONObject();
				requestData.put("courseID", rs.getString(1));
				requestData.put("issueID", rs.getString(2));
				requestData.put("issueTitle", rs.getString(3));
				requestData.put("assigness", rs.getString(4));
				requestData.put("replyDate", rs.getString(5));
				requestData.put("ststus", rs.getString(6));
				requestArray.put(requestData);
			}
			
			dbc.close();
			return requestArray;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestArray;
	}
	public JSONArray findCourseListByRecipient(String recipient) {
		JSONArray requestArray = null;
		JSONObject requestData = null;
		try {
			String sql = "select C.courseID, I.issueID, issueTitle ,assigness ,replyDate"
					+ " from IIssue I Right join ICourse C on I.issueID=C.issueID" 
					+ " where I.recipient=? ORDER BY C.courseID";
			PreparedStatement stat;
			stat = dbc.getConnection().prepareStatement(sql);
			stat.setString(1, recipient);
			ResultSet rs = stat.executeQuery();
			
			requestArray = new JSONArray();
			while (rs.next()) {
				requestData = new JSONObject();
				requestData.put("courseID", rs.getString(1));
				requestData.put("issueID", rs.getString(2));
				requestData.put("issueTitle", rs.getString(3));
				requestData.put("assigness", rs.getString(4));
				requestData.put("replyDate", rs.getString(5));
				requestArray.put(requestData);
			}
			
			dbc.close();
			return requestArray;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestArray;
	}

}
