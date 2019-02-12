package com.kukhtin;

public class MergeSort {
    public static void merge(int array[], int start, int mid, int end) {
        int start2 = mid + 1;
        if (array[mid] <= array[start2]) {
            return;
        }
        while (start <= mid && start2 <= end) {
            if (array[start] <= array[start2]) {
                start++;
            } else {
                int value = array[start2];
                int index = start2;

                while (index != start) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[start] = value;

                start++;
                mid++;
                start2++;
            }
        }
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;

            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);

            merge(arr, left, m, right);
        }
    }

    public static void printArray(int array[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 14, 15, 8, 9, 23, 45, 10, 5, 6, 99, 41};
        int arr_size = array.length;

        mergeSort(array, 0, arr_size - 1);
        printArray(array, arr_size);
    }
}
