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
        //   return Character.compare(Character.toLowerCase(this.getJobName()),
        //           Character.toLowerCase(job.getJobName()));

        if (this.getDependentJob() == null && job.getDependentJob() == null) {
            return Character.compare(Character.toLowerCase(this.getJobName()),
                    Character.toLowerCase(job.getJobName()));
        } else {
            return Character.compare(Character.toLowerCase(this.getDependentJob() == null ? this.getJobName() : this.getDependentJob()),
                    Character.toLowerCase(job.getDependentJob() == null ? job.getJobName() : job.getDependentJob()));
        }

    }

}
