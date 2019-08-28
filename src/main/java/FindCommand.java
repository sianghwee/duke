package duke.command;

import duke.ui.Ui;
import duke.task.TaskList;
import duke.storage.Storage;

public class FindCommand implements Command {
    private String search;

    public FindCommand(String search) {
        this.search = search;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.searchMessage(tasks.find(search));
    }
}