package task1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StudentCollectionTest {

    StudentCollection studentCollection;

    @BeforeMethod
    public void setUp() {
        studentCollection = new StudentCollection();
    }

    @Test
    public void testGetStudents() {
        studentCollection.addStudent(Student.builder()
                .id("5421")
                .name("Carl Friedrich Gauss").build());

        studentCollection.addStudent((Student.builder()
                .id("0054")
                .name("Albert Einstein").build()));

        studentCollection.addStudent((Student.builder()
                .id("1234")
                .name("Gottfried Wilhelm Leibniz").build()));

        List<Student> students = studentCollection.getStudents();
        Assert.assertNotNull(students);
        Assert.assertEquals(students.size(), 3);

        Assert.assertEquals(students.get(0).getName(), "Albert Einstein");
        Assert.assertEquals(students.get(1).getName(), "Carl Friedrich Gauss");
        Assert.assertEquals(students.get(2).getName(), "Gottfried Wilhelm Leibniz");
    }
}