package task1;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private String id;
    private String name;

    @SuppressWarnings("java:S106")
    public static void task1() {
        List<Student> students = new ArrayList<>();
        students.add(Student.builder()
                .id("5421")
                .name("Carl Friedrich Gauss").build());

        students.add(Student.builder()
                .id("0054")
                .name("Albert Einstein").build());

        students.add(Student.builder()
                .id("1234")
                .name("Gottfried Wilhelm Leibniz").build());

        Collections.sort(students);

        students.forEach(student ->
                System.out.println(student.toString()));
    }

    @Override
    public String toString() {
        return this.name + " " + this.id;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
