package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ByeCommand implements Command {
    public String execute(TaskList tasks, Ui ui, Storage storage){
        return ui.byeMessage();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
