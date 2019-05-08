package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class WriterXML {
    private File file;
    private Document document;
    private List<Student> students;

    public WriterXML(File file, List<Student> students) {
        this.file = file;
        this.students = students;
    }

    public WriterXML(List<Student> students) {
        this.students = students;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void write() throws TransformerException, ParserConfigurationException {
        if (file != null && students != null) {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element elementList = document.createElement("listStudent");
            for (Student studentIter : students) {

                Element elementStudent = document.createElement("student");

                Element elementSurname = document.createElement("surname");
                elementSurname.setTextContent(studentIter.getSurname());
                elementStudent.appendChild(elementSurname);

                Element elementName = document.createElement("name");
                elementName.setTextContent(studentIter.getName());
                elementStudent.appendChild(elementName);

                Element elementPatronymic = document.createElement("patronymic");
                elementPatronymic.setTextContent(studentIter.getPatronymic());
                elementStudent.appendChild(elementPatronymic);

                Element elementGroup = document.createElement("group");
                elementGroup.setTextContent(String.valueOf(studentIter.getGroupNumb()));
                elementStudent.appendChild(elementGroup);

                Element elementMissings = document.createElement("missings");

                Element elementMissingsDueDisease = document.createElement("missings_disease");

                elementMissingsDueDisease.setTextContent(String.valueOf(studentIter.getMissingDueDisease()));
                elementMissings.appendChild(elementMissingsDueDisease);

                Element elementMissingsDueOtherReason = document.createElement("missings_due_other_reason");
                elementMissingsDueOtherReason.setTextContent(String.valueOf(studentIter.getMissingDueOtherReason()));
                elementMissings.appendChild(elementMissingsDueOtherReason);

                Element elementMissingsWithoutReason = document.createElement("Missings_without_reason");
                elementMissingsWithoutReason.setTextContent(String.valueOf(studentIter.getMissingWithoutReason()));
                elementMissings.appendChild(elementMissingsWithoutReason);


                elementStudent.appendChild(elementMissings);
                elementList.appendChild(elementStudent);
            }

            document.appendChild(elementList);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

        }
    }
}