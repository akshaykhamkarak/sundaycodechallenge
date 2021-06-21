package client;

import java.util.Scanner;

import exception.ConnectionUtilityException;
import exception.NoStudentFoundException;
import service.AddCourse;
import service.impl.AddCourseImpl;

public class App 
{
	static AddCourse addcourse= new AddCourseImpl();;
	
	
    public static void main( String[] args ) throws NoStudentFoundException, ConnectionUtilityException
    {
    	Scanner sc=new Scanner(System.in);
    	
      int choice=0;
      do {
    	  Option.displayMenu();
    	  
    	  System.out.println("Enter your choice:");
    	  choice=sc.nextInt();
    	  
    	  switch(choice) {
    	  case 1:
    		  
    		  addcourse.getCourseAndStudent();
    		  break;
    		  
    	  case 2:
    		  addcourse.searchStudentByCourseName();
    	  break;
    	  case 3:
    		  Option.exit();
    	  break;
    	  default :
    		  System.out.println("You enter wrong choice.");
    		  break;
    	  
    	  }
    	  
      }while(choice!=3);
    	
    	
    	
     
    }
}
