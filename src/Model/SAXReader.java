package Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXReader extends DefaultHandler {

    private boolean bName;
    private boolean bSurname;
    private boolean bPatronymic;
    private boolean bStreet;
    private boolean bHome;
    private boolean bMobPhone;
    private boolean bHomePhone;
    private boolean bListStudent;
    private boolean bStudent;

    private List students;
    private Student student;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("listStudent")) {
//            bListStudent = true;
            students = new ArrayList();
        } else if (qName.equalsIgnoreCase("student")) {
//            bStudent = true;
            student = new Student();
        } else if (qName.equalsIgnoreCase("surname")) {
            bSurname = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("patronymic")) {
            bPatronymic = true;
        } else if (qName.equalsIgnoreCase("street")) {
            bStreet = true;
        } else if (qName.equalsIgnoreCase("home")) {
            bHome = true;
        } else if (qName.equalsIgnoreCase("mobile_phone")) {
            bMobPhone = true;
        } else if (qName.equalsIgnoreCase("home_phone")) {
            bHomePhone = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bListStudent) {
            students = new ArrayList();
            bListStudent = false;
        } else if (bStudent) {
            student = new Student();
            bStudent = false;
        } else if (bSurname) {
            student.setSurname(new String(ch, start, length));
            bSurname = false;
        } else if (bName) {
            student.setName(new String(ch, start, length));
            bName = false;
        } else if (bPatronymic) {
            student.setPatronymic(new String(ch, start, length));
            bPatronymic = false;
        } else if (bStreet) {
            student.setStreet(new String(ch, start, length));
            bStreet = false;
        } else if (bHome) {
            student.setHome(new String(ch, start, length));
            bHome = false;
        } else if (bMobPhone) {
            student.setMobPhone(new String(ch, start, length));
            bMobPhone = false;
        } else if (bHomePhone) {
            student.setHomePhone(new String(ch, start, length));
            bHomePhone = false;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            students.add(student);
            student = null;
        }
    }
}
