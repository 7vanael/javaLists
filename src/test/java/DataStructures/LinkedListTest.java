package DataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList newList;

    @BeforeEach
    void setUp() {
        newList = new LinkedList();
    }

    @Test
    @DisplayName("New list is size Zero")
    public void newListHasSizeZero() {
        Assertions.assertEquals(0, newList.size());
    }

    @Test
    @DisplayName("Value added is retrievable with get")
    public void addOneToEmptyListGetsListWithOne() {
        newList.add(1);
        Assertions.assertEquals(1, newList.get(0));
    }

    @Test
    @DisplayName("DataStructures.List size increases when adding more values")
    public void sizeUpdatesWhenListGrows() {
        newList.add(1);
        Assertions.assertEquals(1, newList.size());
    }

    @Test
    @DisplayName("Get out of range throws Index Out Of Bounds Exception")
    public void getOutOfRangeThrowsIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> newList.get(-1));
    }

    @Test
    @DisplayName("Add appends by default")
    public void addingWithoutIndexArgumentAppends() {
        addThree();
        Assertions.assertEquals(1, newList.get(0));
        Assertions.assertEquals(3, newList.get(1));
        Assertions.assertEquals(5, newList.get(2));
    }

    @Test
    @DisplayName("Add with index out of bounds throws Out of Bounds Exception")
    public void addingWithOutOfBoundsIndexThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.add(1, 1));
    }

    @Test
    @DisplayName("Add with index of 0 to empty list just adds to list; no error")
    public void addingWithZeroIndexToEmptyListDoesNotThrow() {
        assertDoesNotThrow(() -> newList.add(1, 0));
    }

    @Test
    @DisplayName("Add with index inserts at the index")
    public void addingWithIndexInsertsAtIndex() {
        addThree();
        newList.add(2, 1);
        Assertions.assertEquals(2, newList.get(1));
        Assertions.assertEquals(3, newList.get(2));
        Assertions.assertEquals(5, newList.get(3));
    }

    @Test
    @DisplayName("Removing out of bounds Throws Out of Bounds Error")
    public void removingWithIndexOutOfBoundsThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.remove(1));
    }

    @Test
    @DisplayName("Removing in bounds reduces size")
    public void removeReducesSizeFromThreeToTwo() {
        addThree();
        newList.remove(1);
        Assertions.assertEquals(2, newList.size());
    }

    @Test
    @DisplayName("Removing in bounds changes data stored at that index")
    public void removeShiftsDataStored() {
        addThree();
        newList.remove(1);
        Assertions.assertEquals(5, newList.get(1));
    }

    @Test
    @DisplayName("Removing third of three makes the second last")
    public void removeThirdMakesSecondLast() {
        addThree();
        newList.remove(2);
        Assertions.assertEquals(2, newList.size());
        Assertions.assertEquals(1, newList.get(0));
        Assertions.assertEquals(3, newList.get(1));
    }

    @Test
    @DisplayName("Removing first makes second item first")
    public void removeFirstMakesSecondFirst() {
        addThree();
        newList.remove(0);
        Assertions.assertEquals(2, newList.size());
        Assertions.assertEquals(3, newList.get(0));
        Assertions.assertEquals(5, newList.get(1));
    }

    @Test
    @DisplayName("Removing only item results in 0 size list")
    public void removingOnlyGetsSize0() {
        newList.add(1);
        newList.remove(0);
        Assertions.assertEquals(0, newList.size());
    }

    @Test
    @DisplayName("Set replaces value with new one at the index")
    public void setsIndexToSpecifiedValue() {
        addThree();
        newList.set(1, 10);
        Assertions.assertEquals(10, newList.get(1));
    }

    @Test
    @DisplayName("Swap exchanges the values stored at two indexes")
    public void swapExchangesValuesBetweenTwoIndexes() {
        addThree();
        newList.swap(0, 2);
        Assertions.assertEquals(5, newList.get(0));
        Assertions.assertEquals(1, newList.get(2));
    }

    @Test
    @DisplayName("First returns the value of the first entry")
    public void firstReturnsFirstValue() {
        newList.add(7);
        assertEquals(7, newList.first());
    }

    @Test
    @DisplayName("CreateNew returns an empty LinkedList")
    public void createNewReturnsEmptyLinkedList() {
        SortableList created = newList.createNew();
        assertEquals(created.getClass(), newList.getClass());
    }

    private void addThree() {
        newList.add(1);
        newList.add(3);
        newList.add(5);
    }
}
