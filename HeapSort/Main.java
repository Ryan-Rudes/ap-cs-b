import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        Random rand = new Random();

        MaxHeap heap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            heap.add(rand.nextInt(100));
        }

        System.out.println("Unsorted:");
        System.out.println(heap);
        heap.sort();
        System.out.println("Sorted:");
        System.out.println(heap);

        /** Sample Output below
        Unsorted:
        92 79 56 78 41 16 55 4 14 29 
        Sorted:
        4 14 16 29 41 55 56 78 79 92 
        */
    }
}