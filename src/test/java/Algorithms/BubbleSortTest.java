package Algorithms;

import DataStructures.ArrayList;
import DataStructures.LinkedList;
import DataStructures.SortableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    ArrayList array;
    LinkedList linked;
    int[] set;

    @BeforeEach
    void setUp() {
        array = new ArrayList();
        linked = new LinkedList();
    }

    @Test
    public void acceptsBothLinkedAndArrayList(){
        assertDoesNotThrow(() -> BubbleSort.sort(array));
        assertDoesNotThrow(() -> BubbleSort.sort(linked));
    }

    @Test
    public void doesNotAlterSorted(){
        set = new int[]{1, 2};
        populateLists(set);
        BubbleSort.sort(array);
        BubbleSort.sort(linked);
        assertArrayEquals(set, toArray(array));
        assertArrayEquals(set, toArray(linked));
    }

    @Test
    public void returns12Given21(){
        set = new int[]{2, 1};
        populateLists(set);
        int[] expected = new int[]{1, 2};
        BubbleSort.sort(array);
        BubbleSort.sort(linked);
        assertArrayEquals(expected, toArray(array));
        assertArrayEquals(expected, toArray(linked));
    }

    @Test
    public void sortsAList(){
        set = new int[]{2, 1, 11, -3, 9};
        populateLists(set);
        int[] expected = new int[]{-3, 1, 2, 9, 11};
        BubbleSort.sort(array);
        BubbleSort.sort(linked);
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
