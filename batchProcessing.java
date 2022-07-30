package Day8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class batchProcessing {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pStmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			
			pStmt = con.prepareCall("insert into countrylanguage values ('USA', ?, 'F', ?)");
			pStmt.setString(1, "Weeaboo");
			pStmt.setDouble(2,  .1);
			pStmt.addBatch();
			
			pStmt.setString(1, "YeeHaw");
			pStmt.setDouble(2, .4);
			pStmt.addBatch();
			
			pStmt.executeBatch();

		} catch(Exception e){
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
