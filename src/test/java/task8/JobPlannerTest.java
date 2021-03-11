package task8;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobPlannerTest {

    JobPlanner jobPlanner;

    @BeforeMethod
    public void setUp() {
        jobPlanner = new JobPlanner();
    }

    @Test
    public void testRegisterOneJob() {
        jobPlanner.register('A');
        String[] jobList = jobPlanner.sort();
        Assert.assertNotNull(jobList);
        Assert.assertEquals(jobList.length, 1);
        Assert.assertEquals(jobList[0], "A");

    }

    @Test
    public void testRegisterMultipleJobs() {
        jobPlanner.register('Z');
        jobPlanner.register('t');
        jobPlanner.register('G');
        jobPlanner.register('5');
        jobPlanner.register('A');
        jobPlanner.register('Q');

        String[] jobList = jobPlanner.sort();

        Assert.assertNotNull(jobList);
        Assert.assertEquals(jobList.length, 6);

        Assert.assertEquals(jobList[0], "5");
        Assert.assertEquals(jobList[1], "A");
        Assert.assertEquals(jobList[2], "G");
        Assert.assertEquals(jobList[3], "Q");
        Assert.assertEquals(jobList[4], "t");
        Assert.assertEquals(jobList[5], "Z");
    }

    @Test
    public void testRegisterMultipleDependentJobs() {
        jobPlanner.register('A', 'B');
        jobPlanner.register('B');
        jobPlanner.register('C', 'A');

        String[] jobList = jobPlanner.sort();

        Assert.assertNotNull(jobList);
        Assert.assertEquals(jobList.length, 3);

        Assert.assertEquals(jobList[0], "B");
        Assert.assertEquals(jobList[1], "A");
        Assert.assertEquals(jobList[2], "C");

    }

}