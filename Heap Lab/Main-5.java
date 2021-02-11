public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        for (int i = 1; i < 5; i++) {
            heap.add(i);
        }
        heap.print();
        heap.removeRoot();
        System.out.println();
        heap.print();

        /* OUTPUT
        INDEX 0: 4
        INDEX 1: 3
        INDEX 2: 2
        INDEX 3: 1

        INDEX 0: 3
        INDEX 1: 1
        INDEX 2: 2
        */
    }
}