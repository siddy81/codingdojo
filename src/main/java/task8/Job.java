package task8;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Comparable<Job> {
    private char jobName;
    private Character dependentJob;

    @Override
    public int compareTo(Job job) {
        if (job.getDependentJob() == null) {
            return Character.compare(Character.toLowerCase(this.getJobName()),
                    Character.toLowerCase(job.getJobName()));
        } else {

            int value = Character.compare(Character.toLowerCase(this.getJobName()),
                    Character.toLowerCase(job.getDependentJob()));
            if (value == 0) {
                return -1;
            } else {
                return Character.compare(Character.toLowerCase(this.getJobName()),
                        Character.toLowerCase(job.getJobName()));
            }
        }
    }

}
