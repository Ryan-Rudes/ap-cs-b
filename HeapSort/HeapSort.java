public class HeapSort {
    /**
     * Perform heap sort on array
     * @param arr  array of integers
     */
    public void sort(int[] arr) {
        int n = arr.length;

        // Perform heapify with respect to every non-leaf node.
        // Leaf nodes are a waste because they have no
        // children, so the heapify() method will
        // return with no changes on the first iteration.
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        
        // Invert the tree so that the array is in ascending order,
        // reheaping on each iteration
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    /**
     * Swap two values in the array
     * @param arr  array of integers
     * @param a    index of one element
     * @param b    index of another element
     */
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Create a max heap from an array
     * @param arr  array of integers
     * @param n    length of arr
     * @param i    index of node under consideration
     */
    void heapify(int[] arr, int n, int i) {
        int root = i;
        int childL = i * 2 + 1; // index of left child
        int childR = i * 2 + 2; // index of right child

        /*
        If either child is larger than its parent,
        swap the larger of the two children with their
        parent. Then, heapify with respect to the swapped
        child.

        If neither child is larger than the parent, the
        heapify operation is complete.
        */

        if (childL < n && arr[childL] > arr[root])
            root = childL;

        if (childR < n && arr[childR] > arr[root])
            root = childR;

        if (root != i) {
            swap(arr, i, root);
            heapify(arr, n, root);
        }
    }
}