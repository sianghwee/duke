package duke.task;

/**
 * Represent an Event that can be added to the task list.
 */
public class Event extends Task {
    private String time;

    /**
     * Creates an event with the specified description and time.
     * 
     * @param description the description of the event
     * @param time        the time of the event either in plain text or dd/mm/yyyy
     *                    hhmm
     * @throws ArrayIndexOutOfBoundsException if time does not contain a preposition
     *                                        at
     */
    public Event(String description, String time) throws ArrayIndexOutOfBoundsException {
        super(description);
        String[] temp = time.split(" ", 2);
        time = temp[0] + ": " + temp[1];
        this.time = time;
    }

    /**
     * Converts the event object to a text format. Allows the object to be saved
     * more easily in a text file.
     * 
     * @return a string representation of the task
     */
    public String toText() {
        return "E|" + super.toText() + "|" + String.join(" ", this.time.split(": "));
    }

    /**
     * Express the event object in its string representation.
     * 
     * @return a string representing the object
     */
    public String toString() {
        return "[E]" + super.toString() + String.format("(%s)", this.time);
    }
}