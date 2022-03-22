package com.timesheetapp.users;

public class TimesheetUser {
    public String name;
    public String emailID;
    public String password;
    public String project;


    public TimesheetUser(String name,String emailID,String password,String project){
        this.name = name;
        this.emailID = emailID;
        this.password = password;
        this.project = project;
    }

    public TimesheetUser(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }  
    
}
