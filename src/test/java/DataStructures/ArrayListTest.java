package DataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList newList;

    @BeforeEach
    void setUp() {
        newList = new ArrayList();
    }

    @Test
    @DisplayName("New list is size Zero")
    public void returnsSizeOfZero() {
        Assertions.assertEquals(0, newList.size());
    }

    @Test
    @DisplayName("Size increases with value added")
    public void sizeUpdatesWhenListGrows() {
        newList.add(1);
        Assertions.assertEquals(1, newList.size());
    }


    @Test
    @DisplayName("Value added is retrievable with get")
    public void addOneToEmptyArrayGetsArrayWithOne() {
        newList.add(1);
        Assertions.assertEquals(1, newList.get(0));
    }

    @Test
    @DisplayName("Negative initialization value throws Illegal Argument Exception")
    public void initializeWithNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> newList = new ArrayList(-1));
    }

    @Test
    @DisplayName("Get returns value stored within range")
    public void getWithIndexReturnsValueAtIndex() {
        addThree();
        Assertions.assertEquals(3, newList.get(1));
    }

    @Test
    @DisplayName("Get out of range throws Index Out Of Bounds Exception")
    public void getWithOutOfBoundsIndexThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.get(7));
    }

    @Test
    @DisplayName("Array size increases with demand; adding more values than default size does not error")
    public void addMoreThanDefaultArraySizeDoesNotError() {
        for (int i = 0; i < 11; i++) {
            assertDoesNotThrow(() -> newList.add(7));
        }
        Assertions.assertEquals(11, newList.size());
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
    @DisplayName("Add with index inserts at the index")
    public void addingWithIndexInsertsAtIndex() {
        addThree();
        newList.add(2, 1);
        Assertions.assertEquals(2, newList.get(1));
        Assertions.assertEquals(3, newList.get(2));
        Assertions.assertEquals(5, newList.get(3));
    }

    @Test
    @DisplayName("Add with index out of bounds throws Out of Bounds Exception")
    public void addingWithIndexOutOfBoundsThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.add(1, 1));
    }

    @Test
    @DisplayName("Adding to index 0 of a default initialized list does not error; initializes default size")
    public void addingWithZeroIndexToEmptyDoesNotThrow() {
        assertDoesNotThrow(() -> newList.add(1, 0));
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
    @DisplayName("CreateNew returns an empty ArrayList")
    public void createNewReturnsEmptyArrayList() {
        SortableList created = newList.createNew();
        assertEquals(created.getClass(), newList.getClass());
    }

    @Test
    @DisplayName("Returns false if Target Value is less than the next")
    public void greaterThanNextReturnsTrueIfTargetValueIsGreaterThanTheNext(){
        addThree();
        assertFalse(newList.swapIfGreaterThanNext(0));
        assertEquals(1, newList.get(0));
    }

    @Test
    @DisplayName("Returns false if Target index has no next")
    public void greaterThanNextReturnsFalseIfLast(){
        addThree();
        assertFalse(newList.swapIfGreaterThanNext(2));
    }

    @Test
    @DisplayName("Returns true & swaps values if Target index value is greater than the next")
    public void greaterThanNextReturnsTrueIfNextIsGreater(){
        newList.add(7);
        newList.add(3);
        assertTrue(newList.swapIfGreaterThanNext(0));
        assertEquals(3, newList.get(0));
    }

    private void addThree() {
        newList.add(1);
        newList.add(3);
        newList.add(5);
    }
}
