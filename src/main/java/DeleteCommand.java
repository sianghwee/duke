class DeleteCommand implements Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.removeTask(index);
        ui.deleteMessage(t, tasks);
    }
}