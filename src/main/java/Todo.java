package duke.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public String toText() {
        return "T|" + super.toText();
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}