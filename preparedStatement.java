package Day8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class preparedStatement {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		ResultSet selectResult = null;
		PreparedStatement pStmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
//			pStmt = conn.prepareStatement("insert into city values (?, ?, ?, ?)");
//			
//			pStmt.setInt(1, 4181);
//			pStmt.setString(2, "Flower Mound");
//			pStmt.setString(3,"USA");
//			pStmt.setString(4, "Texas");
//			pStmt.setInt(5, 78854);
			
			//System.out.println(pStmt.executeUpdate());
			pStmt = conn.prepareStatement("select * from city where CountryCode = 'USA'");
			
			//pStmt.setString(3, "USA");
			selectResult = pStmt.executeQuery();
			
			while (selectResult.next()) {
				//System.out.println(selectResult.getInt("ID")+" " + selectResult.getString("Name") + selectResult.getInt("Population"));
				System.out.println(selectResult.getInt(1)+ " " + selectResult.getString(2) + " " + selectResult.getInt(5));
			}
			
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
