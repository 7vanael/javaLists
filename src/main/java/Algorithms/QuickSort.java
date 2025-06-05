package Algorithms;

import DataStructures.SortableList;

public class QuickSort {
    public static void sort(SortableList list) {
        if (list.size() > 1) {
            sort(list, 0, list.size() - 1);
        }
    }

    private static void sort(SortableList list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sort(list, low, pivotIndex - 1);
            sort(list, pivotIndex + 1, high);
        }
    }

    static int partition(SortableList list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                list.swap(i, j);
            }
        }
        list.swap(i + 1, high);
        return i + 1;
    }
}
