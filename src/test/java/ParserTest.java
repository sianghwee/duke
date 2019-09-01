import duke.command.AddCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ListCommand;
import duke.command.ErrorCommand;
import duke.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void testListCommand() {
        assertTrue(Parser.parse("list") instanceof ListCommand);
    }

    @Test
    public void testAddCommand() {
        assertTrue(Parser.parse("todo test") instanceof AddCommand);
    }

    @Test
    public void testDeleteCommand() {
        assertTrue(Parser.parse("delete 1") instanceof DeleteCommand);
    }

    @Test
    public void testDoneCommand() {
        assertTrue(Parser.parse("done 1") instanceof DoneCommand);
    }

    @Test
    public void testErrorCommand() {
        assertTrue(Parser.parse("delete") instanceof ErrorCommand);
    }
}
