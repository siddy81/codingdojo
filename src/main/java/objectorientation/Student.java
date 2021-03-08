package objectorientation;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private String id;
    private String name;

    @Override
    public String toString() {
        return this.name + " " + this.id;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
