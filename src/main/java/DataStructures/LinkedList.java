package DataStructures;

public class LinkedList implements SortableList {

    private int size = 0;
    private Node first;
    private Node last;

    @Override
    public void add(int i) {
        Node newData = new Node(i, last, null);
        if (last == null) {
            first = newData;
        } else {
            last.next = newData;
        }
        last = newData;
        size++;
    }

    @Override
    public void add(int value, int index) {
        checkBounds(index);
        if (size == 0) {
            Node newData = new Node(value, null, null);
            last = newData;
            first = newData;
        } else if (index == 0) {
            Node newData = new Node(value, null, first);
            first.previous = newData;
            first = newData;
        } else if (size == index) {
            Node newData = new Node(value, last, null);
            last.next = newData;
            last = newData;
        } else {
            Node nodeToShift = getNode(index);
            Node previous = nodeToShift.previous;
            Node newData = new Node(value, previous, nodeToShift);
            previous.next = newData;
            nodeToShift.previous = newData;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == 1) {
            first = null;
            last = null;
        } else if (index == 0) {
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            Node targetNode = getNode(index);
            Node previous = targetNode.previous;
            Node next = targetNode.next;
            previous.next = next;
            next.previous = previous;
        }
        size--;
    }

    @Override
    public int get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node targetNode = getNode(index);
        return targetNode.value;
    }

    @Override
    public void set(int index, int value) {
        getNode(index).value = value;
    }

    @Override
    public void swap(int i, int j) {
        Node nodeI = getNode(i);
        Node nodeJ = getNode(j);
        int temp = nodeI.value;
        nodeI.value = nodeJ.value;
        nodeJ.value = temp;
    }

    @Override
    public int first() {
        return first.value;
    }

    @Override
    public SortableList createNew() {
        return new LinkedList();
    }

    private void checkBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node getNode(int index) {
        Node selectedNode;
        int halfWay = size / 2;
        if (index < halfWay) {
            selectedNode = first;
            for (int i = 0; i < index; i++) {
                selectedNode = selectedNode.next;
            }
        } else {
            selectedNode = last;
            for (int i = size - 1; i > index; i--) {
                selectedNode = selectedNode.previous;
            }
        }
        return selectedNode;
    }

    private static class Node {
        int value;
        Node next;
        Node previous;

        Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
