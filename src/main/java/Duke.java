import java.util.Scanner;

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

    public static void main(String[] args) {
        printLogo();
        Scanner sc = new Scanner(System.in);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        printLine();
        System.out.println();

        String command;
        while (!(command = sc.next()).equals("bye")) {
            printLine();
            System.out.println("\t" + command);
            printLine();
            System.out.println();
        }

        printLine();
        System.out.println("\tBye. Hope to see you again soon!");
        printLine();
        sc.close();
    }
}
