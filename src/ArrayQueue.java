public class ArrayQueue<T> implements Queue<T> {
    private Array<T> arrayQueue;

    public ArrayQueue() {
        arrayQueue = new Array<>();
    }

    public ArrayQueue(int capacity) {
        arrayQueue = new Array<>(capacity);
    }

    public int getCapacity() {
        return arrayQueue.getCapacity();
    }

    @Override
    public int getSize() {
        return arrayQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        arrayQueue.addLast(e);
    }

    @Override
    public T dequeue() {
        return arrayQueue.removeFirst();
    }

    @Override
    public T getFront() {
        return arrayQueue.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size: %d, capacity: %d\n", getSize(), getCapacity()));
        result.append("[");
        for (int i = 0; i < getSize(); i++) {
            result.append(arrayQueue.getElement(i));
            if (i != getSize() - 1)
                result.append(", ");
        }
        result.append("] queue tail");
        return result.toString();
    }
}
