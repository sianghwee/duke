class DoneCommand implements Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.getTask(index);
        t.doneTask();
        ui.updateMessage(t);
    }
}