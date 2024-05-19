/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe1;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class TaskManager {
   
 private ArrayList<Task> tasks;

    // Constructor to initialize the task list
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
  public void addTask(int taskNumber) {
    String taskName = JOptionPane.showInputDialog("Enter Task Name");
    String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters)");
    String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First and Last Name)");
    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours)"));
     String[] statuses = {"To Do", "Done", "Doing"};
     String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

        Task task = new Task(taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskStatus);

  if (task.checkTaskDescription()) {
    tasks.add(task);
     JOptionPane.showMessageDialog(null, "Task successfully captured");
     JOptionPane.showMessageDialog(null, task.printTaskDetails());
  } else {
    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Task Creation Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to calculate total task hours
    public int returnTotalHours() {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    // Method to display the total hours
    public void displayTotalHours() {
        int totalHours = returnTotalHours();
        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalHours + " hours");
    }

    // Method to display the task management menu
 public void displayMenu() {
     boolean quit = false;
 while (!quit) {
     String choice = JOptionPane.showInputDialog("Option 1) Add tasks\nOption 2) Show report\nOption 3) Quit");
 switch (choice) {
   case "1":
       int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add"));
     for (int i = 0; i < numTasks; i++) {
        addTask(i);
  }
    break;
  case "2":
      JOptionPane.showMessageDialog(null, "Coming Soon");
     break;
   case "3":
       quit = true;
        break;
  default:
     JOptionPane.showMessageDialog(null, "Invalid choice. Please choose again.", "Invalid Choice", JOptionPane.ERROR_MESSAGE);
        break;
            }
        }
    displayTotalHours();
    }
}