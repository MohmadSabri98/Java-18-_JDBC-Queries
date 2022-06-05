package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatmentExample {
	  private static final String createTableSQL = "create table Users1(\r\n" + "  id  int(3) primary key,\r\n" +
		        "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
		        "  password varchar(20)\r\n" + "  );";
	private static	String sql = "CREATE TABLE REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " + 
                " last VARCHAR(255), " + 
                " age INTEGER, " + 
                " PRIMARY KEY ( id ))"; 
	
	public static void main(String[] args)throws SQLException {
		
		String  url="jdbc:mysql://localhost:3306/jdbc_emo",pass="mohmadsabri98@gmail.com",  name="root";
		

		try(Connection connection =DriverManager.getConnection(url,name,pass );
				Statement statment=connection.createStatement();
				){
		

	         statment.executeUpdate(sql);
	         System.out.println("Created table in given database...");
			

			
			
		          }  catch (SQLException e) {
		        	  e.printStackTrace();
			// TODO: handle exception
		}
				// 1 get database coneection
				
				// 2. create statement
				//3. execute statement
				
				// 4 process result
				
				
				
		
		
		
	}
	public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
