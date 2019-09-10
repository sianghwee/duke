package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.task.TaskList;
import duke.storage.Storage;

public class FindCommand implements Command {
    private String search;

    public FindCommand(String search) {
        this.search = search;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.searchMessage(tasks.find(search));
    }
}