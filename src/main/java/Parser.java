class Parser {
    public static Command parse(String fullCommand) {
        String[] split = fullCommand.split(" |/");
        // for (String s : split) {
        // System.out.print(s);
        // }
        switch (split[0]) {
        case "list":
            return new ListCommand();
        case "delete":
            return new DeleteCommand(Integer.parseInt(split[1]));
        case "done":
            return new DoneCommand(Integer.parseInt(split[1]));
        default:
            return new TestCommand();
        }
    }
}