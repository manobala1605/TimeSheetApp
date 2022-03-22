package com.timesheet.testusers;

import java.util.Scanner;

import com.timesheet.DAO.TimesheetUserDAO;
import com.timesheetapp.users.TimesheetUser;

public class TimesheetUserTest {
    public static void main(String[] args) throws Exception{
        try (Scanner sc = new Scanner(System.in)) {
            System.err.println("Already user - enter 'login' / new user - enter 'register");
            String enter = sc.nextLine();

            
            if(enter.equals("register")){
                try (Scanner ip = new Scanner(System.in)) {
                    System.err.println("enter name , emailId ,password, project");
                    String name = ip.nextLine();
                    String emailID=ip.nextLine();
                    String password=ip.nextLine();
                    String project=ip.nextLine();
                    TimesheetUser users = new TimesheetUser(name, emailID,password,project);
                    System.err.println(users.name+"     "+users.emailID+"      "+users.password+"        "+users.project);
                    TimesheetUserDAO.addUser(users);
                }
            }
            else if(enter.equals("login"))
            {
                System.err.println("enter your mail id:");
                String emailID = sc.nextLine();
                System.err.println(" enter your password:");
                String password = sc.nextLine();
                TimesheetUser users2 = new TimesheetUser(emailID,password);
                TimesheetUserDAO.loginUser(users2.emailID,users2.password);
            }
            else if(enter.equals("admin"))
            {
                String useremail1 = sc.nextLine();
                String userpassword1 = sc.nextLine();
                
                if(useremail1.equals("manobala1605@gmail.com")  && userpassword1.equals("mano@123"))
                {
                    System.err.println("welcome admin...!");
                    TimesheetUserDAO.allUser();
                }
                else{
                    System.err.println("you are not an admin...!!");
                }
            }
            else
            {
                System.err.println("enter the correct command: login / register");
            }
        }
        
    }
    
}
