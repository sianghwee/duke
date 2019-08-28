package duke.task;

public class Task {
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public void doneTask() {
        this.done = true;
    }

    public String toText() {
        String output = "0";
        if (done) {
            output = "1";
        }
        return output + "|" + this.description;
    }

    public String toString() {
        String output = "[X]";
        if (done)
            output = "[O]";
        return output + " " + this.description;
    }
}