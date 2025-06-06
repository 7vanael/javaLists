package Algorithms;

import DataStructures.ArrayList;
import DataStructures.LinkedList;
import DataStructures.SortableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    ArrayList array;
    LinkedList linked;
    int[] set;

    @BeforeEach
    void setUp() {
        array = new ArrayList();
        linked = new LinkedList();
    }

    @Test
    public void acceptsLinkedListAndArrayList() {
        populateLists(new int[]{1, 3, 5});
        assertDoesNotThrow(() -> MergeSort.sort(array));
        assertDoesNotThrow(() -> MergeSort.sort(linked));
    }

    @Test
    public void doesNotAlterListsWhereSizeLessThanTwo() {
        populateLists(new int[]{1});
        MergeSort.sort(array);
        MergeSort.sort(linked);
        assertArrayEquals(new int[]{1}, toArray(array));
        assertArrayEquals(new int[]{1}, toArray(linked));
    }

    @Test
    public void keepsSortedListIfGivenSortedList() {
        set = new int[]{1, 2, 3};
        populateLists(set);

        MergeSort.sort(array);
        MergeSort.sort(linked);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(array));
        assertArrayEquals(new int[]{1, 2, 3}, toArray(linked));
    }

    @Test
    public void sorts21to12() {
        set = new int[]{2, 1};
        populateLists(set);

        MergeSort.sort(array);
        MergeSort.sort(linked);

        assertArrayEquals(new int[]{1, 2}, toArray(array));
        assertArrayEquals(new int[]{1, 2}, toArray(linked));
    }

    @Test
    public void sortsNegative12to12() {
        set = new int[]{-1, -2};
        populateLists(set);

        MergeSort.sort(array);
        MergeSort.sort(linked);

        assertArrayEquals(new int[]{-2, -1}, toArray(array));
        assertArrayEquals(new int[]{-2, -1}, toArray(linked));
    }

    @Test
    public void divideListMakesListOfFirstHalfAndSecondHalf() {
        set = new int[]{9, 4, 7, 2};
        populateLists(set);
        ArrayList arrayA = new ArrayList();
        ArrayList arrayB = new ArrayList();
        LinkedList linkedA = new LinkedList();
        LinkedList linkedB = new LinkedList();

        MergeSort.divideList(array, arrayA, arrayB);
        MergeSort.divideList(linked, linkedA, linkedB);

        assertEquals(arrayA.get(0), linkedA.get(0));
        assertEquals(arrayB.get(0), linkedB.get(0));
        assertEquals(2, arrayA.size());
        assertEquals(2, arrayB.size());
        assertEquals(2, linkedA.size());
        assertEquals(2, linkedB.size());
    }

    @Test
    public void divideListWorksOnOddSizes() {
        set = new int[]{9, 4, 7};
        int[] expectA = new int[]{9};
        int[] expectB = new int[]{4, 7};
        populateLists(set);
        ArrayList arrayA = new ArrayList();
        ArrayList arrayB = new ArrayList();
        LinkedList linkedA = new LinkedList();
        LinkedList linkedB = new LinkedList();

        MergeSort.divideList(array, arrayA, arrayB);
        MergeSort.divideList(linked, linkedA, linkedB);

        assertArrayEquals(expectA, toArray(arrayA));
        assertArrayEquals(expectA, toArray(linkedA));
        assertArrayEquals(expectB, toArray(arrayB));
        assertArrayEquals(expectB, toArray(linkedB));
    }

    @Test
    public void mergeNextSetsListAtItoFirstInSubList() {
        set = new int[]{9, 4, 7, 3};
        populateLists(set);

        ArrayList arrayA = new ArrayList();
        LinkedList linkedA = new LinkedList();
        arrayA.add(3);
        arrayA.add(7);
        linkedA.add(3);
        linkedA.add(7);

        MergeSort.mergeNext(array, 0, arrayA, 0);
        MergeSort.mergeNext(linked, 0, linkedA, 0);

        assertEquals(3, array.get(0));
        assertEquals(3, linked.get(0));
    }

    @Test
    public void combineListsResultsInSortedList() {
        set = new int[]{9, 4, 7, 3};
        populateLists(set);
        int[] expected = new int[]{3, 4, 7, 9};
        ArrayList arrayA = new ArrayList();
        ArrayList arrayB = new ArrayList();
        LinkedList linkedA = new LinkedList();
        LinkedList linkedB = new LinkedList();

        arrayA.add(4);
        arrayA.add(9);
        linkedA.add(4);
        linkedA.add(9);
        arrayB.add(3);
        arrayB.add(7);
        linkedB.add(3);
        linkedB.add(7);
        MergeSort.combineLists(array, arrayA, arrayB);
        MergeSort.combineLists(linked, linkedA, linkedB);

        assertArrayEquals(expected, toArray(array));
        assertArrayEquals(expected, toArray(linked));
    }

    @Test
    public void mergeSortSortsList() {
        set = new int[]{9, 4, 7, 3, 6, 11, -4};
        populateLists(set);
        int[] expected = new int[]{-4, 3, 4, 6, 7, 9, 11};
        MergeSort.sort(array);
        MergeSort.sort(linked);

        assertArrayEquals(expected, toArray(array));
        assertArrayEquals(expected, toArray(linked));
    }

    private void populateLists(int[] set) {
        for (int i = 0; i < set.length; i++) {
            array.add(set[i]);
            linked.add(set[i]);
        }
    }

    private int[] toArray(SortableList list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
