package mohmadsabri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.CallableStatement;



public class IncreaseSalaryforDepartment {

	public static void main(String[] args) {
		String  url="jdbc:mysql://localhost:3306/demo",pass="mohmadsabri98@gmail.com",  name="root";
		CallableStatement statment=null;

						try(Connection connection =DriverManager.getConnection(url,name,pass );){
							String departmentString="Engineering";
							int the_increased_amount=10000;
							
							System.out.println("Salaries berfore");
							showSalaries(connection, departmentString);
							
							statment=connection.prepareCall("{call increase_salaries_for_department(?, ?)}");
							statment.setString(1, departmentString);
							statment.setDouble(2, the_increased_amount);
							statment.execute();
							System.out.println("Finshing calling stored procedure");
							System.out.println("Salaries after");
							showSalaries(connection, departmentString);
							
							
				
							
					      

							close(connection, statment, null);
	
						          }  catch (SQLException e) {
						        	  e.printStackTrace();
							// TODO: handle exception
						}
						


	}
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
	
	private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select * from employees where department=?");

			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}
	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}
	

}
