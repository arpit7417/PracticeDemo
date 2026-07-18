package assignmentPractice;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class PracticeToFetchDataFromDb {
	public static void main(String[] args) throws SQLException {
		// load or register the databasxe driver
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		// connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		   System.out.println("========Done======");
		// create sql statement
		Statement stat=conn.createStatement();
		
		// execute the sql query or get result
		ResultSet resultset=stat.executeQuery("select* from Project WHERE project_id= 'TY_PROJ_1009' ");
		
		while(resultset.next()) {
			//System.out.println(resultset.getString(1));
			System.out.println(resultset.getString(2)+"\t" +resultset.getString(3));
		}
		
		
		conn.close();
		
		
	}

}
