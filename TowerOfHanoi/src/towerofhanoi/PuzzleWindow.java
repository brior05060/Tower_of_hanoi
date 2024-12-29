package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Name (pid)
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)
/**
 * The main front-end work and the view for the Tower of Hanoi puzzle (Fall 2024)
 *
 * @author Brendan Riordan
 * @version 10/15/2024
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;


    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) {
        this.game = g;
        game.addObserver(this);
        this.window = new Window("Tower of Hanoi");
        this.window.setSize(600,800);
        
      //The height and Y location of each pole are the same
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        center = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        
        for(int i = (this.game.disks()+1) * WIDTH_FACTOR; i>WIDTH_FACTOR;i-=WIDTH_FACTOR) {
            Disk d = new Disk(i);
            this.window.addShape(d);
            this.game.getTower(Position.LEFT).push(d);
            moveDisk(Position.LEFT);
        }
        
        this.window.addShape(this.left);
        this.window.addShape(this.center);
        this.window.addShape(this.right);
        
        Button solve = new Button("Solve");
        this.window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }

    private void moveDisk(Position position) {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole;
        if(position.equals(Position.LEFT)) {
            currentPole = this.left;
        }
        else if(position.equals(Position.RIGHT)) {
            currentPole = this.right;
        }
        else {
            currentPole = this.center;
        }
        
        int xCoord = currentPole.getX() -((currentDisk.getWidth()-currentPole.getWidth())/2);
        int yCoord = currentPole.getY() +(currentPole.getHeight()-(currentDisk.getHeight()*this.game.getTower(position).size()));
        
        currentDisk.moveTo(xCoord, yCoord);
    }

    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o   The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }

    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

    private void sleep() {
        try {
            Thread.sleep(500/this.game.disks());
        }
        catch (Exception e) {
        }
    }
}
