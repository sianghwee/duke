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

    public String toString() {
        String output = "[✗]";
        if (done)
            output = "[✓]";
        return output + " " + this.description;
    }
}