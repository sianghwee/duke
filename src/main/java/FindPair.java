package duke.task;

public class FindPair {
    private Task task;
    private boolean found;

    public FindPair(Task task, boolean found){
        this.task = task;
        this.found = found;
    }

    public boolean isFound(){
        return this.found;
    }

    public Task getTask(){
        return this.task;
    }
}
