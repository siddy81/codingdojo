package task8;

public interface OrderedJobs {
    void register(char job);
    void register(char job, char dependentJob);
    String[] sort();

}
