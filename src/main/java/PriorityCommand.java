package duke.command;

import duke.exception.DukeException;
import duke.exception.InvalidArgument;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class PriorityCommand implements Command {
    private int index;
    private String priority;

    public PriorityCommand(int index, String priority) {
        this.index = index;
        this.priority = priority;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task t = tasks.getTask(index);
            switch(priority.toLowerCase()) {
                case "high":
                    t.setHighPriority();
                    break;
                case "medium":
                    t.setMedPriority();
                    break;
                case "low":
                    t.setLowPriority();
                    break;
                default:
                    throw new InvalidArgument();
            }

            storage.write(tasks);
            return ui.updatePriorityMessage(t);

        } catch (DukeException e) {
            return ui.errorMessage(e);
        }
    }
}
