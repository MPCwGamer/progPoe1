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
public class register { 
   private String userName;
    private String password;

    public register() {
        this.userName = "";
        this.password = "";
    }

    public void create() {
        while (true) {
            String firstName = JOptionPane.showInputDialog("Enter First Name");
            String lastName = JOptionPane.showInputDialog("Enter Last Name");
            userName = JOptionPane.showInputDialog("Create a User Name (contains an underscore and is no more than 5 characters)");

            if (userName.contains("_") && userName.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.","fAILED",JOptionPane.ERROR_MESSAGE);
                continue;
            }

            password = JOptionPane.showInputDialog("Enter your Password (at least 8 characters, a capital letter, a number, and a special character)");

            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()_+{}\\[\\]|`~\\-=;',./<>?].*")) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.","fAILED",JOptionPane.ERROR_MESSAGE);
                continue;
            } 
          
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}


