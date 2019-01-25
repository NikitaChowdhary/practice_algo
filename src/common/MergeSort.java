package common;

public class MergeSort {
    // Time complexity O(nlog n)
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i< array.length; i++)
            System.out.print(array[i] + " ");
    }



    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i< leftSize; i++)
            left[i] = array[start + i];

        for (int j = 0; j< rightSize; j++)
            right[j] = array[middle + j + 1];


        int i = 0, j =0;
        int k = start;
        while(i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
