import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void printLogo() {
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void printLine() {
        String line = "____________________________________________________________";
        System.out.println("\t" + line);
    }

    public static void printList(ArrayList<Task> db) {
        int index = 1;
        for (Task task : db) {
            String output = String.format("\t %d. %s", index, task.toString());
            System.out.println(output);
            index++;
        }
    }

    public static void main(String[] args) {
        printLogo();
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> db = new ArrayList<>();

        printLine();
        System.out.println("\t Hello! I'm Duke");
        System.out.println("\t What can I do for you?");
        printLine();
        System.out.println();

        String command;
        while (!(command = sc.nextLine()).equals("bye")) {
            printLine();
            switch (command) {
            case "list":
                printList(db);
                break;
            default:
                db.add(new Task(command));
                System.out.println("\t added: " + command);
            }
            printLine();
            System.out.println();
        }

        printLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printLine();
        sc.close();
    }
}
