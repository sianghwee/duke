import duke.command.Command;
import duke.task.TaskList;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.parser.Parser;

/**
 * Represents a instance of Duke which is the main driver of the program
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Creates the Duke object which has a db file tagged to it.
     * 
     * @param filename the filename of the file to be referenced to
     */
    public Duke(String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the program
     */
    public void run() {
        ui.welcome();
        String fullCommand;
        while (!(fullCommand = ui.readCommand()).equals("bye")) {
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            c.execute(tasks, ui, storage);
            ui.printLine();
        }
        ui.byeMessage();
    }

    /**
     * The main driver of the program. Takes in the file to be referenced as a
     * command line argument. If no file is given, then the default file "test.txt"
     * is used.
     * 
     * @param args command line arguments that could include the filename of the
     *             file to be used
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            new Duke("test.txt").run();
        } else {
            new Duke(args[0]).run();
        }
    }
}