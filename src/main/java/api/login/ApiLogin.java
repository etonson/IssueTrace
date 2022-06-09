package api.login;

import org.json.JSONObject;

import dao.factory.DAOFactory;
import dao.vo.User;

public class ApiLogin {
	private JSONObject requestData = null;

	public ApiLogin(JSONObject requestData) {
		this.requestData = requestData;
	}

	// request(account,pwd)
	// 有此身份response為1 否則為0
	public int checkExit() {
		JSONObject requestData = this.requestData;
		try {
			String account = requestData.getString("account");
			String pwd = requestData.getString("pwd");
			User user = new User();
			user = DAOFactory.getInstance().checkExistById(account, pwd);
			if (user.getName() != null) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public static void main(String[] args) {
		JSONObject requestData = new JSONObject();
		requestData.put("account", "eton");
		requestData.put("pwd", "123456");
		ApiLogin apiLogin = new ApiLogin(requestData);
		System.out.println(apiLogin.checkExit());
	}
}
