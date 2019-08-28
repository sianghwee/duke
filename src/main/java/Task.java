package duke.task;

/**
 * Represents the abstract class of Tasks which are used to represent different
 * tasks
 */
public abstract class Task {
    private String description;
    private boolean done;

    /**
     * Creates a task object with the supplied description. By default, the task is
     * marked as undone.
     * 
     * @param description string representation of the task
     */
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    /**
     * Marks a task as done.
     */
    public void doneTask() {
        this.done = true;
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
        if (done)
            output = "[O]";
        return output + " " + this.description;
    }
}