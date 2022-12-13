package com.edubridge.com.edubridge.jdbc;
import java.sql.*;
public class JDBC1 {

	public static void main(String[] args) throws SQLException {
	
		Connection connection  = null;
		try {
			//class loading in JAVA arch
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ConsoleBaseProg", "root", "Aniket@123");
			//Statement stmt = connection.createStatement();
		    PreparedStatement stmt = connection.prepareStatement("INSERT INTO ListOfProduct values(?,?)");
		    stmt.setString(1, "Shabudana");
		    stmt.setInt(2,50);
		   
		    
			ResultSet resultSet1 = stmt.executeQuery("SELECT * FROM ListOfProduct;");
			
			ResultSetMetaData metadata = resultSet1.getMetaData() ;
			
			System.out.println(metadata.getTableName(1));
			
			while(resultSet1.next()) {
				System.out.println(resultSet1.getString("ProductName") +" " + resultSet1.getInt("ProductPrise"));
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
