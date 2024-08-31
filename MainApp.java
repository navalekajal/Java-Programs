package com.edu;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		while(true) {
        Scanner sc=new Scanner(System.in);
        System.out.println("*******Employee Management System*****");
        System.out.println("1.Display Employees");
        System.out.println("2.Add Employee");
        System.out.println("3.Delete Employee by id");
        System.out.println("4.Upadate Employee by id");
        System.out.println("5.Get Employee by id");
        
        System.out.println("Enter your choice");
        int ch=sc.nextInt();
        
        switch(ch) {
        case 1: EmployeeOperations.displayEmployees();
        break;
        case 2: EmployeeOperations.addEmployee();
        break;
        case 3: EmployeeOperations.deleteEmployee();
        break;
        case 4: EmployeeOperations.updateEmployee();
        break;
        case 5: EmployeeOperations.getEmployee();
        break;
        default:System.out.println("Invalid input");
        }
        System.out.println("Do you want to continue, press Y to continue any other key to stop");
        char ch1=sc.next().charAt(0);
        if(ch1!='y') {
        	break;
        }
        System.out.println("Program is terminated");
        }
	}

}
