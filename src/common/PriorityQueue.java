package common;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {

    List<Integer> array;
    Heap heap;
    PriorityQueue(List<Integer> input) {
        this.array = input;
        heap = new Heap(array);
        heap.build_max_heap();
        heap.printArr();
    }

    /**
     * O(1)
     * @return
     */
    public int get_max() {
        return array.get(0);
    }

    /**
     * O(log n)
     * @return
     */
    public int extract_max() {
        int temp = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.set(array.size() - 1, temp);

        int a = array.remove(array.size() - 1);

        heap.max_heapify(0, array.size() );
        heap.printArr();

        return a;
    }

    /**
     * O(log n)
     * @param key
     */
    public void insert(int key) {
        array.add(Integer.MIN_VALUE);
        increase_key(array.size() - 1, key);

    }

    /**
     * O(log n)
     * @param position
     * @param final_key
     */
    public void increase_key(int position, int final_key) {
        if (position < 0) return;
        else {
            if (final_key < array.get(position)) {
                System.out.println("The new key is smaller than existing one. Abort!");
                return;
            }
            array.set(position, final_key);
            int parent = getParent(position);
            while(parent >= 0 && array.get(position) > array.get(parent)) {
                int temp = array.get(parent);
                array.set(parent, array.get(position));
                array.set(position, temp);

                position = parent;
                parent = getParent(position);

            }

        }
    }

    private int getParent(int position) {
        return (position - 1) / 2;
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

        PriorityQueue pq = new PriorityQueue(array);

        System.out.println("Max value from priority queue " + pq.get_max());

        System.out.println("Extracted the max value " + pq.extract_max());

        System.out.println("Inserting new key 1");
        pq.insert(1);
        System.out.println("Inserting new key 12");
        pq.insert(12);

        pq.heap.heapsort();
    }
}
