import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private static ArrayList<Task> db = new ArrayList<>();

    public static void printLogo() {
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void printLine() {
        String line = "____________________________________________________________";
        System.out.println("\t" + line);
    }

    public static void printList() {
        System.out.println("\t Here are the tasks in your list:");
        int index = 1;
        for (Task task : db) {
            String output = String.format("\t %d. %s", index, task.toString());
            System.out.println(output);
            index++;
        }
    }

    public static void updateTask(Task task) {
        task.doneTask();
        System.out.print("\t ");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t  " + task.toString());
    }

    public static void updateList(Task task) {
        db.add(task);
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    public static String getDescription(Scanner sc) throws InvalidDescription {
        String description = sc.nextLine().trim();
        if (description.length() == 0)
            throw new InvalidDescription();
        return description;
    }

    public static String[] splitDescription(String description) throws InsufficientArgument {
        String[] split = description.split("/");
        if (split.length < 2)
            throw new InsufficientArgument();
        return split;
    }

    public static void main(String[] args) {
        printLogo();
        Scanner sc = new Scanner(System.in);

        printLine();
        System.out.println("\t Hello! I'm Duke");
        System.out.println("\t What can I do for you?");
        printLine();
        System.out.println();

        String command;
        String description;
        String[] split;
        while (!(command = sc.next()).equals("bye")) {
            printLine();
            try {
                switch (command) {
                case "list":
                    printList();
                    break;
                case "done":
                    int index = sc.nextInt();
                    Task selectedTask = db.get(index - 1);
                    updateTask(selectedTask);
                    break;
                case "todo":
                    description = getDescription(sc);
                    updateList(new Todo(description));
                    break;
                case "deadline":
                    description = getDescription(sc);
                    split = splitDescription(description);
                    updateList(new Deadline(split[0], split[1]));
                    break;
                case "event":
                    description = getDescription(sc);
                    split = splitDescription(description);
                    updateList(new Event(split[0], split[1]));
                    break;
                default:
                    throw new InvalidCommand();
                }
            } catch (InvalidDescription e) {
                System.out.println(String.format("\t OOPS!!! The description of a %s cannot be empty.", command));
            } catch (InsufficientArgument e) {
                System.out.println(String.format("\t OOPS!!! %s requires a time.", command));
            } catch (InvalidCommand e) {
                System.out.println("\t OOPS!!! I'm sorry, but I don't know what that means.");
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
