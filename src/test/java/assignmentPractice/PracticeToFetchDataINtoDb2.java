package assignmentPractice;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class PracticeToFetchDataINtoDb2 {
	public static void main(String[] args) throws SQLException {
		// load or register the databasxe driver
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		// connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		   System.out.println("========Done======");
		// create sql statement
		Statement stat=conn.createStatement();
		
		// to insert the data into  the sql query or update
		int resultset=stat.executeUpdate("insert into project values('TY_PROJ_2009','Prachi','2000-12-09','WhatsApp','Completed','500')");
		
		System.out.println(resultset);
		
		
		conn.close();
		
		
	}

}
