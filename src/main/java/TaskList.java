import java.util.ArrayList;

class TaskList {
    private ArrayList<Task> tasklist;

    public TaskList() {
        this.tasklist = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.tasklist = list;
    }

    public ArrayList<Task> getList() {
        return this.tasklist;
    }

    public void addTask(Task task) {
        tasklist.add(task);
    }

    public Task removeTask(int index) {
        return tasklist.remove(index - 1);
    }

    public Task getTask(int index) {
        return tasklist.get(index - 1);
    }

    public int size() {
        return tasklist.size();
    }
}