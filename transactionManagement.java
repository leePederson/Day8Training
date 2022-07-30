package Day8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transactionManagement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/world", "root", "o1uxaqxh");
			con.setAutoCommit(false);
			
			pStmt =  con.prepareStatement("insert into city (Name, CountryCode, District, Population) values ('Lewisville', 'USA', 'Texas', ?)");
			
			pStmt.setInt(1, 82000);
			
			System.out.println(pStmt.executeUpdate());
			
			pStmt = con.prepareStatement("insert into countryLanguage values (USA, Pig-Latin, F, ?)");
			pStmt.setDouble(1,  .1);
			
			System.out.println(pStmt.executeUpdate());
			
			con.commit();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
