# Lab
<img src="https://i.ibb.co/5L7n7ZW/Linked-List-Lab-page0001.jpg" alt="Linked-List-Lab-page0001" border="0">

# Code
**LinkedList.java**
```java
public class LinkedList {
    // Node object
    public class ListNode {
        // Instances
        private ListNode prev = null;
        private ListNode next = null;
        private Object value;
    
        // Constructor
        public ListNode(ListNode prev, ListNode next, Object value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    
        // Getters
        public Object getValue() { return value; }
        public ListNode getNext() { return next; }
        public ListNode getPrev() { return prev; }
    
        // Setters
        public void setValue(Object value) { this.value = value; }
        public void setNext(ListNode next) { this.next = next; }
        public void setPrev(ListNode prev) { this.prev = prev; }
    }

    // Head and tail nodes
    ListNode head = null;
    ListNode tail = null;

    // Node count
    int numNodes = 0;

    // LinkedList constructor for Array datatype
    public LinkedList(Object[] data) {
        for (Object value: data) {
            addToEnd(value);
        }
    }

    /**
     * Adds a node to the front of the list
     * @param value  the value to add to the end of the list
     */
    public void addToFront(Object value) {
        // Creates a temporary node which will become the head
        ListNode tempNode = new ListNode(null, head, value);
        head = tempNode;
        if (tail == null) {
            tail = tempNode;
        }
        numNodes += 1;
    }

    /**
     * Adds a node to the end of the list
     * @param value  the value to add to the end of the list
     */
    public void addToEnd(Object value) {
        // Creates a temporary node which will become the tail
        ListNode tempNode = new ListNode(tail, null, value);;
        if (head == null) {
            head = tail = tempNode;
        } else {
            tail.setNext(tempNode);
            tail = tempNode;
        }
        numNodes += 1;
    }

    /**
     * Adds a node at a particular index of the list. Inserts directly at the index, not before nor after.
     * @param value  the value of the node to be inserted
     * @param index  the index at which the node is to be inserted
     *  
     * For a LinkedList represented by {x0, x1, ..., xn}, if index >= n or index <= 0, raises a NullPointerException
     */
    public void addNodeToMiddle(Object value, int index) {
        if (index == 0 || index == numNodes - 1) {
            throw new ArrayIndexOutOfBoundsException("Cannot insert node at neither the head nor the tail. Use either LinkedList.addToFront() or LinkedList.addToEnd()");
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Cannot insert node at a negative index");
        } else if (index > numNodes - 1) {
            throw new ArrayIndexOutOfBoundsException("Cannot insert node at a position beyond the extent of the list");
        } else {
            ListNode tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            ListNode newNode = new ListNode(tempNode.getPrev(), tempNode, value);
            tempNode.getPrev().setNext(newNode);
            tempNode.setPrev(newNode);
            numNodes += 1;
        }
    }

    /**
     * Removes the first node of the list
     *  
     * numNodes == 0: Raises a NullPointerException
     * numNodes == 1:
     *   1. Sets the head to null
     *   2. Decrements numNodes to 0
     * numNodes >= 2: 
     *   1. Sets the node preceding the node following the head to null
     *   2. Sets the head to the node following the head
     *   2. Decrements numNodes, leaving numNodes = 0
     */
    public void removeFirst() {
        if (numNodes == 0) {
            throw new NullPointerException("Cannot remove a nonexistent node");
        } else if (numNodes == 1) {
            tail = null;
            head = null;
            numNodes -= 1;
        } else {
            head.getNext().setPrev(null);
            head = head.getNext();
            numNodes -= 1;
        }
    }

    /**
     * Removes the last node of the list
     *  
     * numNodes == 0: Raises a NullPointerException
     * numNodes == 1:
     *   1. Sets the tail to null
     *   2. Decrements numNodes to 0
     * numNodes >= 2:
     *   1. Sets the node following the node preceding the tail to null
     *   2. Sets the tail to the node preceding the tail
     *   3. Decrements numNodes, leaving numNodes = 0
     */
    public void removeLast() {
        if (numNodes == 0) {
            throw new NullPointerException("Cannot remove a nonexistent node");
        } else if (numNodes == 1) {
            tail = null;
            head = null;
            numNodes -= 1;
        } else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            numNodes -= 1;
        }
    }

    /**
     * Removes a node at a particular index of the list and reconstructs the connections approperiately.
     * @param index  the index of the node to be removed
     *  
     * For a LinkedList represented by {x0, x1, ..., xn}, if index >= n or index <= 0, raises a NullPointerException
     */
    public void removeFromMiddle(int index) {
        if (index == 0 || index == numNodes - 1) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove node at neither the head nor the tail. Use either LinkedList.removeFirst() or LinkedList.removeLast()");
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove node at a negative index");
        } else if (index > numNodes - 1) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove node at a position beyond the extent of the list");
        } else {
            ListNode tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.getPrev().setNext(tempNode.getNext());
            tempNode.getNext().setPrev(tempNode.getPrev());
            tempNode = null;
            numNodes -= 1;
        }
    }

    /**
     * Prints the list from the beginning to the end
     *  
     * If the list is empty, prints empty brackets
     * Otherwise, prints each item going forwards, separated by commas, and enclosed by brackets
     */
    public void printFowards() {
        if (head == null) {
            System.out.println("[]");
        } else {
            ListNode pointerNode = head;
            System.out.print("[");
            while (pointerNode.getNext() != null) {
                System.out.printf("%s, ", pointerNode.getValue());
                pointerNode = pointerNode.getNext();
            }
            System.out.printf("%s]%n", pointerNode.getValue());
        }
    }

    /**
     * Prints the list in reverse
     *  
     * If the list is empty, prints empty brackets
     * Otherwise, prints each item going backwards, separated by commas, and enclosed by brackets
     */
    public void printBackwards() {
        if (tail == null) {
            System.out.println("[]");
        } else {
            ListNode pointerNode = tail;
            System.out.print("[");
            while (pointerNode.getPrev() != null) {
                System.out.printf("%s, ", pointerNode.getValue());
                pointerNode = pointerNode.getPrev();
            }
            System.out.printf("%s]%n", pointerNode.getValue());
        }
    }

    /**
     * Tests to see if the list has any nodes
     */
    public Boolean isEmpty() {
        return numNodes == 0;
    }

    /**
     * Prints the number of nodes in the list
     */
    public void numOfNodes() {
        System.out.println(numNodes);
    }
}
```
