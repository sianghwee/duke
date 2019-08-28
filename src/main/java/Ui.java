package duke.ui;

import java.util.Scanner;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.Task;

public class Ui {
    public void printLine() {
        String line = "____________________________________________________________";
        System.out.println("\t" + line);
    }

    public void welcome() {
        this.printLine();
        System.out.println("\t Hello, I'm Duke!");
        System.out.println("\t What can I do for you?");
        this.printLine();
    }

    public void printList(TaskList db) {
        System.out.println("\t Here are the tasks in your list:");
        int index = 1;
        for (Task task : db.getList()) {
            String output = String.format("\t %d. %s", index, task.toString());
            System.out.println(output);
            index++;
        }
    }

    public String readCommand() {
        return new Scanner(System.in).nextLine();
    }

    public void deleteMessage(Task task, TaskList db) {
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t  " + task);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    public void updateMessage(Task task) {
        System.out.print("\t ");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t  " + task.toString());
    }

    public void addMessage(Task task, TaskList db) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    public void errorMessage(DukeException e) {
        System.out.println("\t " + e.toString());
    }

    public void byeMessage() {
        printLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printLine();
    }
}