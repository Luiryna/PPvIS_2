package View;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import Controller.Controller;


public class Pagination extends Composite {
    public Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
            SWT.V_SCROLL | SWT.H_SCROLL);

    public Pagination(Composite composite, int i) {
        super(composite, i);
    }

    public void draw(StudentsData studentsData, Controller controller) {

        for (Student student : studentsData.getStudents()) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
            tableItem.setText(1, student.getStreet() + " " + student.getHome());
            tableItem.setText(2, student.getMobPhone());
            tableItem.setText(3, student.getHomePhone());

        }

    }

    public void initTable(StudentsData studentsData, Controller controller) {

        table.setBounds(50, 50, 520, 300);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn fioColumn = new TableColumn(table, SWT.CENTER);
        fioColumn.setText("Student's FIO");
        fioColumn.setResizable(true);
        fioColumn.setWidth(150);

        TableColumn groupColumn = new TableColumn(table, SWT.CENTER);
        groupColumn.setText("Adres");
        groupColumn.setResizable(true);
        groupColumn.setWidth(150);

        TableColumn studentsMisses = new TableColumn(table, SWT.CENTER);
        studentsMisses.setText("Mobile phone");
        studentsMisses.setResizable(true);
        studentsMisses.setWidth(110);

        TableColumn studentsMisses1 = new TableColumn(table, SWT.CENTER);
        studentsMisses1.setText("Home phone");
        studentsMisses1.setResizable(true);
        studentsMisses1.setWidth(110);

    }

    public void clear() {
        table.removeAll();
    }
}

