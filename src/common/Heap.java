package common;

import java.util.LinkedList;
import java.util.List;

public class Heap {

    public List<Integer> array;
    Heap(List<Integer> input) {
        this.array = input;
    }

    // O(log n)
    public void max_heapify(int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest;
        if (left < length && i < length && array.get(left) > array.get(i))
            largest = left;
        else largest = i;
        if (right < length && i < length && array.get(right) > array.get(largest))
            largest = right;
        if (largest != i) {
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);
            max_heapify(largest, length);
        }
    }


    /**
     * O(n)
     * Number of nodes of height h ≤ ڿn/2h+1ە
     * – The time required by maxHeapify on a node of
     * height h is O(h),– So the total cost of is:
     * Sumation of  n/2h+1 where 0<=h<log n
     * hence by mathematical formulation its O(n)
     *
     */

    public void build_max_heap() {
        for (int i = array.size()/2; i >= 0; i--)
            max_heapify( i, array.size());
    }


    /**
     *
     * O(n log n)
     * @param
     */

    public void heapsort() {
        build_max_heap();

        printArr();

        for (int i = array.size() - 1; i>=0; i--) {
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            max_heapify(0, i );


        }
    }


    public static void main(String[] args) {

        List<Integer> array = new LinkedList<>();
        array.add(8);
        array.add(11);
        array.add(23);
        array.add(9);
        array.add(4);
        array.add(2);
        array.add(20);

        Heap hs = new Heap(array);

        System.out.println("Originial array");
        hs.printArr();

        System.out.println("After first maxHeapify");
        hs.heapsort();

        System.out.println("Sorted array");
        hs.printArr();
    }

    public void printArr() {
        for (int i = 0; i< array.size(); i++)
            System.out.print(array.get(i) + " ");
        System.out.println();
    }
}
