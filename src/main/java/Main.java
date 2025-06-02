
public class Main {

    public static void main(String[] args) {

        System.out.println("ArrayList Performance Testing");
        System.out.println("=============================\n");

        testAddToFront();

        testAddToEnd();

        testAddToMiddle();
    }

    public static void testAddToFront() {
        ArrayList list = new ArrayList();

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            list.add(0, i);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Front:");
        System.out.println("Time: " + (duration / 1_000_000.0) + " milliseconds");
        System.out.println("Final size: " + list.size() + "\n");
    }

    public static void testAddToEnd() {
        ArrayList list = new ArrayList();

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to End:");
        System.out.println("Time: " + (duration / 1_000_000.0) + " milliseconds");
        System.out.println("Final size: " + list.size() + "\n");
    }

    public static void testAddToMiddle() {
        ArrayList list = new ArrayList();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int middleIndex = list.size() / 2;
            list.add(middleIndex, i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Adding to Middle:");
        System.out.println("Time: " + (duration / 1_000_000.0) + " milliseconds");
        System.out.println("Final size: " + list.size() + "\n");
    }
}