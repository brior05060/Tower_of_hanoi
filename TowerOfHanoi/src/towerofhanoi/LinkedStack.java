package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Fall 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will 
//I accept the actions of those who do.
//-- Brendan Riordan (brior0506)


import java.util.EmptyStackException;
import stack.StackInterface;

// -------------------------------------------------------------------------
/**
 *  Stack implementation using Linked List
 *  @param <T>
 * 
 *  @author brend
 *  @version Oct 18, 2024
 */
public class LinkedStack<T> implements StackInterface<T>
{
    //~ Fields ................................................................
    private int size;
    private Node topNode;
    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    //~ Constructors ..........................................................
    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }
    // ----------------------------------------------------------
    /**
     * returns the size of the linkedstack
     * @return size of stack
     */
    
    
    public int size() {
        return this.size;
    }
    
    /**
     * checks if stack is empty
     * @return returns true if size == 0
     */
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * completely clears the stack
     */
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }
    /**
     * converts stack to string
     * @return string version of the stack
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        boolean firstItem = true;
        Node currNode = this.topNode;
        while (currNode != null) {
            if (!firstItem) {
                s.append(", ");
            }
            else {
                firstItem = false;
            }
            s.append(String.valueOf(currNode.getData()));
            currNode = currNode.getNextNode();
            
        }
        
        s.append("]");
        
        return s.toString();
        
        
        
        
    }
    
    /**
     * pushes anEntry to the top of the stack
     * @param anEntry the generic object being 
     * pushed to the top
     */
    public void push(T anEntry) {
        Node temp = this.topNode;
        this.topNode = new Node(anEntry);
        this.topNode.setNextNode(temp);
        this.size++;
    }
    
    /**
     * returns the top item of the stack and doesn't change
     * state of the stack
     * @return item that is on top of stack
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.topNode.getData();
    }
    
    /**
     * removes the item that is at the top of the stack
     * @return the item that was at the top
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        
        Node temp = this.topNode;
        
        this.topNode = this.topNode.getNextNode();
        
        this.size--;
        
        return temp.getData();
    }
    
    /**
     * // ------------------------
     * -------------------------------------------------
    /**
     *  Node class which is used to implement the stack
     * 
     *  @author brend
     *  @version Oct 18, 2024
     */
    private class Node {
        
        private T data;
        private Node next;
        
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(T data) {
            this(data, null);
        }
        
        public T getData() {
            return this.data;
        }
        
        public Node getNextNode() {
            return this.next;
        }
        
        public void setNextNode(Node n) {
            this.next = n;
        }
    }
}
