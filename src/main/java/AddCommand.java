class AddCommand implements Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        ui.addMessage(task, tasks);
        storage.write(tasks);
    }
}