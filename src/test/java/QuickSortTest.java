import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    ArrayList array;
    LinkedList linked;
    int[] set;

    @BeforeEach
    void setUp(){
        array = new ArrayList();
        linked = new LinkedList();
    }

    @Test
    public void acceptsLinkedListAndArrayList(){
        populateLists(new int[] {1, 3, 5});
        assertDoesNotThrow(() -> QuickSort.quickSort(array));
        assertDoesNotThrow(() -> QuickSort.quickSort(linked));
    }

    @Test
    public void doesNotAlterListsWhereSizeLessThanTwo(){
        populateLists(new int[] {1});
        assertArrayEquals(new int[]{1}, toArray(array));
        assertArrayEquals(new int[]{1}, toArray(linked));
    }

    @Test
    public void keepsSortedListIfGivenSortedList() {
        set = new int[]{1, 2, 3};
        populateLists(set);

        QuickSort.quickSort(array);
        QuickSort.quickSort(linked);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(array));
        assertArrayEquals(new int[]{1, 2, 3}, toArray(linked));
    }

    @Test
    public void sorts21to12(){
        set = new int[]{2, 1};
        populateLists(set);

        QuickSort.quickSort(array);
        QuickSort.quickSort(linked);

        assertArrayEquals(new int[]{1, 2}, toArray(array));
        assertArrayEquals(new int[]{1, 2}, toArray(linked));
    }

    @Test
    public void sortsNegative12to12(){
        set = new int[]{-1, -2};
        populateLists(set);

        QuickSort.quickSort(array);
        QuickSort.quickSort(linked);

        assertArrayEquals(new int[]{-2, -1}, toArray(array));
        assertArrayEquals(new int[]{-2, -1}, toArray(linked));
    }

    @Test
    public void partitionFindsTheFinalIndexOfLastValue(){
        set = new int[]{4, 6, 8, 2 , 1, 9, 3};
        populateLists(set);

        assertEquals(2, QuickSort.partition(array, 0, array.size()-1));
        assertEquals(2, QuickSort.partition(linked, 0, linked.size()-1));
    }

    @Test
    public void afterPartitioningOnceLastValueIsInFinalLocation(){
        set = new int[]{4, 6, 8, 2 , 1, 9, 3};
        populateLists(set);
        QuickSort.partition(array, 0, array.size()-1);
        QuickSort.partition(linked, 0, linked.size()-1);

        assertEquals(3, array.get(2));
        assertEquals(3, linked.get(2));
    }

    @Test
    public void partitionRoughSortsAroundLastValue(){
        set = new int[]{4, 6, 8, 2 , 1, 9, 3};
        int[] expected = new int[] {2, 1, 3, 4, 6, 9, 8};
        populateLists(set);

        QuickSort.partition(array, 0,array.size() - 1);
        QuickSort.partition(linked, 0,linked.size() - 1);

        assertArrayEquals(expected, toArray(array));
        assertArrayEquals(expected, toArray(linked));
    }

    @Test
    public void partitionWorksOnSubsectionOfList(){
        set = new int[]{2, 1, 3, 4, 6, 9, 8};
        int[] expected = new int[]{1, 2, 3, 4, 6, 9, 8};
        populateLists(set);

        QuickSort.partition(array, 0, 1);
        QuickSort.partition(linked, 0, 1);

        assertArrayEquals(expected, toArray(array));
        assertArrayEquals(expected, toArray(linked));
    }

    @Test
    public void partitionWorksOnSecondSection(){
        set = new int[]{1, 2, 3, 4, 6, 9, 8};
        populateLists(set);

        QuickSort.partition(array, 3, array.size() - 1);
        QuickSort.partition(linked, 3, linked.size() - 1);

        assertArrayEquals(new int[]{1, 2, 3, 4, 6, 8, 9}, toArray(array));
        assertArrayEquals(new int[]{1, 2, 3, 4, 6, 8, 9}, toArray(linked));
    }

    private void populateLists(int[] set) {
        for (int i = 0; i < set.length; i++) {
            array.add(set[i]);
            linked.add(set[i]);
        }
    }

    private int[] toArray(SortableList list){
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }        return  result;
    }
}
