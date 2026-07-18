package assignmentPractice;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class PracticeToDeleteDataINtoDb3 {
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
		int resultset=stat.executeUpdate("DELETE FROM Project WHERE project_id='TY_PROJ_2000'");
		
		System.out.println(resultset);
		
		
		conn.close();
		
		
	}

}
