package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQlDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String  url="jdbc:mysql://localhost:3306/jdbc_emo",pass="mohmadsabri98@gmail.com",  name="root";
	

try(Connection connection =DriverManager.getConnection(url,name,pass );
		Statement statment=connection.createStatement();
		ResultSet res= statment.executeQuery("select * from users");){
	while(res.next()) {
		int id= res.getInt("id");
		String name1= res.getString("name");
		String email= res.getString("email");
		String country= res.getString("country");
		String password= res.getString("password");
		
             System.out.println(id+", "+name1+", "+email+" ,"+country+", "+password);
		
	}

	
	
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
