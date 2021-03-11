package task9;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@RunWith(MockitoJUnitRunner.class)
public class BlockingQueueTest {

    BlockingQueue<Integer> spyQueue;

    @BeforeMethod
    public void setUp() {
        spyQueue = Mockito.spy(new BlockingQueue<>());
        //spyQueue.setEnableSysout(true);
    }

    @Test
    public void testBlockingQueueWithDefaultSetting() throws InterruptedException {

        Assert.assertNotNull(spyQueue);
        Assert.assertEquals(spyQueue.getLimit(), 2);
        Assert.assertEquals(spyQueue.size(), 0);

        spyQueue.add(new Integer(100));
        Assert.assertEquals(spyQueue.size(), 1);

        spyQueue.add(new Integer(200));
        Assert.assertEquals(spyQueue.size(), 2);

        Assert.assertEquals(spyQueue.remove().intValue(), 100);
        Assert.assertEquals(spyQueue.size(), 1);

        Assert.assertEquals(spyQueue.remove().intValue(), 200);
        Assert.assertEquals(spyQueue.size(), 0);

    }

}
