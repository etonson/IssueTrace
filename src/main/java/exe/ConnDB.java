package exe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import exception.ReferenceException;

public class ConnDB {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=IssueTrace";
	private static final String USER = "sa";
	private static final String PASSWORD = "Aa123456";

	public static void main(String[] args) {
		try {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement stat;
		String sql = "INSERT INTO ICourse(issueID,replyDate,reply)VALUES(?,?,?)";
		stat = con.prepareStatement(sql);
		stat.setInt(1, 8);
		stat.setString(2, "fdsfs");
		stat.setString(3, "abc");
		stat.executeUpdate();
		}catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println(e.fillInStackTrace());
			ReferenceException restException =  new ReferenceException(e.getStackTrace().toString(),e.getCause().toString());
			System.out.println(restException.getExceptionCode());
			System.out.println(restException.getMsg());
		}
	}
}
