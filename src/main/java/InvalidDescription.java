package duke.exception;

public class InvalidDescription extends DukeException {
    private String command;

    public InvalidDescription(String command) {
        this.command = command;
    }

    public String toString() {
        return String.format("OOPS!!! The description of a %s cannot be empty.", command);
    }
}