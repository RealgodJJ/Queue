public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        //若循环队列满，则将循环队列进行扩容
        if ((tail + 1) % data.length == front) {
            resize(data.length * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("The queue is null.");

        if (size == data.length / 4 && getCapacity() / 2 != 0)
            resize(data.length / 2);

        T result = data[front];
//        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return result;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail)
                result.append(", ");
        }

//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            result.append(data[i]);
//            if ((i + 1) % data.length != tail)
//                result.append(", ");
//        }
        result.append("] queue tail");
        return result.toString();
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            newData[(i - front) < 0 ? i : i - front] = data[i];
//        }
        data = newData;
        front = 0;
        tail = size;
    }
}
