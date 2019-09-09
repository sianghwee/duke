package duke.task;

public class FindPair {
    private Task task;
    private boolean status;

    public FindPair(Task task, boolean status){
        this.task = task;
        this.status = status;
    }

    public boolean isTrue(){
        return this.status;
    }

    public Task getTask(){
        return this.task;
    }
}
