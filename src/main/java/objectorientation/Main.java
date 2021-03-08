package objectorientation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
}
