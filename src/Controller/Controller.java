package Controller;

import Model.SAXReader;
import Model.Student;
import Model.WriterXML;
import Model.info;
import org.eclipse.swt.widgets.TableItem;
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
    private info info;
    private boolean generate = false;

    public Controller(info info){
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

    public List<Student> find1Student(String surname, int groupNumber){
        List<Student> students = new ArrayList<>();
        for (Student student:info.getStudents()){
            if (student.getSurname().equals(surname) && student.getGroupNumb()==groupNumber){
                students.add(student);
            }
        }

        return students;
    }

    public List<Student> find2Student(String surname, String typeOfMissing){
        List<Student> students = new ArrayList<>();
        for (Student student:info.getStudents()){
            if (typeOfMissing.equals("due disease")){
                if (student.getSurname().equals(surname) && student.getMissingDueDisease()>0){
                    students.add(student);
                }
            } else {
                if (typeOfMissing.equals("without reason")){
                    if (student.getSurname().equals(surname) && student.getMissingWithoutReason()>0){
                        students.add(student);
                    }
                } else {
                    if (typeOfMissing.equals("due other reason")){
                        if (student.getSurname().equals(surname) && student.getMissingDueOtherReason()>0){
                            students.add(student);
                        }
                    }
                }
            }
        }
        return students;
    }

    public List<Student> find3Student(String surname, String typeOfMissing, int countMissings){
        List<Student> students = new ArrayList<>();
        for (Student student:info.getStudents()){
            if (typeOfMissing.equals("due disease") && student.getMissingDueDisease() == countMissings){
                if (student.getSurname().equals(surname) && student.getMissingDueDisease()>0){
                    students.add(student);
                }
            } else {
                if (typeOfMissing.equals("without reason") && student.getMissingWithoutReason() == countMissings){
                    if (student.getSurname().equals(surname) && student.getMissingWithoutReason()>0){
                        students.add(student);
                    }
                } else {
                    if (typeOfMissing.equals("due other reason") && student.getMissingDueOtherReason() == countMissings){
                        if (student.getSurname().equals(surname) && student.getMissingDueOtherReason()>0){
                            students.add(student);
                        }
                    }
                }
            }
        }
        return students;
    }


    public int countMissings(Student student) {
        return student.getMissingDueDisease() + student.getMissingDueOtherReason() + student.getMissingWithoutReason();
    }
}
