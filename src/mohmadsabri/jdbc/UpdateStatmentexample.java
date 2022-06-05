package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStatmentexample {

	public static void main(String[] args) {
		
		
		
String  url="jdbc:mysql://localhost:3306/jdbc_emo",pass="mohmadsabri98@gmail.com",  name="root", update_query="update users set name=\"mohmad\" where id =1;";;
		

		try(Connection connection =DriverManager.getConnection(url,name,pass );
				Statement statment=connection.createStatement();
				){
		

			
			int res=statment.executeUpdate(update_query);
	        System.out.println("number of records affected = "+res);
			
			
		          }  catch (SQLException e) {
		        	  e.printStackTrace();
			// TODO: handle exception
		}

	}

}
