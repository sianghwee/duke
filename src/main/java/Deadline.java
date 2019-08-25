public class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        String[] temp = deadline.split(" ", 2);
        deadline = temp[0] + ": " + temp[1];
        this.deadline = deadline;
    }

    public String toText() {
        return "D|" + super.toText() + "|" + String.join(" ", this.deadline.split(": "));
    }

    public String toString() {
        return "[D]" + super.toString() + String.format("(%s)", this.deadline);
    }
}