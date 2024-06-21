package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectPostgre 
{
  public static void main(String args[])
  {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	
	try
	{
	  Class.forName("org.postgresql.Driver");
	  System.out.println("Driver Loaded");
	  
	  cn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db25", "postgres", "root@1234");
	  System.out.println("Connected");
	  
	  st = cn.createStatement();
	  String q = "SELECT * FROM emp";
      
	  rs = st.executeQuery(q);
	  while(rs.next())
	  {
		System.out.print(rs.getString(1)+" "+"\t");
		System.out.print(rs.getString(2)+" "+"\t");
		System.out.print(rs.getString(3)+" "+"\t");
		System.out.print(rs.getString(4)+" "+"\t");
		System.out.print(rs.getString(5)+" "+"\t");
		System.out.print(rs.getString(6)+" "+"\t");
		System.out.println(rs.getString(7)+" "+"\t");
	  }
	  cn.close();
	}
	catch(ClassNotFoundException e)
	{
	  System.out.println(e);	
	}
	catch(SQLException e)
	{
	  System.out.println(e);	
	}
  }
}
