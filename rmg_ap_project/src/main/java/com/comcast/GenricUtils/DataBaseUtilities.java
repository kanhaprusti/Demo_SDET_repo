package com.comcast.GenricUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
Connection connection=null;
ResultSet result=null;
/**
 * this method establish connection with data base
 * @throws SQLException
 */
public void connectToDB() throws SQLException {
	  Driver driverff = new Driver();
	  DriverManager.registerDriver(driverff);
	  DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
}
/**
 * @author Kanha
 * @throws SQLException
 * This method will perform database close action
 */
  public void closeDB() throws SQLException {
	    connection.close();
  }
  /**
	 * This method will execute the querry and gives the result
	 * @param querry
	 * @return
 * @throws SQLException 
	 */
     public ResultSet executeQuery(String querry) throws SQLException {
    	    result=connection.createStatement().executeQuery(querry);
    	    return result;
     }
     /**
 	 * 
 	 * @param querry
 	 * @param columnNumber
 	 * @param expectedData
 	 * @return
     * @throws SQLException 
 	 * @throws Throwable
 	 * This method will verify whether data is present in database or not
 	 */
     public String executeQuerryAndGetData(String querry ,int columnNumber,String expectedData) throws SQLException {
    	 boolean flag=false;
    	 result=connection.createStatement().executeQuery(querry);
    	 while(result.next()) {
    		 if(result.getString(columnNumber).equals(expectedData)){
    			 flag=true;
    			 break;
    		 }
    	 }
    	 if(flag) {
    		 System.out.println(expectedData+"========> data is verified in data base");
    		 return expectedData;
    	 }else {
    		 System.out.println(expectedData+"data is not available");
    		 return expectedData;
    	 }
		
     }
}
