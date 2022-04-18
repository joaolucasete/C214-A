import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {
    private IStack stack;

    @Before
    public void setup() {
        stack = new Stack();
    }

    @Test
    public void TestIfStackIsEmpty() {
        boolean res = stack.isEmpty();

        assertTrue(res);
    }

    @Test
    public void TestIfStackHasOneElement() {
        stack.push(2);

        int length = stack.size();

        assertEquals(1, length);
    }

    @Test
    public void TestIfStackReturnValueWhenElementIsRemoved() {
        stack.push(4);

        int res = stack.pop();

        assertEquals(4, res);
    }

    @Test
    public void TestIfStackReturnTheLastElementAdded() {
        stack.push(4);
        stack.push(20);
        stack.push(150);

        int res = stack.pop();

        assertEquals(150, res);
    }

    @Test(expected = EmptyStackException.class)
    public void TestIfThrowAExceptionIfRemoveAElementWhenStackIsEmpty() {
        int res = stack.pop();
    }
}
