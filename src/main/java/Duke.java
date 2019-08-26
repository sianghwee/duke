import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Duke {

    private static ArrayList<Task> db = new ArrayList<>();

    public static File getDbFile(String filename) {
        // Get the path of the current working directory
        String currDirPath = System.getProperty("user.dir");

        // Creates a new directory to store all the files if it does not exist
        String dbDirPath = currDirPath + "/db";
        File dbDir = new File(dbDirPath);
        if (!dbDir.exists()) {
            dbDir.mkdir();
        }

        // Creates a new text file within the database directory if it does not exist
        File dbFile = new File(dbDir, filename);
        try {
            dbFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        return dbFile;
    }

    public static Task textToTask(String text) {
        String[] textComponent = text.split("\\|");
        // System.out.println(textComponent.length);
        Task newTask = null;
        switch (textComponent[0]) {
        case "T":
            newTask = new Todo(textComponent[2]);
            break;
        case "D":
            newTask = new Deadline(textComponent[2], textComponent[3]);
            break;
        case "E":
            newTask = new Event(textComponent[2], textComponent[3]);
            break;
        }
        if (textComponent[1].equals("1")) {
            newTask.doneTask();
        }
        return newTask;
    }

    public static void loadTasks(String filename) {
        File dbFile = getDbFile(filename);

        try {
            BufferedReader readData = new BufferedReader(new FileReader(dbFile));
            String input;
            try {
                while ((input = readData.readLine()) != null) {
                    db.add(textToTask(input));
                }
                readData.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
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

    public static void removeTask(int index) {
        Task removed = db.remove(index);
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t  " + removed);
        System.out.println(String.format("\t Now you have %d tasks in your list", db.size()));
    }

    public static String getDescription(Scanner sc) throws InvalidDescription {
        String description = sc.nextLine().trim();
        if (description.length() == 0)
            throw new InvalidDescription();
        return description;
    }

    public static String[] splitDescription(String description) throws InsufficientArgument {
        String[] split = description.split("/", 2);
        if (split.length < 2) {
            throw new InsufficientArgument();
        }
        if (split[1].split(" |/").length == 5) {
            String[] temp = split[1].split(" ", 2);
            DukeDate dd = new DukeDate(temp[1]);
            temp[1] = dd.toString();
            split[1] = String.join(" ", temp);
        }
        return split;
    }

    public static void updateDb(String filename) {
        File dbFile = getDbFile(filename);
        try {
            BufferedWriter writeData = new BufferedWriter(new FileWriter(dbFile));
            for (Task t : db) {
                writeData.write(t.toText());
                writeData.newLine();
            }
            writeData.flush();
            writeData.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadTasks("test.txt");

        printLine();
        System.out.println("\t Hello! I'm Duke");
        System.out.println("\t What can I do for you?");
        printLine();
        System.out.println();

        String command;
        String description;
        String[] split;
        int index;
        while (sc.hasNext() && !(command = sc.next()).equals("bye")) {
            printLine();
            try {
                switch (command) {
                case "list":
                    printList();
                    break;
                case "done":
                    index = sc.nextInt();
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
                case "delete":
                    index = sc.nextInt() - 1;
                    removeTask(index);
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
            updateDb("test.txt");
            printLine();
            System.out.println();
        }

        printLine();
        System.out.println("\t Bye. Hope to see you again soon!");
        printLine();
        sc.close();
    }
}
