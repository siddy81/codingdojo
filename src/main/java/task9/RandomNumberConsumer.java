package task9;

public class RandomNumberConsumer implements Runnable {

    private final int poisonPill;
    BlockingQueue<Integer> queue;

    public RandomNumberConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {

                Integer number = queue.remove();
                if (number.equals(poisonPill)) {
                    return;
                }
                System.err.println(Thread.currentThread().getName() + " result: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
