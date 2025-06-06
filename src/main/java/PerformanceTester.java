import Algorithms.BubbleSort;
import Algorithms.MergeSort;
import Algorithms.QuickSort;
import DataStructures.ArrayList;
import DataStructures.LinkedList;

import java.util.Random;

public class PerformanceTester {

    private final int SIZE_OF_SORTED_DATA_SET = 10000;
    private final int SIZE_OF_ADDED_DATA_SET = 1000;

    private Random random = new Random();
    private int[] tenThousand = new int[SIZE_OF_SORTED_DATA_SET];

    private long startTime;
    private long endTime;
    private long duration;

    public void runPerformanceTest(){
        System.out.println("ArrayList Performance Testing");
        System.out.println("=============================\n");

        addToFrontArrayList();
        addToEndArrayList();
        addToMiddleArrayList();

        System.out.println("LinkedList Performance Testing");
        System.out.println("=============================\n");

        addToFrontLinkedList();
        addToEndLinkedList();
        addToMiddleLinkedList();


        System.out.println("QuickSort Performance Testing");
        System.out.println("=============================\n");
        quickSortPerformance();

        System.out.println("MergeSort Performance Testing");
        System.out.println("=============================\n");
        mergeSortPerformance();

        System.out.println("BubbleSort Performance Testing");
        System.out.println("=============================\n");
        bubbleSortPerformance();
    }

    private void bubbleSortPerformance() {
        ArrayList array;
        LinkedList linked;

        populateTenThousandRandom(tenThousand, random);

        array = new ArrayList();
        linked = new LinkedList();

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        BubbleSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("BubbleSorting DataStructures.ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        BubbleSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("BubbleSorting DataStructures.LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");

    }

    private void mergeSortPerformance() {
        ArrayList array;
        LinkedList linked;

        populateTenThousandRandom(tenThousand, random);

        array = new ArrayList();
        linked = new LinkedList();

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        MergeSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("MergeSorting DataStructures.ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        MergeSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("MergeSorting DataStructures.LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    private void quickSortPerformance() {
        ArrayList array;
        LinkedList linked;

        populateTenThousandRandom(tenThousand, random);

        array = new ArrayList();
        linked = new LinkedList();

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        QuickSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("QuickSorting DataStructures.ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        QuickSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("QuickSorting DataStructures.LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    private void populateTenThousandRandom(int[] tenThousand, Random random) {
        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            tenThousand[i] = random.nextInt();
        }
    }

    public void addToFrontArrayList() {
        ArrayList array = new ArrayList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) array.add(i, 0);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public void addToEndArrayList() {
        ArrayList array = new ArrayList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) array.add(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public void addToMiddleArrayList() {
        ArrayList array = new ArrayList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) {
            int middleIndex = array.size() / 2;
            array.add(i, middleIndex);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to Middle:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public void addToFrontLinkedList() {
        LinkedList linked = new LinkedList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) {
            linked.add(i, 0);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    public void addToEndLinkedList() {
        LinkedList linked = new LinkedList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) {
            linked.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    public void addToMiddleLinkedList() {
        LinkedList linked = new LinkedList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) {
            int middleIndex = linked.size() / 2;
            linked.add(i, middleIndex);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to Middle:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }
}
