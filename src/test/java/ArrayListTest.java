import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList newList;

    @BeforeEach
    void setUp() {
        newList = new ArrayList();
    }

    @Test
    public void returnsSizeOfZero(){
        assertEquals(0, newList.size());
    }

    @Test
    public void addOneToEmptyArrayGetsArrayWithOne() {
        newList.add(1);
        assertEquals(1, newList.get(0));
    }

    @Test
    public void sizeUpdatesWhenListGrows(){
        newList.add(1);
        assertEquals(1, newList.size());
    }

    @Test
    public void getWithIndexReturnsValueAtIndex(){
        addThree();
        assertEquals(3, newList.get(1));
    }

    @Test
    public void getWithOutOfBoundsIndexThrows(){
        assertThrows(IndexOutOfBoundsException.class,()-> newList.get(7));
    }

    @Test
    public void addMoreThanDefaultArraySizeDoesNotError() {
        for (int i = 0; i < 11; i++) {
            assertDoesNotThrow(() -> newList.add(7));
        }
        assertEquals(11, newList.size());
    }

    @Test
    public void addingWithoutIndexArgumentAppends() {
        addThree();
        assertEquals(1, newList.get(0));
        assertEquals(3, newList.get(1));
        assertEquals(5, newList.get(2));
    }

    @Test
    public void addingWithIndexInsertsAtIndex() {
        addThree();
        newList.add(1, 2);
        assertEquals(2, newList.get(1));
        assertEquals(3, newList.get(2));
        assertEquals(5, newList.get(3));
    }

    @Test
    public void addingWithIndexOutOfBoundsThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.add(1, 1));
    }

    @Test
    public void addingWithZeroIndexToEmptyDoesNotThrow(){
        assertDoesNotThrow(() -> newList.add(0, 1));
    }

    @Test
    public void removingWithIndexOutOfBoundsThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> newList.remove(1));
    }

    @Test
    public void removeReducesSizeFromThreeToTwo() {
        addThree();
        newList.remove(1);
        assertEquals(2, newList.size());
    }

    private void addThree() {
        newList.add(1);
        newList.add(3);
        newList.add(5);
    }
}
