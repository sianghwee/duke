package duke.parser;

import duke.command.AddCommand;
import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ErrorCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.date.DukeDate;
import duke.exception.DukeException;
import duke.exception.InsufficientArgument;
import duke.exception.InvalidCommand;
import duke.exception.InvalidDescription;
import duke.exception.MissingPreposition;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

/**
 * Represents a parser class that is able to parse the string commands into
 * actual commands.
 */
public class Parser {
    /**
     * Process a string command and return back a command object.
     * 
     * @param fullCommand the full command that the user inputs in string
     * @return a command which could be executed
     */
    public static Command parse(String fullCommand) {
        String[] split = fullCommand.split(" ", 2);
        String[] desc;
        try {
            switch (split[0]) {
            case "list":
                return new ListCommand();
            case "delete":
                try {
                    return new DeleteCommand(Integer.parseInt(split[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InsufficientArgument();
                }
            case "done":
                try {
                    return new DoneCommand(Integer.parseInt(split[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InsufficientArgument();
                }
            case "todo":
                verifyDescription(split, 2);
                return new AddCommand(new Todo(split[1]));
            case "event":
                verifyDescription(split, 2);
                desc = splitDescription(split[1]);
                return new AddCommand(new Event(desc[0], desc[1]));
            case "deadline":
                verifyDescription(split, 2);
                desc = splitDescription(split[1]);
                return new AddCommand(new Deadline(desc[0], desc[1]));
            case "find":
                verifyDescription(split, 2);
                return new FindCommand(split[1]);
            case "bye":
                return new ByeCommand();
            default:
                throw new InvalidCommand();
            }
        } catch (DukeException e) {
            return new ErrorCommand(e);
        }
    }

    private static String[] splitDescription(String description) throws InsufficientArgument {
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

    private static void verifyDescription(String[] description, int size) throws InvalidDescription {
        if (description.length < size) {
            throw new InvalidDescription(description[0]);
        }
    }
}