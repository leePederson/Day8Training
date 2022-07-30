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
		ResultSet updateResult = null;
		PreparedStatement pStmt = null;
		PreparedStatement pStmt2 = null;
		PreparedStatement pStmt3 = null;
		try {
			//Insert Prepared Statement
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			pStmt = conn.prepareStatement("insert into city values (?, ?, ?, ?)");
			
			pStmt.setInt(1, 4181);
			pStmt.setString(2, "Flower Mound");
			pStmt.setString(3,"USA");
			pStmt.setString(4, "Texas");
			pStmt.setInt(5, 78854);
			
			System.out.println(pStmt.executeUpdate());
			
			//Select prepared statement
			pStmt2 = conn.prepareStatement("select * from city where CountryCode = ?");
			pStmt2.setString(1, "USA");
			selectResult = pStmt2.executeQuery();
			while (selectResult.next()) {
				System.out.println(selectResult.getInt("ID")+" " + selectResult.getString("Name") + selectResult.getInt("Population"));
				//System.out.println(selectResult.getInt(1)+ " " + selectResult.getString(2) + " " + selectResult.getInt(5));
			}
			conn.close();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");

			//Update Prepared Statement
			pStmt3 = conn.prepareStatement("update city set Population = ? where Name = 'Highland Village'");
			pStmt3.setInt(1,  10000);
			System.out.println(pStmt3.executeUpdate());
			updateResult = pStmt3.executeQuery("SELECT * from city where name = \"Highland Village\"");
			while (updateResult.next()) {
				System.out.println("After Update:");
				//System.out.println(selectResult.getInt("ID")+" " + selectResult.getString("Name") + selectResult.getInt("Population"));
				System.out.println(selectResult.getInt(1)+ " " + selectResult.getString(2) + " " + selectResult.getInt(5));
			}		
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
