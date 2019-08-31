package duke.ui;

import java.util.Scanner;
import java.util.ArrayList;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.Task;

/**
 * Represent the Ui object that is used for the user interaction i.e. the input
 * and the output from the program.
 */
public class Ui {
    /**
     * Prints a horizontal line.
     */
    public void printLine() {
        String line = "____________________________________________________________";
        System.out.println("\t" + line);
    }

    /**
     * Prints the welcome message between two horizontal lines.
     */
    public void welcome() {
        this.printLine();
        System.out.println("\t Hello, I'm Duke!");
        System.out.println("\t What can I do for you?");
        this.printLine();
    }

    /**
     * Prints the list of tasks within a tasklist.
     * 
     * @param db the tasklist which contains all the tasks
     */
    public void printList(TaskList db) {
        System.out.println("\t Here are the tasks in your list:");
        int index = 1;
        for (Task task : db.getList()) {
            String output = String.format("\t %d. %s", index, task.toString());
            System.out.println(output);
            index++;
        }
    }

    /**
     * Reads the command from the user input and return it to the parser.
     * 
     * @return a string containing all the user's command
     */
    public String readCommand() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Print the message when a task is deleted from the task list.
     * 
     * @param task the task that is deleted
     * @param db   the tasklist where the task is deleted from
     */
    public void deleteMessage(Task task, TaskList db) {
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t  " + task);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    /**
     * Prints the message when a task is marked as done.
     * 
     * @param task the task that is to be mark as done
     */
    public void updateMessage(Task task) {
        System.out.print("\t ");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t  " + task.toString());
    }

    /**
     * Prints the message when a task is added to the tasklist.
     * 
     * @param task the task that is to be added to the tasklist
     * @param db   the tasklist that contains all the tasks
     */
    public void addMessage(Task task, TaskList db) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    /**
     * Prints the error message when an exception is faced.
     * 
     * @param e the exception that is faced
     */
    public void errorMessage(DukeException e) {
        System.out.println("\t " + e.toString());
    }

    /**
     * Prints the bye message when the user leaves the program between two line.
     */
    public void byeMessage() {
        printLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Prints the message when the tasks are found.
     * 
     * @param db the list which the tasks are to be searched from
     */
    public void searchMessage(ArrayList<Task> db) {
        System.out.println("\t Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : db) {
            String output = String.format("\t %d. %s", index, task.toString());
            System.out.println(output);
            index++;
        }
    }
}