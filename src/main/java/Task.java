package duke.task;

/**
 * Represents the abstract class of Tasks which are used to represent different
 * tasks.
 */
public abstract class Task {
    enum Priority{
        HIGH, MEDIUM, LOW;
    }

    private String description;
    private boolean done;
    private Priority priority;

    /**
     * Creates a task object with the supplied description. By default, the task is
     * marked as undone.
     * 
     * @param description string representation of the task
     */
    public Task(String description) {
        this.description = description;
        this.done = false;
        this.priority = Priority.MEDIUM;
    }

    /**
     * Marks a task as done.
     */
    public void doneTask() {
        this.done = true;
    }

    public void setHighPriority() {
        this.priority = Priority.HIGH;
    }

    public void setLowPriority() {
        this.priority = Priority.LOW;
    }

    public void setMedPriority() {
        this.priority = Priority.MEDIUM;
    }

    /**
     * Converts the task object to a text format. Allows the object to be saved more
     * easily in a text file.
     * 
     * @return a text representation of the task
     */
    public String toText() {
        String output = "0";
        if (done) {
            output = "1";
        }
        return output + "|" + this.description;
    }

    /**
     * Express the task object in its string representation.
     * 
     * @return a string representing the object
     */
    public String toString() {
        String output = "[X]";
        if (done) {
            output = "[O]";
        }

        switch (priority) {
            case LOW:
                output += "[L]";
                break;
            case MEDIUM:
                output += "[M]";
                break;
            case HIGH:
                output += "[H]";
                break;
            default:
                //no default as all cases are taken care of within the enum
        }
        return output + " " + this.description;
    }
}