/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe1;
 import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    public boolean home(register registeredUser) {
        boolean loggedIn = false;
        boolean registered = !registeredUser.getUserName().isEmpty();

        if (!registered) {
            int option = JOptionPane.showConfirmDialog(null, "You need to register before you can login.\nWould you like to register now?", "Register", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            switch (option) {
                case JOptionPane.YES_OPTION:
                    registeredUser.create();
                    break;
                case JOptionPane.NO_OPTION:
                    return false;
                case JOptionPane.CANCEL_OPTION:
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

        int tries = 0;
        while (!loggedIn && tries < 3) {
            String enteredUsername = JOptionPane.showInputDialog("Enter your username:");
            String enteredPassword = JOptionPane.showInputDialog("Enter your password:");

            String registeredUsername = registeredUser.getUserName();
            String registeredPassword = registeredUser.getPassword();

            if (enteredUsername.equals(registeredUsername) && enteredPassword.equals(registeredPassword)) {
                JOptionPane.showMessageDialog(null, "Welcome back, " + registeredUsername + "!");
                loggedIn = true;
            } else {
                tries++;
                JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!loggedIn) {
            JOptionPane.showMessageDialog(null, "You've exceeded the maximum number of login attempts. Please try again later.", "fAILED", JOptionPane.ERROR_MESSAGE);
        }

        return loggedIn;
    }

    // Added overloaded method to support direct input for testing
    public boolean home(register registeredUser, String enteredUsername, String enteredPassword) {
        if (enteredUsername.equals(registeredUser.getUserName()) && enteredPassword.equals(registeredUser.getPassword())) {
            return true;
        }
        return false;
    }
}
    

    
   
   

