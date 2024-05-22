/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe1;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author RC_Student_lab
 */
public class AppTest {
     private register register;
    private Login login;
    private TaskManager taskManager;
    private Task task;

    @Before
    public void setUp() {
        register = new register();
        login = new Login();
        taskManager = new TaskManager();
        task = new Task("Task1", 1, "Description", "Dev Dev", 5, "To Do");
    }

    // Tests for the register class
    @Test
    public void testCreateValidUsernameAndPassword() {
        // Simulate user input
        boolean result = register.create("user_", "Pass123!");

        assertTrue(result);
        assertEquals("user_", register.getUserName());
        assertEquals("Pass123!", register.getPassword());
    }

    @Test
    public void testInvalidUsername() {
        // Simulate invalid username input
        boolean result = register.create("user", "Pass123!");
        assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        // Simulate invalid password input
        boolean result = register.create("user_", "password");
        assertFalse(result);
    }

    // Tests for the Login class
    @Test
    public void testLoginSuccess() {
        register.create("user_", "Pass123!");
        boolean result = login.home(register, "user_", "Pass123!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        register.create("user_", "Pass123!");
        boolean result = login.home(register, "user_", "WrongPass");
        assertFalse(result);
    }

    // Tests for the Task class
    @Test
    public void testCheckTaskDescriptionValid() {
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testCheckTaskDescriptionInvalid() {
        Task invalidTask = new Task("Task1", 1, "This description is definitely more than fifty characters long.", "Dev Dev", 5, "To Do");
        assertFalse(invalidTask.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        assertEquals("TA:1:DEV", task.createTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        String expected = "Task Status: To Do\n" +
                          "Developer Details: Dev Dev\n" +
                          "Task Number: 1\n" +
                          "Task Name: Task1\n" +
                          "Task Description: Description\n" +
                          "Task ID: TA:1:DEV\n" +
                          "Duration: 5 hours";
        assertEquals(expected, task.printTaskDetails());
    }

    // Tests for the TaskManager class
    @Test
    public void testAddTask() {
        taskManager.addTask(task);
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testReturnTotalHours() {
        taskManager.addTask(new Task("Task1", 1, "Description", "Dev Dev", 5, "To Do"));
        taskManager.addTask(new Task("Task2", 2, "Description", "Dev Dev", 3, "To Do"));
        assertEquals(8, taskManager.returnTotalHours());
    }
}  

