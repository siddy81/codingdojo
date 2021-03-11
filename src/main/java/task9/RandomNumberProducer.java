package task9;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberProducer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public RandomNumberProducer(BlockingQueue<Integer> queue, int poisonPill, int poisonPillPerProducer) {
        this.queue = queue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateRandomNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void generateRandomNumbers() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            queue.add(ThreadLocalRandom.current().nextInt(1000));
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {
            queue.add(poisonPill);
        }
    }
}
