package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
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

                Element elementAdres = document.createElement("adres");

                Element elementStreet = document.createElement("street");
                elementStreet.setTextContent(studentIter.getStreet());
                elementAdres.appendChild(elementStreet);


                Element elementHome = document.createElement("home");
                elementHome.setTextContent(studentIter.getHome());
                elementAdres.appendChild(elementHome);

                elementStudent.appendChild(elementAdres);


                Element elementMobiles = document.createElement("mobiles");

                Element elementMobPhone = document.createElement("mobile_phone");
                elementMobPhone.setTextContent(studentIter.getMobPhone());
                elementMobiles.appendChild(elementMobPhone);

                Element elementHomePhone = document.createElement("home_phone");
                elementHomePhone.setTextContent(studentIter.getHomePhone());
                elementMobiles.appendChild(elementHomePhone);

                elementStudent.appendChild(elementMobiles);
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