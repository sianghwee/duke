import duke.task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testDone(){
        Task test = new Task("test");
        test.doneTask();
        assertEquals("[O] test", test.toString());
    }
}
