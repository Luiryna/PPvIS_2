package Controller;

import Model.StudentsData;
import Model.SAXReader;
import Model.Student;
import Model.WriterXML;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private  WriterXML writerXML;
    private  SAXReader saxReader;
    private StudentsData studentsData;

    public Controller(StudentsData studentsData){
        this.studentsData = studentsData;
    }

    public void save(File file) {
        if (writerXML == null)
            writerXML = new WriterXML(studentsData.getStudents());
        writerXML.setFile(file);
        try {
            writerXML.write();
        } catch (TransformerException | ParserConfigurationException e) {
        }
    }


    public void open(File file) {
        if (saxReader == null) saxReader = new SAXReader();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, saxReader);
            studentsData.setStudents(saxReader.getStudents());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String surname, String name, String patronymic, String street,
                           String home, String mobPhone, String homePhone){
        Student student = new Student(surname, name, patronymic, street, home, mobPhone, homePhone);
        studentsData.setStudent(student);
    }

    public List<Student> SearchBySurnameAndHomePhone(String surname, String phoneNumb){
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if (student.getSurname().equals(surname) || student.getHomePhone().equals(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }

        return students;
    }

    public List<Student> SearchBySurnameAndMobilePhone(String surname, String phoneNumb){
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if (student.getSurname().equals(surname) || student.getMobPhone().equals(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }

        return students;
    }

    public List<Student> SearchByAdresAndHomePhone(String street, String home, String phoneNumb) {
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if ((student.getStreet().equals(street) && student.getHome().equals(home)) || student.getHomePhone().equals(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }

        return students;
    }

    public List<Student> SearchByAdresAndMobilePhone(String street, String home, String phoneNumb) {
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if ((student.getStreet().equals(street) && student.getHome().equals(home)) || student.getMobPhone().equals(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }

        return students;
    }

    public List<Student> SearchBySurnameAndNumeralsOfHomePhone(String surname, String phoneNumb) {
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if (student.getSurname().equals(surname) && student.getHomePhone().contains(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }
        return students;
    }

    public List<Student> SearchBySurnameAndNumeralsOfMobilePhone(String surname, String phoneNumb) {
        List<Student> students = new ArrayList<>();
        for (Student student: studentsData.getStudents()){
            if (student.getSurname().equals(surname) && student.getMobPhone().contains(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }
        return students;
    }

    public List<Student> getStudents() {
        return studentsData.getStudents();
    }

}
