package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertPostgres 
{
  public static void main(String arga[])
  {
    Scanner sc =  new Scanner(System.in);
    
    System.out.println("Enter user Id"+" - ");
    String id = sc.next();
    
    System.out.print("Enter first name"+" - ");
    String fname = sc.next();
    
    System.out.print("Enter last name"+" - ");
    String lname = sc.next();
    
    System.out.print("Enter emailid"+" - ");
    String emailid = sc.next();

    System.out.print("Enter department"+" - ");
    String department = sc.next();
    
    System.out.print("Enter salary"+" - ");
    String salary = sc.next();
    
    System.out.print("Enter date(format - yyyy/mm/dd)"+" - ");
    String date = sc.next();
    
    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver Loaded");
      
      Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db25", "postgres","root@1234");
      System.out.println("Connected");
      
      Statement st = cn.createStatement();
      String q = "INSERT INTO emp VALUES('"+id+"', '"+fname+"', '"+lname+"', '"+emailid+"', '"+department+"', '"+salary+"', '"+date+"')";
      
      int i = st.executeUpdate(q);
      if(i>0)
      {
    	System.out.println(i+" "+"record affected");
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
