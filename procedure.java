package Day8;

import java.sql.*;

public class procedure {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		CallableStatement cs = null;
		ResultSet selectResult = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			//Created a stored procedure in city database to print all results in descending order
			cs = con.prepareCall("{call GetAllCities}");

			selectResult = cs.executeQuery();
			while (selectResult.next()) {
				System.out.println(selectResult.getInt("ID")+" " + selectResult.getString("Name") + selectResult.getInt("Population"));
				//System.out.println(selectResult.getInt(1)+ " " + selectResult.getString(2) + " " + selectResult.getInt(5));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

}
