package Algorithms;

import DataStructures.SortableList;

public class MergeSort {
    public static void sort(SortableList list){
        if(list.size() > 1){
            SortableList a = list.createNew();
            SortableList b = list.createNew();
            divideList(list, a, b);
            sort(a);
            sort(b);
            combineLists(list, a, b);
        }
    }

    static void combineLists(SortableList list, SortableList a, SortableList b) {
        int i = 0;
        while (a.size() > 0 && b.size() > 0) {
            if (a.first() < b.first() ) {
                mergeNext(list, i, a);
            } else {
                mergeNext(list, i, b);
            }
            i++;
        }

        while(b.size() > 0){
            mergeNext(list, i, b);
            i++;
        }
        while(a.size() > 0){
            mergeNext(list, i, a);
            i++;
        }
    }

    static void divideList(SortableList list, SortableList a, SortableList b) {
        for (int i = 0; i < list.size() / 2; i++) {
            a.add(list.get(i));
        }
        for(int i = list.size() / 2; i < list.size(); i++){
            b.add(list.get(i));
        }
    }

    static void mergeNext(SortableList list, int i, SortableList sub) {
        list.set(i, sub.first());
        sub.remove(0);
    }


}
