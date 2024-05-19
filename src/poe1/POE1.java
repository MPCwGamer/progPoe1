/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe1;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class POE1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Welcome to WORLD OF GAMERS");
    
  String choice;
        boolean loggedIn = false;

        // Create instances of the Register and Login classes
        register register = new register();
        Login login = new Login();

        // Loop to keep displaying menu until the user chooses to quit or logs in successfully
        while (!loggedIn) {
            choice = JOptionPane.showInputDialog("Option 1) Login\nOption 2) Register\nOption 3) Quit");

            // Check user choice
            if ("1".equals(choice) || "2".equals(choice) || "3".equals(choice)) {
                if ("3".equals(choice)) {
                    return; // Quit the program if the user chooses option 3
                }
                if ("2".equals(choice)) {
                    // Call the create method to handle registration
                    register.create();
                } else if ("1".equals(choice)) {
                    // Handle login
                    loggedIn = login.home(register);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please choose again.","fAILED",JOptionPane.ERROR_MESSAGE);
               break;
            }
        }

        // Task management menu, accessible only after successful login
        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to WORLD OF GAMERS ");
            TaskManager taskManager = new TaskManager();
            taskManager.displayMenu();
        }
    }
}