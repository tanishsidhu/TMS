/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vibhor Sharma
 */
package com.WebApplication1;
import java.sql.*;
 
public class LoginDao {

public static boolean validate(String name,String pass) throws ClassNotFoundException{
boolean status=false;
try{ 
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
Connection conn=DriverManager.getConnection("jdbc:ucanaccess://F:\\java\\qwe123.accdb");
Statement s = conn.createStatement();
           // String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\Users\\Vibhor Sharma\\Documents\\NetBeansProjects\\WebApplication1\\qwe123";

           // Connection conn = DriverManager.getConnection(url);

         PreparedStatement ps =conn.prepareStatement("select * from ad where username=? and userpass=?");
	ps.setString(1,name);
	ps.setString(2,pass);
	
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	
	
}catch(SQLException e){System.out.println("Exception is " + e);}
return status;
}
}
