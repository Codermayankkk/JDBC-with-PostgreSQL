package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletePostgres 
{
  public static void main(String args[])
  {
	try
	{
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver Loaded");
      
      Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db25", "postgres", "root@1234");
      System.out.println("Connected");
      
      Statement st = cn.createStatement();
      String q = "DELETE FROM emp WHERE id = 107";
      
      int i = st.executeUpdate(q);
      if(i>0)
      {
    	System.out.println(i+" "+"record affected");  
      }
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
