package towerofhanoi;

import static org.junit.Assert.*;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  tests Disk methods
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class DiskTest extends student.TestCase
{
    //~ Fields ................................................................
    /**
     * declares a disk object
     */
    private Disk d1;
    //~ Constructors ..........................................................
    /**
     * initializes the disk object with a width of 10
     */
    public void setUp() {
        d1 = new Disk(10);
    }
    //~Public  Methods ........................................................
    
    /**
     * tests compareTo() method
     */
    public void testCompareTo() {
        Disk d2 = new Disk(1);
        assertEquals(9, d1.compareTo(d2));
        Disk d3 = new Disk(20);
        
        assertEquals(-10, d1.compareTo(d3));
        
        Disk d4 = new Disk(10);
        
        assertEquals(0, d1.compareTo(d4));
        
        d4 = null;
        
        Exception e = null;
        
        try {
            d1.compareTo(d4);
        }
        catch (Exception err) {
            e = err;
        }
        
        assertNotNull(e);
        
        assertTrue(e instanceof IllegalArgumentException);
    }
    
    /**
     * tests equals() method
     */
    public void testEquals() {
        Disk d2 = new Disk(1);
        Disk d = this.d1;
        String s = "hey";
        Disk d4 = new Disk(10);
        Disk d3 = null;
        
        assertTrue(d1.equals(d)); 
        assertTrue(d1.equals(d4)); 
        assertFalse(d1.equals(s));
        
        assertFalse(d1.equals(d2));
        assertFalse(d1.equals(d3));
        
    }
    /**
     * tests toString() method
     */
    public void testToString() {
        assertEquals("10", this.d1.toString());
    }
}
