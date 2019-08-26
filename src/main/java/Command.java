interface Command {
    public void execute(TaskList tasks, Ui ui, Storage storage);
}

class TestCommand implements Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("executed");
    }
}