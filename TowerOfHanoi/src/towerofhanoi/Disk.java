package towerofhanoi;

import cs2.Shape;
//Virginia Tech Honor Code Pledge

//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I
//accept the actions of those who do.
//-- Brendan Riordan (brior0506)



import student.TestableRandom;

import java.awt.Color;
/**
 * // -------------------------------------------------------------------------
/**
 *  defines a Disk object which extends shape. To be placed on top of towers
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class Disk extends Shape implements Comparable<Disk>
{
    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * @param width desired width of disk
     */
    
    
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rand = new TestableRandom();
        this.setBackgroundColor(new Color(rand.nextInt(256), 
            rand.nextInt(256), rand.nextInt(256)));
    }
    //~Public  Methods ........................................................
    
    /**
     * compares two disk objects
     * @param otherDisk other disk being compared
     * @return the difference between this disks width and the other disks
     * width
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        
        return this.getWidth() - otherDisk.getWidth();
    }
    
    /**
     * checks if two disks are equal to each other
     * @param obj the other disk in the equality check
     * @return returns true if both disks widths are equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
           
        }
        if (obj.getClass().equals(this.getClass())) {
            Disk other = (Disk) obj;
            
            return this.getWidth() == other.getWidth();
        }
        return false;
    }
    
    /**
     * turns disk into a string form
     * @return the disks width as a string
     */
    public String toString() {
        return "" + this.getWidth();
    }
}


