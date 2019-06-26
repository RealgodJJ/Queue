public class Main {


    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 20; i++) {
            arrayQueue.enqueue(i);

            if (i % 3 == 2)
                arrayQueue.dequeue();

            System.out.println(arrayQueue);
        }
    }
}
