package com.v0ncent.augsburgcourseenrollerserver;

import com.v0ncent.augsburgcourseenrollerserver.Models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DatabaseConnector {
    private  String  URL = "jdbc:mysql://Localhost:3307/?user=root&password=password";
    private Student student;
    private Connection myConn = null;
    private Statement myStat;
    private LocalDate event;

    public void setUSER(Student stu){
        student = stu;
    }
    public void createStatment(){
        try {
            myStat = myConn.createStatement();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void createConnectionInstance(){
        try{
            myConn = DriverManager.getConnection(URL);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void createEventTime(){
        event = LocalDate.now();
    }
    //the actual sql statment that inserts the information (name,studentid,date)
    public String createSQL(){
        int enrolled = 0;
        if (student.isEnrolled()){enrolled = 1;}
        System.out.println("insert into `basic-database`.student_info (name, augsburg_id, event_log, Enrollment_Condition) values ('"
                +student.getName()+"', '"+student.getStudentId()+"', '"+event+"', '"+enrolled+"');");
        return
                ("insert into `basic-database`.student_info (name, augsburg_id, event_log, Enrollment_Condition) values ('"
                        +student.getName()+"', '"+student.getStudentId()+"', '"+event+"', '"+enrolled+"');");
    }
    //uses mystat to create an update statment for sql
    public void executeSQL(){
        try{
            myStat.executeUpdate(createSQL());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //combines other methods to generate all the variables in one method.
    public void initalizeVariables(Student student){
        setUSER(student);
        createStatment();
        createEventTime();
    }
    //runs connect to database instance, intialize variables and executes the sql update
    public void connectAndUpdate(Student stu){

        try{
            loadDriver();
            createConnectionInstance();
            initalizeVariables(stu);
            executeSQL();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    // initalize driver
    public void loadDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}