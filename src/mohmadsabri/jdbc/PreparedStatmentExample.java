package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatmentExample {

	public static void main(String[] args) {
String  url="jdbc:mysql://localhost:3306/jdbc_emo",pass="mohmadsabri98@gmail.com",  name="root", 
update_query="select * from employee where salary >? and department=?";
		

		try(Connection connection =DriverManager.getConnection(url,name,pass );
				PreparedStatement statment=connection.prepareStatement(update_query);
				){
			statment.setDouble(1, 1000);
			statment.setString(2, "HR");
			
		
ResultSet res=statment.executeQuery();
			/*/**
			
	      
			/**/
			 display(res);
		          }  catch (SQLException e) {
		        	  e.printStackTrace();
			// TODO: handle exception
		}

	}
	private static void display(ResultSet myRs) throws SQLException {
		while(myRs.next()){
		
			
		
			
			
			
			
			
			
			
			 System.out.println(myRs.getInt("id")+","+ myRs.getString("first_name")+","+myRs.getString("last_name")+","+myRs.getString("email") +","+myRs.getString("department")+","+myRs.getDouble("salary") );
		
		}

		}

		

}
