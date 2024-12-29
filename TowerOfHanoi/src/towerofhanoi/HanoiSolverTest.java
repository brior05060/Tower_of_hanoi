package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor 
//will I accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
 *  tests HanoiSolver methods
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class HanoiSolverTest extends student.TestCase
{
    //~ Fields ................................................................
    /**
     * declares a HanoSolver object
     */
    private HanoiSolver h1;
    //~ Constructors ..........................................................
    /**
     * initializes the HanoiSolver with 5 disks
     */
    public void setUp() {
        
        h1 = new HanoiSolver(5);
    }
    // ----------------------------------------------------------
    /**
     * tests disks() method
     */
    
    public void testDisks() {
        assertEquals(5, h1.disks());
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests getTower() method
     */
    public void testGetTower() {
        
        
        h1.getTower(Position.LEFT).push(new Disk(2));
        h1.getTower(Position.RIGHT).push(new Disk(10));
        h1.getTower(Position.CENTER).push(new Disk(5));
        
        
        
        
        assertEquals("[2]", h1.getTower(Position.LEFT).toString());
        assertEquals("[10]", h1.getTower(Position.RIGHT).toString());
        assertEquals("[5]", h1.getTower(Position.CENTER).toString());
        h1.getTower(Position.DEFAULT).push(new Disk(3));
        assertEquals("[3, 5]", h1.getTower(Position.DEFAULT).toString());
    
        
    }
    /**
     * tests toString() method
     */
    public void testToString() {
        assertEquals("[][][]", h1.toString());
        
        h1.getTower(Position.LEFT).push(new Disk(10));
        h1.getTower(Position.LEFT).push(new Disk(5));
        h1.getTower(Position.CENTER).push(new Disk(8));
        h1.getTower(Position.CENTER).push(new Disk(2));
        h1.getTower(Position.RIGHT).push(new Disk(8));
        
        assertEquals("[5, 10][2, 8][8]", h1.toString());
    }
    
    /**
     * tests solve() method which also tests move() 
     * and solveTowers()
 
     */
    
    public void testSolve() {
        h1.getTower(Position.LEFT).push(new Disk(10));
        h1.getTower(Position.LEFT).push(new Disk(5));
        h1.getTower(Position.LEFT).push(new Disk(3));
        h1.getTower(Position.LEFT).push(new Disk(2));
        h1.getTower(Position.LEFT).push(new Disk(1));
        assertEquals(5, h1.getTower(Position.LEFT).size());
        assertEquals(0, h1.getTower(Position.RIGHT).size());
        
        h1.solve();
        
        assertEquals(5, h1.getTower(Position.RIGHT).size());
        assertEquals(0, h1.getTower(Position.LEFT).size());
    }
}
