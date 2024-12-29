package towerofhanoi;

import java.util.EmptyStackException;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the LinkedStacks methods
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class LinkedStackTest extends student.TestCase
{
    //~ Fields ................................................................
    //declares a linkedStack that stores Strings
    private LinkedStack<String> l1;
    //~ Constructors ..........................................................
    /**
     * initializes the LinkedStack
     */
    public void setUp() {
        l1 = new LinkedStack<>();
    }
    //~Public  Methods ........................................................

    /**
     * tests isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(l1.isEmpty());
        
        l1.push("H");
        
        assertFalse(l1.isEmpty());
        
        
    }
    /**
     * tests clear() method
     */
    public void testClear() {
        for (int i = 0; i < 10; i++) {
            l1.push("H");
            
        }
        
        assertFalse(l1.isEmpty());
        
        l1.clear();
        
        assertTrue(l1.isEmpty());
    }
    /**
     * tests peek() method
     */
    public void testPeek() {
        Exception e = null;
        
        try {
            l1.peek();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyStackException);
        
        l1.push("H");
        
        l1.push("B");
        
        l1.push("C");
        
        
        assertEquals("C", l1.peek());
        
        assertEquals(3, l1.size());
        
        l1.pop();
        
        assertEquals("B", l1.peek());
        
        
        
    }
    
    /**
     * tests pop() method
     */
    public void testPop() {
        Exception e = null;
        
        try {
            l1.pop();
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        assertTrue(e instanceof EmptyStackException);
        
        l1.push("H");
        
        l1.push("B");
        
        l1.push("C");
        
        assertEquals("C", l1.pop());
        
        assertEquals(2, l1.size());    
        
        assertEquals("B", l1.pop());
        
        assertEquals(1, l1.size());
    }
    /**
     * tests push() method
     */
    public void testPush() {
        l1.push("H");
        
        assertEquals(1, l1.size());
        
        assertEquals("H", l1.peek());
        
        l1.push("A");
        l1.push("A");
        l1.push("c");
        
        assertEquals(4, l1.size());
        
        assertEquals("c", l1.peek());
    }
    
    
    /**
     * tests size() method
     */
    public void testSize() {
        assertEquals(0, l1.size());
        
        l1.push("h");
        
        l1.push("h");
        
        assertEquals(2, l1.size());
    }
    
    /**
     * tests toString() method
     */
    public void testToString() {
        assertEquals("[]", l1.toString());
        
        
        l1.push("H");
        l1.push("E");
        l1.push("L");
        l1.push("L");
        l1.push("O");
        
        assertEquals("[O, L, L, E, H]", l1.toString());
        
        
    }
}
