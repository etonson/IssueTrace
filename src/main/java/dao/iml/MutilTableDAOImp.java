package dao.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import exception.ReferenceExceptionError;

public class MutilTableDAOImp {
	private Connection con;
	private PreparedStatement stat = null;

	public MutilTableDAOImp(Connection con) {
		this.con = con;
	}

	public TreeMap<String, String> showCourseRespomseTableBycourseID(int issueID) {
		TreeMap<String, String> tmpMap = null;
		try {
			String sql = "select C.courseID, issueTitle ,assigness ,startDate "
					+ "from IIssue I Right join ICourse C on I.issueID=C.issueID " 
					+ "where I.issueID=?";

			stat = con.prepareStatement(sql);
			stat.setInt(1, issueID);
			ResultSet rs = stat.executeQuery();
			tmpMap = new TreeMap<String, String>();
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				tmpMap.put("issueID", rs.getString(1));
				tmpMap.put("issueTitle", rs.getString(2));
				tmpMap.put("assigness", rs.getString(3));
				tmpMap.put("startDate", rs.getString(4));
			}
			return tmpMap;
		} catch (Exception e) {
			ReferenceExceptionError restException = new ReferenceExceptionError(e, e);
			System.out.println(restException.getExceptionCode());
			System.out.println(restException.getMsg());
		}
		return tmpMap;
	}
}
