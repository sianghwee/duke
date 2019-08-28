package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ErrorCommand implements Command {
    private DukeException e;

    public ErrorCommand(DukeException e) {
        this.e = e;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.errorMessage(e);
    }
}