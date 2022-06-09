package exe;

import java.util.ArrayList;
import java.util.List;

import dao.factory.DAOFactory;
import dao.vo.User;

public class TestSelectDAO {
	public static void main(String[] args) {
		try {
			List<User> list = new ArrayList<User>();
			User user = new User();
			user = DAOFactory.getInstance().checkExistById("eton", "123456");
			System.out.println(user.getName());
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getName());
//			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}