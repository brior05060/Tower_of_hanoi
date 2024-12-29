package towerofhanoi;

import java.util.Observable;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor 
//will I accept the actions of those who do.
//-- Brendan Riordan (brior0506)

/**
 * // -------------------------------------------------------------------------
/**
    defines a hanoiSolver object which is the backend and implements the 
    hanoi solution
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class HanoiSolver
    extends Observable
{
    //~ Fields ................................................................
    private Tower left;
    private Tower center;
    private Tower right;
    private int numDisks;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object.
     * @param numDisks number of disks in the solver
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.center = new Tower(Position.CENTER);
        this.right = new Tower(Position.RIGHT);
        
    }
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * returns number of disks in the hanoi solver
     * @return the number of disks
     */
    public int disks() {
        return this.numDisks;
    }
    
    // ----------------------------------------------------------
    /**
     * gets the tower based on the position passed through
     * the parameter
     * @param pos position from Position enum
     * @return the specified tower object
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return this.left;
            case CENTER:
                return this.center;
            case RIGHT:
                return this.right;
            default:
                return this.center;
            
        }
            
    }
    
    /**
     * converts the HanoiSolver into string format
     * @return a String of all the individual towers
     */
    
    public String toString() {
        return this.left.toString() + this.center.toString() + 
            this.right.toString();
    }
    
    /**
     * moves a disk from source tower to destination tower
     * @param source starting tower
     * @param destination ending tower
     * 
     */
    private void move(Tower source, Tower destination) {
        Disk temp = source.pop();
        
        destination.push(temp);
        
        setChanged();
        
        notifyObservers(destination.position());
    }
    
    /**
     * based on currentDisks, recursively solves the Hanoi tower by
     * rearranging startPole, tempPole and endPole
     * @param currentDisks current disks in the tower
     * @param startPole the pole the algorithm begins with
     * @param endPole the pole the algorithm ends with
     * @param tempPole the pole the algorithm uses to get
     * from start to end
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
            
        }
        
        
        
        
        
    }
    
    // ----------------------------------------------------------
    /**
     * implements the recursive call and allows solveTowers
     * to be used
     * outside of this class
     */
    public void solve() {
        this.solveTowers(this.numDisks, this.left, this.center, this.right);
    }
}
