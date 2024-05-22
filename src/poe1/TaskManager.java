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

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task.checkTaskDescription()) {
            tasks.add(task);
            JOptionPane.showMessageDialog(null, "Task successfully captured");
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Task Creation Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int returnTotalHours() {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    public void displayTotalHours() {
        int totalHours = returnTotalHours();
        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalHours + " hours");
    }

    public void displayMenu() {
        boolean quit = false;
        while (!quit) {
            String choice = JOptionPane.showInputDialog("Option 1) Add tasks\nOption 2) Show report\nOption 3) Quit");
            switch (choice) {
                case "1":
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add"));
                    for (int i = 0; i < numTasks; i++) {
                        addTask(new Task(
                                JOptionPane.showInputDialog("Enter Task Name"),
                                i,
                                JOptionPane.showInputDialog("Enter Task Description (max 50 characters)"),
                                JOptionPane.showInputDialog("Enter Developer Details (First and Last Name)"),
                                Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours)")),
                                (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Done", "Doing"}, "To Do")
                        ));
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

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}