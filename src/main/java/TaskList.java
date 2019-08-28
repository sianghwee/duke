package duke.task;

import java.util.ArrayList;

public class TaskList {
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

    public ArrayList<Task> find(String search) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasklist) {
            if (t.toString().contains(search)) {
                result.add(t);
            }
        }
        return result;
    }
}