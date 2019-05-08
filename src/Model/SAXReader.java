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
    private boolean bGroupNumber;
    private boolean bMissingsDueDisease;
    private boolean bMissingsDueOtherReason;
    private boolean bMissingsWithoutReason;
    private boolean bListStudent;
    private boolean bStudent;

    private List students;
    private Student student;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("listStudent")) {
            bListStudent = true;
        } else if (qName.equalsIgnoreCase("Student")) {
            bStudent = true;
        } else if (qName.equalsIgnoreCase("surname")) {
            bSurname = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("Patronymic")) {
            bPatronymic = true;
        } else if (qName.equalsIgnoreCase("group")) {
            bGroupNumber = true;
        } else if (qName.equalsIgnoreCase("missings_disease")) {
            bMissingsDueDisease = true;
        } else if (qName.equalsIgnoreCase("missings_due_other_reason")) {
            bMissingsDueOtherReason = true;
        } else if (qName.equalsIgnoreCase("Missings_without_reason")) {
            bMissingsWithoutReason = true;
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
        } else if (bGroupNumber) {
            student.setGroupNumb(Integer.parseInt(new String(ch, start, length)));
            bGroupNumber = false;
        } else if (bMissingsDueDisease) {
            student.setMissingDueDisease(Integer.parseInt(new String(ch, start, length)));
            bMissingsDueDisease = false;
        } else if (bMissingsDueOtherReason) {
            student.setMissingDueOtherReason(Integer.parseInt(new String(ch, start, length)));
            bMissingsDueOtherReason = false;
        } else if (bMissingsWithoutReason) {
            student.setMissingWithoutReason(Integer.parseInt(new String(ch, start, length)));
            bMissingsWithoutReason = false;
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
