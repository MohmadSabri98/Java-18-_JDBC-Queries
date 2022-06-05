package mohmadsabri.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.conf.ConnectionUrl.Type;

public class Greet_the_departmentProcedure {

	public static void main(String[] args) {
		String  url="jdbc:mysql://localhost:3306/demo",pass="mohmadsabri98@gmail.com",  name="root";
		CallableStatement statment=null;

						try(Connection connection =DriverManager.getConnection(url,name,pass );){
							String departmentString="Engineering";
							
							
							
							
							
							statment=connection.prepareCall("{call greet_the_department(?)}");
							statment.registerOutParameter(1, Types.VARCHAR);
							statment.setString(1, departmentString);
							statment.execute();
							System.out.println("Finshing calling  greet_the_department  stored procedure");
							
							String reString=statment.getString(1);
							System.out.println(reString);
						

	}
						catch (SQLException e) {
				        	  e.printStackTrace();
					// TODO: handle exception
				}

}
	}
