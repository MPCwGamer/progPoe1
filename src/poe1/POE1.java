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

        register register = new register();
        Login login = new Login();

        while (!loggedIn) {
            choice = JOptionPane.showInputDialog("Option 1) Login\nOption 2) Register\nOption 3) Quit");

            if ("1".equals(choice) || "2".equals(choice) || "3".equals(choice)) {
                if ("3".equals(choice)) {
                    return;
                }
                if ("2".equals(choice)) {
                    register.create();
                } else if ("1".equals(choice)) {
                    loggedIn = login.home(register);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please choose again.", "fAILED", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to WORLD OF GAMERS");
            TaskManager taskManager = new TaskManager();
            taskManager.displayMenu();
        }
    }
}