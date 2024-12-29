package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
// -------------------------------------------------------------------------
/**
 *  Methods and fields of the tower class
 *   that allows towers to be made with different
 *  positions. extends LinkedStack that store disks. Tower imitates a stack
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class Tower extends LinkedStack<Disk>
{
    //~ Fields ................................................................
    /**
     * declares the Position enum
     */
    private Position position;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Tower object.
     * @param position position the tower will be
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
   
    // ----------------------------------------------------------
    /**
     * returns position of tower object
     * @return this.position
     */
    public Position position() {
        return this.position;
    }
    
    /**
     * pushes disk onto tower if disks width is less than
     * the width of the disk on the top of this tower
     * @param disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
