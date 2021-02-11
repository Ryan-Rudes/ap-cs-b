/*
1. What is a priority queue?
    A priority queue is a data structure in which a set of tasks
    are arranged in a queue-fashion according to the priority of
    each element. Those with a higher priority are served before
    those with lower priority. Higher priority is indicated by
    a lower value, and vice versa.
2. What is wrong with implementing a priority queue as a sorted list?
    You would have to apply insertion sort every time a new item is
    appended; this operates at an average of O(n^2) comparisons to re-sort
    the array each time a new item is added. This is substancially slower
    than the alternative implementations.
3. What is a complete binary tree?
    A complete binary tree is a binary tree in which all parent nodes are complete, ie.
    all non-leaf nodes have two children.
4. If a complete binary tree is stored in an array with the first node in items[1],
where can we find the parent of the 5-th node? Its left and right children?
    The parent of the 5th node would be items[2]
    The left and right children of the 5th node would be items[10] and items[11]
5. What is a heap?
    A heap is a data structure that resembles a binary search tree, however,
    the heap is a complete tree, meaning its shape does not vary other than
    its depth. Also, the heap organizes its elements differently. In
    a binary search tree, the smaller elements are placed on the left, while
    the larger items are on the right. There are two types of heaps, ie. max heap
    and min heap. In a min heap, the parent nodes hold a smaller value than their
    children. In a max heap, the parent nodes hold a larger value than their
    children.
6. Describe the main steps in the algorithm for removing the smallest value from a heap.
    To remove the smallest value of a min-heap (the root node), you perform the following:
    a. remove the minimum value at the root
    b. move the last element to the empty root position
    c. repeat until the demoted child has no smaller children
        - promote the smaller child of the parent node to its parents position
7. Describe the main steps in the algorithm for adding a value to a heap
    1. add an empty position to the end of the tree
    2. swap the values of the empty spot and its parent if the parent value
    is larger than the value being inserted.
    3. repeat this until the parent value being considered is smaller than
    the value being inserted
    4. insert the value into the empty spot
8. Could a priority queue be implemented efficiently as a binary search tree?
Give a detailed argument for your answer.
    Yes, a binary search tree can efficiently maintain a sorted collection.
    Finding the minimum value in a binary search tree runs in a worse-case
    time complexity of O(h), where h is the height/depth. Searching for the min
    value in a BST only requires moving left as far as possible, and only
    searching right when there is no left child. Therefore, a priority
    queue can be efficiently implemented as a BST.
9. Will preorder, inorder, or postorder traversal print a heap in sorted order?
    No, neither of these will print the heap in sorted order.
10. Write the MaxHeap class
*/

import java.util.Math;

public class MaxHeap {
    private int size = 0;
    private int maxSize;
    private int[] heap;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
    }

    public int parent(int pos) { return (pos - 1) / 2; }
    public int leftChild(int pos) { return 2 * pos + 1; }
    public int rightChild(int pos) { return 2 * (pos + 1); }
    public boolean isLeaf(int pos) { return pos >= (int)(size / 2) && pos < size; }

    public void swap(int a, int b) {
        int temp = heap[b];
        heap[b] = heap[a];
        heap[a] = temp;
    }

    public void add(int value) {
        heap[size] = value;
        int pos = size;
        int parentPos;
        while (true) {
            parentPos = parent(pos);
            if (heap[pos] <= heap[parentPos]) { break; }
            swap(pos, parentPos);
            pos = parentPos;
        }
        size ++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.printf("INDEX %d: %d%n", i, heap[i]);
        }
    }

    public int removeRoot() {
        int rootValue = heap[0];
        size --;
        swap(0, size);
        int pos = 0;
        int leftChildPos;
        while (true) {
            if (isLeaf(pos)) { break; }
            leftChildPos = leftChild(pos);
            if (heap[leftChildPos] > heap[leftChildPos + 1]) {
                swap(pos, leftChildPos);
                pos = leftChildPos;
            } else {
                swap(pos, leftChildPos + 1);
                pos = leftChildPos + 1;
            }
        }
        return rootValue;
    }
}