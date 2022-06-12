package api.login;

import dao.factory.DAOFactory;
import dao.vo.User;

public class UserInfo {
	public UserInfo() {
	}

	public String findEmailByUserId(String userID) {
		DAOFactory da=null;
		User user =null; 
		try {
			da = new DAOFactory();
		user = da.getInstance().findById(userID);
		return user.getEmail();}
		catch(Exception e) 
		{
			return e.getMessage();
		}
	}
}
