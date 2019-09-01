import duke.task.Task;
import duke.task.Todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testDone() {
        Task test = new Todo("test");
        test.doneTask();
        assertEquals("[T][O] test", test.toString());
    }
}
