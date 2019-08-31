package duke.exception;

public class CorruptedData extends DukeException {
    private String data;

    public CorruptedData(String data) {
        this.data = data;
    }

    public String toString() {
        return String.format("This data (%s) is corrupted. Skipping...", data);
    }
}