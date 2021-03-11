package task9;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E> implements BoundedBlockingQueue<E> {
    private final List<E> queue = new LinkedList<>();

    @Setter
    private boolean enableSysout = false;

    @Getter
    private int limit = 2;

    public void setLimit(int limit) {
        if (limit <= 1) {
            this.limit = 2;
        } else {
            this.limit = limit;
        }

    }

    public int size() {
        return this.queue.size();
    }

    @Override
    public synchronized void add(E item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            if (enableSysout) {
                System.out.println("Item: " + item + " is waiting for adding.");
                System.out.println("The current occupancy of the queue is " + this.queue.size() + " out of " + this.limit + "");
            }
            wait();
        }
        this.queue.add(item);
        if (enableSysout) {
            System.out.println("Item: " + item + " was added");
            System.out.println("The current occupancy of the queue is " + this.queue.size() + " out of " + this.limit + "");
        }
        if (this.queue.size() <= 1) {
            notifyAll();
        }
    }

    @Override
    public synchronized E remove() throws InterruptedException {
        while (this.queue.size() == 0) {
            if (enableSysout) {
                System.err.println("There is nothing to remove..");
                System.err.println("The current occupancy of the queue is " + this.queue.size() + " out of " + this.limit + "");
            }
            wait(1000);
        }
        if (this.queue.size() == this.limit) {
            if (enableSysout) {
                System.err.println("removing items... ");
                System.err.println("The current occupancy of the queue is " + this.queue.size() + " out of " + this.limit + "");
            }
            notifyAll();
        }
        E removedItem = this.queue.remove(0);
        if (enableSysout) {
            System.err.println("removing item: " + removedItem);
            System.err.println("The current occupancy of the queue is " + this.queue.size() + " out of " + this.limit + "");
        }
        return removedItem;
    }
}
