package Day8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class sqlConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		ResultSet selestResult = null;
		Statement stmt = null;

		
		try {
			Driver d1 = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			
			stmt = conn.createStatement();
			//stmt.executeUpdate("insert into city " + "values ('4080','Highland Village', 'USA', 'Texas', '10')");
			stmt.executeUpdate("update city set Population = '16701' where Name = 'Highland Village'");
			
			selestResult = stmt.executeQuery("SELECT * from city where name = \"Highland Village\"");
			

			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (selestResult.next()) {
			System.out.println(selestResult.getInt("ID")+" " + selestResult.getString("Name") + selestResult.getInt("Population"));
			//System.out.println(selestResult.getInt(1)+ " " + selestResult.getString(2) + " " + selestResult.getInt(5));
		}
	}

}
