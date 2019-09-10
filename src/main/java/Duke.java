package duke.driver;

import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a instance of Duke which is the main driver of the program.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke() {
        this("test.txt");
    }

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
     * Runs the program.
     */
    public void run() {
        ui.welcome();
        String fullCommand;
        while (ui.hasNext() && !(fullCommand = ui.readCommand()).equals("bye")) {
            ui.printLine();
            try {
                Command c = Parser.parse(fullCommand);
                System.out.println(c.execute(tasks, ui, storage));
            } catch (DukeException e) {
                ui.errorMessage(e);
            }
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
            new Duke().run();
        } else {
            new Duke(args[0]).run();
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return ui.errorMessage(e);
        }
    }
}