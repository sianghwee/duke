package duke.parser;

import duke.command.*;
import duke.exception.*;
import duke.date.DukeDate;
import duke.task.*;

public class Parser {
    public static Command parse(String fullCommand) {
        String[] split = fullCommand.split(" ", 2);
        switch (split[0]) {
        case "list":
            return new ListCommand();
        case "delete":
            try {
                return new DeleteCommand(Integer.parseInt(split[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ErrorCommand(new InsufficientArgument());
            }
        case "done":
            try {
                return new DoneCommand(Integer.parseInt(split[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ErrorCommand(new InsufficientArgument());
            }
        case "todo":
            try {
                verifyDescription(split, 2);
                return new AddCommand(new Todo(split[1]));
            } catch (InvalidDescription e) {
                return new ErrorCommand(e);
            }
        case "event":
            try {
                verifyDescription(split, 2);
                String[] desc = splitDescription(split[1]);
                return new AddCommand(new Event(desc[0], desc[1]));
            } catch (InvalidDescription e) {
                return new ErrorCommand(e);
            } catch (InsufficientArgument e) {
                return new ErrorCommand(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ErrorCommand(new MissingPreposition(split[0]));
            }
        case "deadline":
            try {
                verifyDescription(split, 2);
                String[] desc = splitDescription(split[1]);
                return new AddCommand(new Deadline(desc[0], desc[1]));
            } catch (InvalidDescription e) {
                return new ErrorCommand(e);
            } catch (InsufficientArgument e) {
                return new ErrorCommand(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ErrorCommand(new MissingPreposition(split[0]));
            }
        default:
            return new ErrorCommand(new InvalidCommand());
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