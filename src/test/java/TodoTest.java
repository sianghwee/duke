
import duke.task.Todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TodoTest {
    @Test
    public void testToString() {
        assertEquals("[T][X][M] test", new Todo("test").toString());
    }

    @Test
    public void testToText() {
        assertEquals("T|0|M|test", new Todo("test").toText());
    }
}