/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe1;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    
private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    // Constructor to initialize the task with given details
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    // Method to check if the task description is valid
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    // Method to create and return the task ID
    public String createTaskID() {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String developerEnd = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + developerEnd;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Getter for task duration
    public int getTaskDuration() {
        return taskDuration;
    }
}
