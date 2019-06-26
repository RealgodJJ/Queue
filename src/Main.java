import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            queue.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);

            if (i % 3 == 2)
                arrayQueue.dequeue();

            System.out.println(arrayQueue);
        }

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);

            if (i % 3 == 2)
                loopQueue.dequeue();

            System.out.println(loopQueue);
        }

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue1 = new ArrayQueue<>();
        double time_1 = testQueue(arrayQueue1, opCount);
        System.out.println("ArrayQueue Time: " + time_1 + "s");

        LoopQueue<Integer> loopQueue1 = new LoopQueue<>();
        double time_2 = testQueue(loopQueue1, opCount);
        System.out.println("LoopQueue Time: " + time_2 + "s");
    }
}
