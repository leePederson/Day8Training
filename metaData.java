package Day8;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class metaData {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			DatabaseMetaData dbData = con.getMetaData();
			
			System.out.println(dbData.getDatabaseProductName());
			System.out.println(dbData.getDatabaseMajorVersion());
			System.out.println(dbData.getDriverName());
			System.out.println(dbData.getSchemas());
			
			pStmt = con.prepareStatement("Select * from city where id = 369");
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				ResultSetMetaData rsData = rs.getMetaData();
				System.out.println(rsData.getColumnCount());
				System.out.println(rsData.getColumnName(1) + " " + rsData.getColumnTypeName(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
