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