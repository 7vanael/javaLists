package DataStructures;

public class ArrayList implements SortableList {

    private int size = 0;
    private int[] storedData;

    public ArrayList() {
        int DEFAULT_INITIAL_CAPACITY = 10;
        storedData = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public ArrayList(int initializedCapacity) {
        if (initializedCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initializedCapacity);
        storedData = new int[initializedCapacity];
    }

    @Override
    public void add(int i) {
        if (size == storedData.length)
            increaseSize();
        storedData[size] = i;
        size++;
    }

    @Override
    public void add(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == storedData.length) {
            increaseSize();
        }
        if (index < size) {
            makeSpace(index);
        }
        storedData[index] = element;
        size++;
    }

    @Override
    public void set(int index, int value) {
        storedData[index] = value;
    }

    @Override
    public void swap(int i, int j) {
        int temp = storedData[i];
        storedData[i] = storedData[j];
        storedData[j] = temp;
    }

    private void makeSpace(int targetIndex) {
        for (int i = size; i > targetIndex; i--) {
            storedData[i] = storedData[i - 1];
        }
    }

    private void increaseSize() {
        int newSize = size * 2;
        int[] longerArray = new int[newSize];
        for (int i = 0; i < size; i++) {
            longerArray[i] = storedData[i];
        }
        storedData = longerArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size -1; i++) {
            storedData[i] = storedData[i + 1];
        }
        size--;
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return storedData[index];
    }

    @Override
    public int first(){
        return storedData[0];
    }

    @Override
    public SortableList createNew(){
        return new ArrayList();
    }
}