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
 *  Initializes a PuzzleWindow and runs the program
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class ProjectRunner
{

    public static void main(String[] args)
    {
        int disks = 5;
        if(args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow p1 = new PuzzleWindow(new HanoiSolver(disks));

    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
