package dao.iml;

import java.util.TreeMap;

import db.conn.DatabaseConnection;

public class MutilTableDAOPoxy {
	private DatabaseConnection dbc;
	private MutilTableDAOImp dao = null;

	public MutilTableDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new MutilTableDAOImp(dbc.getConnection());
	}

	public TreeMap<String, String> showCourseRespomseTableBycourseID(int issueID) throws Exception {
		TreeMap<String, String> courseResourceMap = dao.showCourseRespomseTableBycourseID(issueID);
		dbc.close();
		return courseResourceMap;
	}
}
