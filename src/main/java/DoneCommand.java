package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represent a command to mark a task as done
 */
public class DoneCommand implements Command {
    private int index;

    /**
     * Creates a command to mark the task specified as done
     * 
     * @param index an integer value of the index of the task in the list
     */
    public DoneCommand(int index) {
        this.index = index;
    }

    /**
     * Execute the command and mark the task as done. Takes in a tasklist to which
     * the task will be mark as done, a ui which will output the message and a
     * storage which updates the task in the file
     * 
     * @param tasks   a tasklist containing all the existing tasks
     * @param ui      a ui which will output the message
     * @param storage a storage object which will write to the file
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.getTask(index);
        t.doneTask();
        ui.updateMessage(t);
        storage.write(tasks);
    }
}