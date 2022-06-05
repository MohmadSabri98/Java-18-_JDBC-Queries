package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatmentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String  url="jdbc:mysql://localhost:3306/jdbc_emo",pass="mohmadsabri98@gmail.com",  name="root";
		

		try(Connection connection =DriverManager.getConnection(url,name,pass );
				Statement statment=connection.createStatement();
				){
		

			String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
	       statment.executeUpdate(sql);
	         sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
	         statment.executeUpdate(sql);
	         sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
	        statment.executeUpdate(sql);
	         sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
	        statment.executeUpdate(sql);
	         System.out.println("Inserted records into the table...");  
			

			
			
		          }  catch (SQLException e) {
		        	  e.printStackTrace();
			// TODO: handle exception
		}
				// 1 get database coneection
				
				// 2. create statement
				//3. execute statement
				
				// 4 process result
				
				
		
		
		
		

	}

}
