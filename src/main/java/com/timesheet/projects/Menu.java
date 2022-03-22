package com.timesheet.projects;

import java.util.Scanner;

import com.timesheet.DAO.TimesheetTaskDAO;
public class Menu {
    public static void showMenu() throws Exception{
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("1. Insert project");
            System.out.println("2. Delete project");
            System.out.println("3. Update project");
            System.out.println("4. Display project");

            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    //Insert
                     Scanner insert = new Scanner(System.in);
                    
                     System.out.println("enter your user id");
                     String userId = insert.nextLine();
                    
                     System.out.println("enter project code:");
                     String projectcode = insert.nextLine();
                     
                     System.out.println("enter project Name:");
                     String projectName = insert.nextLine();
                    
                     System.out.println("enter project created date:");
                     String projectCreated = insert.nextLine();
                     
                     System.out.println("enter total no of tasks:");
                     String totalTasks = insert.nextLine();
                    
                     System.out.println("enter no of task completed:");
                     String tasksCompleted = insert.nextLine();

                     System.out.println("enter project status:");
                     String status = insert.nextLine();
                    
                     System.out.println("enter project deadline:");
                     String deadline = insert.nextLine();

                     TimesheetProjects insertproject = new TimesheetProjects(userId,projectcode,projectName,projectCreated,status,totalTasks,tasksCompleted,deadline);
                     System.err.println(insertproject);
                     TimesheetTaskDAO.addProject(insertproject.userId,insertproject.projectcode,insertproject.projectName, insertproject.projectCreated, insertproject.status, insertproject.totalTasks, insertproject.tasksCompleted, insertproject.deadline, userId);
                     
                    break;
                case 2:
                    //Delete
                    Scanner delete = new Scanner(System.in);
                    String userId5 = delete.nextLine();
                    TimesheetProjects deleteproject = new TimesheetProjects(userId5);
                    System.err.println(deleteproject);
                    TimesheetTaskDAO.deleteProject(deleteproject.userId5);


                    break;
                case 3:
                    //Update
                    Scanner update = new Scanner(System.in);
                    
                  /*  System.out.println("enter project code:");
                    String projectcode1 = update.nextLine();
                    System.out.println("enter project created date:");
                    String projectCreated1 = update.nextLine();
                    
                    System.out.println("enter total no of tasks:");
                    String totalTasks1 = update.nextLine();*/
                    
                    
                    
                    System.out.println("1.update project name");
                    System.out.println("2.update project status");
                    System.out.println("3.update total number of tasks completed");
                    System.out.println("4.update project deadline");

                    int change = update.nextInt();

                    switch(change){
                        case 1:
                            System.out.println("enter user id:");
                            String userId1 = update.nextLine();
                            
                            System.out.println("enter project Name:");
                            String projectName1 = update.nextLine();
                            
                            TimesheetProjects updateprojectname = new TimesheetProjects(userId1,projectName1);
                            System.err.println(updateprojectname);
                            TimesheetTaskDAO.updateProjectName(projectName1,userId1);
                            break;
                        case 2:
                            System.out.println("enter user id:");
                            String userId2 = update.nextLine();
                            
                            System.out.println("enter project status:");
                            String status1 = update.nextLine();
                            
                            TimesheetProjects updateprojectstatus = new TimesheetProjects(userId2,status1);
                            System.err.println(updateprojectstatus);
                            TimesheetTaskDAO.updateProjectStatus(status1, userId2);
                            break;
                        case 3:
                            System.out.println("enter user id:");
                            String userId3 = update.nextLine();

                            System.out.println("enter no of task completed:");
                            String tasksCompleted1 = update.nextLine();
                            
                            TimesheetProjects updateTaskCompleted = new TimesheetProjects(userId3,tasksCompleted1);
                            System.err.println(updateTaskCompleted);
                            TimesheetTaskDAO.updateProjectTaskCompleted(tasksCompleted1, userId3);
                            break;
                        case 4:
                            System.out.println("enter user id:");
                            String userId4 = update.nextLine();

                            System.out.println("enter project deadline:");
                            String deadline1 = update.nextLine();
                            
                            TimesheetProjects updateProjectDeadline = new TimesheetProjects(userId4,deadline1);
                            System.err.println(updateProjectDeadline);
                            TimesheetTaskDAO.updateProjectDeadline(deadline1, userId4);
                            break;
                        default:
                            System.out.println("invalid input, choose correct input");
                    }
                   
                case 4:
                    // display
                    TimesheetTaskDAO.displayProject();
                    break;
                
                default:
                    System.out.println("Sorry wrong input, Please refresh the page");
                    System.exit(0);

            }
        }
    }
    
}
