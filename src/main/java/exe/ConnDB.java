package exe;

import org.json.JSONObject;

import api.mutiltable.MutilTable;

public class ConnDB {

	public static void main(String[] args) {
		try {
			MutilTable mt = new MutilTable();
			 JSONObject obj = mt.findCourseListByCourseID(11);
				 System.out.println(obj.toString());
			
		} catch (Exception e) {

		}
	}
}
