package task9;

//https://www.baeldung.com/java-blocking-queue
public interface BoundedBlockingQueue<E> {
    void add(E item) throws InterruptedException;

    E remove() throws InterruptedException;
}
