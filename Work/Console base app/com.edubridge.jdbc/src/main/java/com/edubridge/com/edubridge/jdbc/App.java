package com.edubridge.com.edubridge.jdbc;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Hello World!" );
        
        Connection connection  = null;
		try {
			//class loading in JAVA arch
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/detabse_first", "root", "Aniket@123");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from employee_details;");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) +" " + resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
				//System.out.println(resultSet.absolute(2));
			}
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		finally{
			connection.close();
		}
    }
}
