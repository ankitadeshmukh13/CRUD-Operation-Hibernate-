package com.hibernateOperation.CrudOperation;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
//       
//    	Configuration cfg=new Configuration();
//    	cfg.configure("hibernate.cfg.xml);
//    	cfg.addAnnotatedClass(Student.class);
//    	SessionFactory factory=cfg.buildSessionFactory();
//    	System.out.println(factory.isClosed());
    	
    	Operation o=new Operation();
    	o.getSession();
    	int ch;
     do {
   	   System.out.println("=========================");
   	   System.out.println("1.Insert Data");
   	   System.out.println("2.Update Data");
   	   System.out.println("3.Delete Data");
   	   System.out.println("4.Show Data of given id");
	   	System.out.println("5.search data by city");
	   	System.out.println("6.Show Name of Student(Only Name)");
		System.out.println("7.Show city of Student(Only City)");
	   	System.out.println("8.Show all details of particular student ");
	   	System.out.println("9.Show Data of student whose id is greater than given id");
   	   System.out.println("10.Show All Data");
   	System.out.println("11.Exit");
   	   
   	   System.out.println("Enter your choice");
   	   Scanner sc=new Scanner(System.in);
   	   ch=sc.nextInt();
   	   
   	   switch(ch) {
   	   case 1:o.Insert();break;
   	   case 2:o.update();break;
   	   case 3:o.delete();break;
   	   case 4:o.show();break;
   	   case 5:o.search();break;
   	   case 6:o.showName();break;
   	   case 7:o.showCity();break;
   	   case 8:o.showInfoStud();break;
   	   case 9:o.showGreater();break;
   	   case 10:o.showAllData();break;
   	   
   	   
   	   case 11:System.out.println("Exit succesfully");break;
   	   default:System.out.println("Enter valid choice");
   	   }
      }
      while(ch!=11);
   	
    }
}
