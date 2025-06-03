
public class Main {
    public static void main(String[] args) {

        System.out.println("ArrayList Performance Testing");
        System.out.println("=============================\n");

        testAddToFrontArrayList();
        testAddToEndArrayList();
        testAddToMiddleArrayList();

        System.out.println("LinkedList Performance Testing");
        System.out.println("=============================\n");

        testAddToFrontLinkedList();
        testAddToEndLinkedList();
        testAddToMiddleLinkedList();


        System.out.println("QuickSort Performance Testing");
        System.out.println("=============================\n");


    }

    public static void testAddToFrontArrayList() {
        ArrayList array = new ArrayList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            array.add(i, 0);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public static void testAddToEndArrayList() {
        ArrayList array = new ArrayList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            array.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }

    public static void testAddToMiddleArrayList() {
        ArrayList array = new ArrayList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int middleIndex = array.size() / 2;
            array.add(i, middleIndex);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Middle:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + array.size() + "\n");
    }
    public static void testAddToFrontLinkedList() {
        LinkedList linked = new LinkedList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linked.add(i, 0);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    public static void testAddToEndLinkedList() {
        LinkedList linked = new LinkedList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linked.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }

    public static void testAddToMiddleLinkedList() {
        LinkedList linked = new LinkedList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int middleIndex = linked.size() / 2;
            linked.add(i, middleIndex);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Middle:");
        System.out.println("Time: " + (duration / 1000000.0) + " milliseconds");
        System.out.println("Final size: " + linked.size() + "\n");
    }
}