package Algorithms;
import DataStructures.SortableList;

public class BubbleSort {
    public static void sort(SortableList list) {
        if(list.size() < 2) return;

        int stop = list.size() - 1;
        boolean swapped = false;
        while (stop >= 1){
            int i = 0;
            while (i < stop) {
                if(list.swapIfGreaterThanNext(i)){
                    swapped = true;
                }
                i++;
            }
            if(!swapped) break;
            stop--;
        }
    }
}
