package Model;

import java.util.ArrayList;
import java.util.List;

public class StudentsData {
    //private StudentsData studentsData;

    public List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        students.add(student);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}