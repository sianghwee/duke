class Sapu {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Sapu(String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.welcome();
        String fullCommand;
        while (!(fullCommand = ui.readCommand()).equals("bye")) {
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            c.execute(tasks, ui, storage);
            ui.printLine();
        }
        ui.byeMessage();
    }

    public static void main(String[] args) {
        new Sapu("test.txt").run();

    }
}