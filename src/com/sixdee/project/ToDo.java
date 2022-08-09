package com.sixdee.project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    String desc;
    int choice=0;

    List<Task> todoList = new ArrayList<Task>();

    while(choice != 8)
    {
      System.out.println("Enter 1 to create a task ");
      System.out.println("Enter 2 to mark the task completed");
      System.out.println("Enter 3 to update the description of the task");
      System.out.println("Enter 4 to List the tasks");
      System.out.println("Enter 5 to List the pending tasks");
      System.out.println("Enter 6 to List the completed tasks");
      System.out.println("Enter 7 to List the tasks that are assigned for today");
      System.out.println("Enter 8 to Exit");
      choice = sc.nextInt();


      switch(choice)
      {
      case 1:
        
        System.out.println("Enter task name :");
        String name1=sc1.nextLine();
        System.out.println("Enter task description");
        desc=sc1.nextLine();
        System.out.println("Enter date in dd/MM/yyyy format");
        String sDate1=sc1.nextLine();
        Date date1;
      
        try
        {
        	date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            String str = formatter.format(date1);
        	Task t1 = new Task(name1,desc,str);
        	todoList.add(t1);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
       
        break;
        
      case 2 : 
    	  System.out.println("Enter the task name that you want mark as completed");
    	  String taskName1 = sc1.nextLine();
    	  for(Task t : todoList)
    	  {
    		  if(t.taskName.equals(taskName1))
    		  {
    			  t.taskStatus=true;
    		  }
    	  }
    	  break;
    	  
      case 3 : 
    	  System.out.println("Enter the task name for which you want to update the description");
    	  String taskName2 = sc1.nextLine();
    	  System.out.println("Enter new description");
		  desc=sc1.nextLine();
		  for(Task t : todoList)
    	  {
    		  if(t.taskName.equals(taskName2))
    		  {
    			  t.description=desc;
    		  }
    	  }
	      System.out.println("Description updated ");
	      break;
	      
      case 4 :
    	  for(Task t : todoList)
    	  {
    		  System.out.println("Task Name : "+t.taskName);
    		  System.out.println("Description : "+t.description);
    		  System.out.println("Created Time : "+t.date);
    		  if(t.taskStatus==true)
    			  System.out.println("Task Status : Completed");
    		  else
    			  System.out.println("Task Status : Pending");
    		  
    		  System.out.println();
    		  
    	  }
    	  break;
    	  
      case 5 : 
    	  System.out.println("Listing pending tasks...");
    	  for(Task t : todoList)
    	  {
    		  if(t.taskStatus==false)
    		  {
    			  System.out.println(t.taskName);
    		  }
    	  }
    	  break;
      case 6 : 
    	  System.out.println("Listing completed tasks...");
    	  for(Task t : todoList)
    	  {
    		  if(t.taskStatus==true)
    		  {
    			  System.out.println(t.taskName);
    		  }
    	  }
    	  break;
      case 7 : System.out.println("Listing all the tasks that are assigned for today");
      		   Date date = new Date();
               SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
               String str = formatter.format(date);
		       for(Task t : todoList)
			   {
				   if(t.date.equals(str))
				   {
					   System.out.println(t.taskName);
				   }
			   }
		       break;
      case 8 : continue;
      
      default : System.out.println("Please enter a valid number");
      		}
    	}
  	}
}
      