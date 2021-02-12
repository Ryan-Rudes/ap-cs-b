import java.util.Math;

public class MaxHeap {
    private int size = 0;
    private HeapSort sorter = new HeapSort();

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

    public void sort() {
        sorter.sort(heap);
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

    public String toString() {
        StringBuilder printout = new StringBuilder();

        for (int value: heap) {
            printout.append(value);
            printout.append(" ");
        }

        return printout.toString();
    }
}