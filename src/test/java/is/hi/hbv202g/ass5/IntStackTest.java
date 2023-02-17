package is.hi.hbv202g.ass5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntStackTest {

    private IntStack stack;

    @Before
    public void makeStackTestObject() {
        stack = new IntStack();
    }

    @Test
    public void testNewStackIsNotFull() {
        assertFalse(stack.isFull());
    }

    @Test
    public void testFullStackIsFull() {
        for (int i = 0; i < stack.getCapacity(); i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    public void testStackOneLessThanFull() {
        for (int i = 0; i < stack.getCapacity() - 1; i++) {
            stack.push(i);
        }
        assertFalse(stack.isFull());
    }

    @Test
    public void testPopReturnsPushedValue() {
        stack.push(7);
        stack.push(8);
        assertEquals(8, stack.pop());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopOnEmptyStack() {
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPushOnFullStack() {
        for (int i = 0; i < stack.getCapacity(); i++) {
            stack.push(i);
        }
        stack.push(7);
    }

    @Test
    public void StackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void StackIsNotEmpty() {
        stack.push(7);
        assertFalse(stack.isEmpty());
    }
}