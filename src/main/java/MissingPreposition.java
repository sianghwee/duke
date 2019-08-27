public class MissingPreposition extends DukeException {

    private String command;

    public MissingPreposition(String command) {
        this.command = command;
    }

    public String toString() {
        return String.format("Oops!! %s requires a preposition for the time.", command);
    }
}