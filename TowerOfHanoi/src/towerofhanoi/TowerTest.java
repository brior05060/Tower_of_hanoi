package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests methods for the Tower class
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class TowerTest extends student.TestCase
{
    //~ Fields ................................................................
    /**
     * declares two tower objects
     */
    private Tower t1;
    private Tower t2;
    //~ Constructors ..........................................................
    /**
     * initializes both tower objects
     */
    public void setUp() {
        t1 = new Tower(Position.DEFAULT);
        t2 = new Tower(Position.LEFT);
    }
    
    // ----------------------------------------------------------
    /**
     * tests position() method
     */
    public void testPosition() {
        assertEquals(Position.DEFAULT, t1.position());
        
        assertEquals(Position.LEFT, t2.position());
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests push() method
     */
    public void testPush() {
        Disk d1 = new Disk(10);
        
        Disk d2 = new Disk(5);
        Disk d3 = new Disk(10);
        Disk d4 = new Disk(20);
        Disk d5 = null;
        
        Exception e = null;
        try {
            t1.push(d5);
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        
        assertTrue(e instanceof IllegalArgumentException);
        
        t1.push(d1);
        
        assertEquals(1, t1.size());
        
        Exception e2 = null;
        
        try {
            t1.push(d4);
        }
        catch (Exception err) {
            e2 = err;
        }
        
        assertNotNull(e2);
        
        assertTrue(e2 instanceof IllegalStateException);
        
        Exception e3 = null;
        
        try {
            t1.push(d3);
        }
        catch (Exception err) {
            e3 = err;
        }
        
        assertNotNull(e3);
        
        assertTrue(e3 instanceof IllegalStateException);
        
        t1.push(d2);
        
        assertEquals(2, t1.size());
    }
}
