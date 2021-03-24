import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class DatabaseConnector {
	
	public static void main(String args[])
	{
		try {
			String dbUrl="jdbc:db2://maximo.eam360.com:50005/maxdb77";
			String driver="com.ibm.db2.jcc.DB2Driver";
			String uName="maxim";
			String passWord="Eam360maximo";
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(dbUrl,uName,passWord);  
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from maximo.meterreading where assetnum='11430'");  
			while(rs.next())  
			{
				String assetNum=rs.getString("ASSETNUM");
				String reading = rs.getString("READING");
				Date readingDate = rs.getDate("READINGDATE");
				
				System.out.println("Asset:" + assetNum);
				System.out.println("Reading:" + reading);
				System.out.println("Reading Date:" + readingDate);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
	}

//	public void connect()
//	{
//		try {
//			String dbUrl="jdbc:db2://maximo.eam360.com:50005/maxdb77";
//			String driver="com.ibm.db2.jcc.DB2Driver";
//			String uName="maxim";
//			String passWord="Eam360maximo";
//			
//			Class.forName(driver);
//			Connection con=DriverManager.getConnection(dbUrl,uName,passWord);  
//			
//			Statement stmt=con.createStatement();
//			
//			ResultSet rs=stmt.executeQuery("select * from maximo.meterreading where assetnum='11430'");  
//			while(rs.next())  
//			{
//				String assetNum=rs.getString("ASSETNUM");
//				System.out.println("Asset:" + assetNum);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}  
//
//	}
	
}