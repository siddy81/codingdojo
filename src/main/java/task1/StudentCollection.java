package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentCollection{
    private List<Student> students;

    public void addStudent(Student student){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(student);

    }

    public List<Student> getStudents(){
        Collections.sort(students);
        return students;
    }

}
