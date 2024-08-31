package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeOperations {

private static Connection conn;
private static PreparedStatement pst;
private static String sql;
private static int eid;
private static String ename;
private static int did;
private static float esalary;
	public static void displayEmployees() throws ClassNotFoundException, SQLException {
		
		//System.out.println("Display Employee");
		conn=DatabaseConnection.getConnection();
		sql="select * from employee";
		pst=conn.prepareStatement(sql);
		
		ResultSet rs=pst.executeQuery(sql);
		System.out.println("eid\tename\tesalary\tdid");
		while(rs.next()) {
			eid=rs.getInt("eid");
			ename=rs.getString("ename");
			esalary=rs.getFloat("esalary");
			did=rs.getInt("did");
			
			System.out.println(eid+"\t"+ename+"\t"+esalary+"\t"+did);
		}
	}

	public static void addEmployee() throws SQLException, ClassNotFoundException {
		
		//System.out.println("Add Employee");
		conn=DatabaseConnection.getConnection();
		  Scanner sc=new Scanner(System.in);
	      System.out.println("Enter Employee id");
	      eid=sc.nextInt();
		
		  String sql="select * from employee where eid=?";
	      pst=conn.prepareStatement(sql);
	      pst.setInt(1, eid);
	      ResultSet rs=pst.executeQuery();
	      if(rs.next()) {
	    	  System.out.println(eid+"already exists");
	      }
	      else {
	    	  System.out.println("Enter name");
	    	  ename=sc.next();
	    	  System.out.println("Enter salary");
	    	  esalary=sc.nextFloat();
	    	  System.out.println("Enter did(10,20,30)");
	    	  did=sc.nextInt();
	    	  //String insql="insert into employee(eid,ename,esalary,did) values("+eid+",'"+ename+"',"+esalary+","+did+")";
	    	  String inssql="insert into employee(eid,ename,esalary,did) values(?,?,?,?)";
	    	  pst=conn.prepareStatement(inssql);
	    	  pst.setInt(1, eid);
	    	  pst.setString(2,ename);
	    	  pst.setFloat(3, esalary);
	    	  pst.setInt(4, did);
	    	  
	    	  int i =pst.executeUpdate();
	    	  if(i>0) {
	    		  System.out.println("Record added successfully");
	    	  }
	}
	}
     public static void deleteEmployee() throws ClassNotFoundException, SQLException {
    	 
		//System.out.println("Delete Employee");
    	 Scanner sc=new Scanner(System.in);
         System.out.println("Enter id to delete record");
         int id  = sc.nextInt();
 		conn = DatabaseConnection.getConnection();
 		String sql="select * from employee where eid=?";
        pst=conn.prepareStatement(sql);
        pst.setInt(1, id);
        //select * from 
        ResultSet rs1=pst.executeQuery();
        if(rs1.next()) {   //if record exists,then go for delete
        	String delsql="delete from employee where eid=?";
        	pst=conn.prepareStatement(delsql);
        	pst.setInt(1, id);
        	int r = pst.executeUpdate();
        	if(r>0) {
        		System.out.println("Record with id="+id+"is deleted");
        	}
        	
        }else {
        	System.out.println("record not exists");
        }		
 	}
    	
         	
	
	public static void updateEmployee() throws ClassNotFoundException, SQLException  {
		//System.out.println("Update Employee");
		conn = DatabaseConnection.getConnection();
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter id to update the record");
        int id  = sc.nextInt();
        System.out.println("Enter the name to update the record");
        String name=sc.next();
        String sql="Select * from employee where eid=?";
        pst=conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs1=pst.executeQuery();
        if(rs1.next()) {   //if record exists,then go for delete
        	//String upssql= "update employee set ename='"+name+"' where eid="+id;
        	String upssql= "update employee set ename=? where eid=?";
        	pst=conn.prepareStatement(upssql);
        	pst.setString(1, name);
        	pst.setInt(2, id);

        	int r = pst.executeUpdate();
        	if(r>0) {
        		System.out.println("Name changed based on id successfully");
            
        	}
        	
        }else {
        	System.out.println("Record not exists");
        }
		
	}

	public static void getEmployee() throws SQLException, ClassNotFoundException {
		//System.out.println("Get employee by id");
		
				Scanner sc = new Scanner(System.in);
				conn = DatabaseConnection.getConnection();
				System.out.println("Enter employee id");
				eid = sc.nextInt();
					
				
				 sql = "select * from employee where eid=?";
				//step3. create a statement object
				
				pst = conn.prepareStatement(sql);
				pst.setInt(1, eid);
				//step4. Execute query
				ResultSet rs = pst.executeQuery();
					
				if(rs.next()) {
					System.out.println("Did\tename\tesalary\tdid");
					eid = rs.getInt("eid");
					ename =  rs.getString("ename");
					esalary = rs.getFloat("esalary");
					did = rs.getInt("did");
					
					System.out.println(eid+"\t"+ename+"\t"+esalary+"\t"+did);
				}else {
					System.out.println("Employee not exist");
				}
				

    }


	
}