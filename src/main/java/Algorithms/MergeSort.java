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
        int ai = 0;
        int bi = 0;
        while (a.size() > ai && b.size() > bi) {
            if (a.get(ai) < b.get(bi) ) {
                mergeNext(list, i, a, ai);
                ai++;
            } else {
                mergeNext(list, i, b, bi);
                bi++;
            }
            i++;
        }

        while(b.size() > bi){
            mergeNext(list, i, b, bi);
            bi++;
            i++;
        }
        while(a.size() > ai){
            mergeNext(list, i, a, ai);
            ai++;
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

    static void mergeNext(SortableList list, int i, SortableList sub, int subi) {
        list.set(i, sub.get(subi));
    }


}
