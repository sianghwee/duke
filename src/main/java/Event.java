public class Event extends Task {
    private String time;

    public Event(String description, String time) throws ArrayIndexOutOfBoundsException {
        super(description);
        String[] temp = time.split(" ", 2);
        time = temp[0] + ": " + temp[1];
        this.time = time;
    }

    public String toText() {
        return "E|" + super.toText() + "|" + String.join(" ", this.time.split(": "));
    }

    public String toString() {
        return "[E]" + super.toString() + String.format("(%s)", this.time);
    }
}