package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * An interface for all commands. Contains the execute method which needs to be
 * implemented by the individual classes.
 */
public interface Command {
    /**
     * The execute method which needs to be implemented by the classes.
     * 
     * @param tasks   a tasklist containing all the existing tasks
     * @param ui      a ui which will output the message
     * @param storage a storage object which will write to the file
     */
    public String execute(TaskList tasks, Ui ui, Storage storage);

    public default boolean isExit() {
        return false;
    }
}