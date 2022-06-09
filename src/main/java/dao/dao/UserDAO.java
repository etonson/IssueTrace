package dao.dao;

import java.util.List;

import dao.vo.User;

public interface UserDAO {
	public boolean doCreate(User user) throws Exception;

	public List<User> findAll() throws Exception;

	public User findById(String account) throws Exception;

	public User checkExistById(String account, String pwd) throws Exception;
}
