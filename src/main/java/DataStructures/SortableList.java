package DataStructures;

public interface SortableList extends List {
    void set(int index, int value);
    void swap(int i, int j);
    SortableList createNew();
    boolean swapIfGreaterThanNext(int i);
}
