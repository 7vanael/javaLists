import Algorithms.BubbleSort;
import Algorithms.MergeSort;
import Algorithms.QuickSort;
import DataStructures.ArrayList;
import DataStructures.LinkedList;

import java.util.Random;

public class PerformanceTester {

    private static final int SIZE_OF_SORTED_DATA_SET = 10000;
    private static final int SIZE_OF_ADDED_DATA_SET = 1000;

    private static Random random = new Random();
    private static int[] tenThousand = new int[SIZE_OF_SORTED_DATA_SET];

    private static long startTime;
    private static long endTime;
    private static long duration;

    public static void runPerformanceTest(){
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

    private static void bubbleSortPerformance() {
        ArrayList array= new ArrayList();
        LinkedList linked= new LinkedList();

        populateTenThousandRandom(tenThousand, random);

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        BubbleSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("BubbleSorting ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        BubbleSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("BubbleSorting LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");

    }

    private static void mergeSortPerformance() {
        ArrayList array= new ArrayList();
        LinkedList linked= new LinkedList();

        populateTenThousandRandom(tenThousand, random);

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        MergeSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("MergeSorting ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        MergeSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("MergeSorting LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    private static void quickSortPerformance() {
        ArrayList array= new ArrayList();
        LinkedList linked= new LinkedList();

        populateTenThousandRandom(tenThousand, random);

        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            array.add(tenThousand[i]);
            linked.add(tenThousand[i]);
        }

        startTime = System.nanoTime();
        QuickSort.sort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("QuickSorting ArrayList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");

        startTime = System.nanoTime();
        QuickSort.sort(linked);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("QuickSorting LinkedList:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    private static void populateTenThousandRandom(int[] tenThousand, Random random) {
        for (int i = 0; i < SIZE_OF_SORTED_DATA_SET; i++) {
            tenThousand[i] = random.nextInt();
        }
    }

    public static void addToFrontArrayList() {
        ArrayList array = new ArrayList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) array.add(i, 0);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public static void addToEndArrayList() {
        ArrayList array = new ArrayList();
        startTime = System.nanoTime();

        for (int i = 0; i < SIZE_OF_ADDED_DATA_SET; i++) array.add(i);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public static void addToMiddleArrayList() {
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

    public static void addToFrontLinkedList() {
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

    public static void addToEndLinkedList() {
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

    public static void addToMiddleLinkedList() {
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
