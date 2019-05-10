package Controller;

import Model.Info;
import Model.SAXReader;
import Model.Student;
import Model.WriterXML;
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
    private Info info;

    public Controller(Info info){
        this.info = info;
    }

    public boolean save(File file) {
        if (writerXML == null)
            writerXML = new WriterXML(info.getStudents());
        writerXML.setFile(file);
        try {
            writerXML.write();
            return true;
        } catch (TransformerException | ParserConfigurationException e) {
            return false;
        }
    }



    public boolean open(File file) {
        if (saxReader == null) saxReader = new SAXReader();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, saxReader);
            info.setStudents(saxReader.getStudents());
            return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Student> firstSearch(String surname, String phoneNumb){
        List<Student> students = new ArrayList<>();
        for (Student student:info.getStudents()){
            if (student.getSurname().equals(surname) && student.getHomePhone().equals(phoneNumb)){
                students.add(student);
                System.out.println(String.format("фамилия: %s,  имя: %s,  отчество: %s, моб: %s, дом: %s",
                        student.getSurname(), student.getName(), student.getPatronymic(), student.getMobPhone(), student.getHomePhone()));
            }
        }

        return students;
    }

}
