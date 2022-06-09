package dao.iml;

import java.util.List;

import dao.dao.TaskForceDAO;
import dao.vo.TaskForce;
import db.conn.DatabaseConnection;

public class TaskForceDAOPoxy implements TaskForceDAO{
	private DatabaseConnection dbc;
	private TaskForceDAOlmp dao = null;

	public TaskForceDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new TaskForceDAOlmp(dbc.getConnection());
	}

	public boolean doCreate(TaskForce taskForce) throws Exception {
		boolean flag = false;
		if (dao.findById(taskForce.getAccount()) == null) {
			flag = dao.doCreate(taskForce);
		}
		dbc.close();
		return flag;
	}

	public List<TaskForce> findAll() throws Exception {
		List<TaskForce> list = dao.findAll();
		dbc.close();
		return list;
	}

	public TaskForce findById(String account) throws Exception {
		TaskForce taskforce = dao.findById(account);
		dbc.close();
		return taskforce;
	}
}
