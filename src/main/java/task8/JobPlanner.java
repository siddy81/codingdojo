package task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JobPlanner implements OrderedJobs {

    private List<Job> jobs;

    @Override
    public void register(char job) {
        register(job, '-');

    }

    @Override
    public void register(char job, char dependentJob) {
        if (jobs == null) {
            jobs = new ArrayList<>();
        }
        jobs.add(Job.builder().jobName(job).dependentJob(dependentJob == '-' ? null : dependentJob).build());
    }

    @Override
    public String[] sort() {
        Collections.sort(jobs);

        List<String> collect = jobs.stream().map(job -> String.valueOf(job.getJobName())).collect(Collectors.toList());
        String[] result = new String[collect.size()];

        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i);

        }

        return result;
    }
}
