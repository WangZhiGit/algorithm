package com.example.algorithm.executable;

public class 排序 {
    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    //选择排序
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    //插入排序
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && temp < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = temp;
        }

        return array;
    }

    //快速排序
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }

        return array;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            if (start < end) {
                arr[start++] = arr[end];
            }

            while (start < end && arr[start] <= pivot) {
                start++;
            }
            if (start < end) {
                arr[end--] = arr[start];
            }
        }

        arr[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        quickSort(array, 0, array.length - 1);
        for (int value: array) {
            System.out.print(value + ",");
        }
    }
}
