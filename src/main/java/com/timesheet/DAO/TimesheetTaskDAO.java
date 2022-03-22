package com.timesheet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TimesheetTaskDAO {
    public static void runQuery(String query) throws Exception{
		// Step 1 : Database Driver ( Optional)
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get the Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db",
				"rev_user", "rev_user");
		System.out.println(connection);

		System.out.println(query);

		// execute the query
		Statement statement = connection.createStatement();
		int rows = statement.executeUpdate(query);
		System.out.println("No of rows modified:" + rows);

		// close the connection
		connection.close();

	}
    public static void addProject(String userId,String projectcode,String projectName,String projectCreated,String status,String totalTasks,String tasksCompleted,String deadline, String deadline2) throws Exception 
	{

		//String query = "INSERT INTO timesheet_app_projects (project_code,project_name,project_created,STATUS,total_tasks,tasks_completed,deadline)VALUES(?,?,?,?,?,?,?);";
		String query = "INSERT INTO timesheet_app_projects (user_id,project_code,project_name,project_created,STATUS,total_tasks,tasks_completed,deadline)VALUES('"+userId+"','"+projectcode+"','"+projectName+"','"+projectCreated+"','"+status+"','"+totalTasks+"','"+tasksCompleted+"','"+deadline+"');";

		runQuery(query);

	}
    public static void updateProjectName(String projectName1,String userId1) throws Exception {

		String query = "UPDATE timesheet_app_projects SET project_name = '"+projectName1+"' WHERE project_code = '"+userId1+"';";
		runQuery(query);

	}
	public static void updateProjectStatus(String status1,String userId1) throws Exception {

		String query = "UPDATE timesheet_app_projects SET STATUS = '"+status1+"' WHERE user_id = '"+userId1+"';";
		runQuery(query);

	}
	public static void updateProjectTaskCompleted(String tasksCompleted1, String userId1) throws Exception {

		String query = "UPDATE timesheet_app_projects SET tasks_completed = '"+tasksCompleted1+"' WHERE user_id = '"+userId1+"';";
		runQuery(query);

	}
	public static void updateProjectDeadline(String deadline1,String userId1) throws Exception {

		String query = "UPDATE timesheet_app_projects SET deadline = '"+deadline1+"' WHERE user_id = '"+userId1+"';";
		runQuery(query);

	}
	public static void displayProject() throws Exception {

		String query = "SELECT timesheet_app_users.user_id,timesheet_app_users.NAME,timesheet_app_users.ROLE,timesheet_app_users.email_id,timesheet_app_projects.project_code,timesheet_app_projects.project_name,timesheet_app_projects.project_created,timesheet_app_projects.status,timesheet_app_projects.total_tasks,timesheet_app_projects.tasks_completed,timesheet_app_projects.deadline FROM timesheet_app_projects INNER JOIN timesheet_app_users  ON timesheet_app_projects.user_id = timesheet_app_users.user_id;   ";
		runQuery(query);

	}


  	public static void deleteProject(String userId5) throws Exception{
		String query = "DELETE FROM timesheet_app_projects WHERE user_id = '"+userId5+"';";
		runQuery(query);
		
	}

        
}

