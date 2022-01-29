import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException();
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if (head==null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException();
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if (head==null) {
            head = newNode;
            tail = newNode;
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {

        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<>(head.getData());
            head = null;
            tail = null;
            size--;
            return temp.getData();
        } else {
            SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<>(head.getData());
            head = head.getNext();
            size--;
            return temp.getData();
        }
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        //test
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<>(head.getData());
            head = null;
            tail = null;
            size--;
            return temp.getData();
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<>(current.getNext().getData());
            current.setNext(null);
            tail = current;
            size--;
            return temp.getData();
        }
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    
    public void testPrint() {
        String answer = "";
        SinglyLinkedListNode<T> current = head;
        while (current != null) {
            answer += current.getData() + " ";
            current = current.getNext();
        }
        System.out.println(answer); 
    }
    public static void main(String args[]) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addToFront("1");
        list.addToBack("2");
        list.addToFront("3");
        list.addToFront("4");
        list.addToFront("5");
        list.addToFront("6");

        //list.addToFront("Priyal");
        //list.addToBack("Sangita");
        list.testPrint();
        System.out.println(list.size());
        //System.out.println(list.removeFromFront());
        //list.testPrint();
        //System.out.println(list.size());
        System.out.println(list.removeFromBack());
        list.testPrint();
        //System.out.println(list.size());
        //list.addToFront("Test");
        //list.testPrint();
        System.out.println(list.size());
        System.out.println(list.getTail().getData());


    }
}