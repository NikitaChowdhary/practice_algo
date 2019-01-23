package common;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        quickSort(array, 0, array.length - 1);

        for (int i = 0; i< array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int p = partition(array, start, end);
            quickSort(array, start, p - 1);
            quickSort(array, p + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = end;
        int low = start;

        for (int i = start; i <= end - 1; i++) {
            if (array[i] <= array[pivot]) {
                int temp = array[low];
                array[low] = array[i];
                array[i] = temp;
                low++;
            }
        }
        int temp = array[low];
        array[low] = array[pivot];
        array[pivot] = temp;

        return low;
    }
}
