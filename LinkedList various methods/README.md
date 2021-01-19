# Lab

> 1. Write a swap method to swap the first and last values of a Linked List.
> 2. Write a method that converts all the ints in an array into a linked list and returns the head of the new list.
> 3. Write a method maxLength(LinkedList words) that assume that words contain String objects and returns the longest word from the list.
> 4. Write two functions recursively that prints the forward and backward.
> 
> ```java
> public void printForward(LinkedList ListofNames)
> public void printBackward(LinkedList ListofNames)
> ```

# Code
```java
public class LinkedList {
    ListNode head;
    int size;

    // Node object
    public class ListNode {
        // Instances
        private ListNode prev = null;
        private ListNode next = null;
        private Object value;
    
        // ListNode Constructor
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

    // LinkedList empty constructor
    public LinkedList() {
        this.head = null;
    }

    // LinkedList constructor with object array input
    public LinkedList(Object[] objects) {
        this.head = new ListNode(null, null, objects[0]);
        ListNode tempNode = head;
        ListNode nextNode;
        for (int i = 1; i < objects.length; i++) {
            nextNode = new ListNode(tempNode, null, objects[i]);
            tempNode.setNext(nextNode);
            tempNode = nextNode;
        }
    }

    /**
     * Pushes an object to the front of the stack
     * @param value  the object to add to the front of the list
     */
    public void addToFront(Object value) {
        ListNode newNode = new ListNode(null, head, value);

        if (head != null) {
            head.setPrev(newNode);
        }

        head = newNode;
        size ++;
    }

    /**
     * Adds an object to the end of the stack
     * @param value  the object to add to the end of the list
     */
    public void addToEnd(Object value) {
        ListNode tempNode = head;

        if (head == null) {
            head = new ListNode(null, null, value);
        } else {
            while (tempNode.getNext() != null) {
                tempNode = tempNode.getNext();
            }

            ListNode newNode = new ListNode(tempNode, null, value);
            tempNode.setNext(newNode);
        }

        size ++;
    }

    /**
     * Adds a node to the middle of the list at a specified index
     * @param value  the object to add to the list
     * @param index  the index at which to insert the object
     */
    public void addNodeToMiddle(Object value, int index) {
        ListNode tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        ListNode newNode = new ListNode(tempNode.getPrev(), tempNode, value);
        tempNode.getPrev().setNext(newNode);
        tempNode.setPrev(newNode);
        size ++;
    }

    /**
     * Removes the first node of the list
     */
    public void removeFirst() {
        head.getNext().setPrev(null);
        head = head.getNext();
        size --;
    }

    /**
     * Removes the last node of the list
     */
    public void removeLast() {
        ListNode tempNode = head;

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        tempNode.getPrev().setNext(null);
        tempNode = null;
        size --;
    }

    /**
     * Removes a node from the specified index
     * @param index  the index at which to remove
     */
    public void removeFromMiddle(int index) {
        ListNode tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }

        tempNode.getPrev().setNext(tempNode.getNext());
        tempNode.getNext().setPrev(tempNode.getPrev());
        tempNode = null;
        size --;
    }

    /**
     * Print forwards (non-recursive operation)
     */
    public void printFowards() {
        ListNode tempNode = head;
        System.out.print("[");

        while (tempNode.getNext() != null) {
            System.out.printf("%s, ", tempNode.getValue());
            tempNode = tempNode.getNext();
        }

        System.out.printf("%s]%n", tempNode.getValue());
    }

    /**
     * Print backwards (non-recursive operation)
     */
    public void printBackwards() {
        ListNode tempNode = head;

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        System.out.print("[");

        while (tempNode.getPrev() != null) {
            System.out.printf("%s, ", tempNode.getValue());
            tempNode = tempNode.getPrev();
        }

        System.out.printf("%s]%n", tempNode.getValue());
    }

    /**
     * The recursive forwards printing operation
     */
    private void printForwardsRecursion(ListNode node) {
        if (node == null) {
            System.out.print("[");
            printForwardsRecursion(head);
        } else {
            if (node.getNext() == null) {
                System.out.printf("%s]%n", node.getValue());
            } else {
                System.out.printf("%s, ", node.getValue());
                printForwardsRecursion(node.getNext());
            }
        }
    }

    /**
     * The recursive backwards printing operation
     */
    private void printBackwardsRecursion(ListNode node) {
        if (node == null) {
            System.out.print("[");

            ListNode tempNode = head;

            while (tempNode.getNext() != null) {
                tempNode = tempNode.getNext();
            }

            printBackwardsRecursion(tempNode);
        } else {
            if (node.getPrev() == null) {
                System.out.printf("%s]%n", node.getValue());
            } else {
                System.out.printf("%s, ", node.getValue());
                printBackwardsRecursion(node.getPrev());
            }
        }
    }

    // Public methods which make use of the recursive functions less verbose (no arguments)
    public void printForwardsRecursively() { printForwardsRecursion(null); }
    public void printBackwardsRecursively() { printBackwardsRecursion(null); }

    /**
     * Checks whether the list has any nodes
     */
    public boolean isEmpty() {
        // Could also be implemented as: return size == 0;
        return head == null;
    }

    /**
     * Prints the number of nodes in the list
     */
    public void numOfNodes() {
        // The faster implementation is: return size;
        // (I kept track of the list size in an instance variable)
        if (isEmpty()) {
            System.out.println(0);
        } else {
            int num = 1;
            ListNode tempNode = head;

            while (tempNode.getNext() != null) {
                tempNode = tempNode.getNext();
                num++;
            }

            System.out.println(num);
        }
    }

    /**
     * Swaps the first and last values of the list
     */
    public void swapFirstLast() {
        ListNode tempNode = head;

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        Object tempValue = tempNode.getValue();
        tempNode.setValue(head.getValue());
        head.setValue(tempValue);
    }

    /**
     * Assuming the list contains only String objects, returns the longest word from the list
     * If there are two words with the same maximum length, returns the one which appears first
     */
    public String maxLength() {
        ListNode tempNode = head;
        String longestWord = String.valueOf(tempNode.getValue());

        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            if (String.valueOf(tempNode.getValue()).length() > longestWord.length()) {
                longestWord = String.valueOf(tempNode.getValue());
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Object[] values = {"bye", "hello", "hi"};
        LinkedList list = new LinkedList(values);
        System.out.println(list.maxLength()); // hello
        list.removeFromMiddle(1);
        list.printForwardsRecursively(); // [bye, hi]
        for (int i = 0; i < 10; i++) {
            list.addToFront(i);
        }
        list.printFowards(); // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, bye, hi]
        list.addToEnd("THE END");
        list.printFowards(); // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0, bye, hi, THE END]
        list.printBackwardsRecursively(); // [THE END, hi, bye, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
```
