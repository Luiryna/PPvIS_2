package View;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import Controller.Controller;


public class Pagination extends Composite {
    public Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
            SWT.V_SCROLL | SWT.H_SCROLL);
    public Label numberOfWrites = new Label(this, SWT.NONE);
    public Label allWrites = new Label(this, SWT.NONE);
    public Label allPages = new Label(this, SWT.NONE);
    public Label currentPage = new Label(this, SWT.NONE);

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

        allWrites.setText("Total number of writes: " + studentsData.getStudents().size());
        allPages.setText("Pages at all: ");
        currentPage.setText("Current page: ");
    }

    public void initTable(StudentsData studentsData, Controller controller) {

        table.setBounds(50, 200, 520, 300);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn fioColumn = new TableColumn(table, SWT.CENTER);
        fioColumn.setText("Student's FIO");
        fioColumn.setResizable(true);
        fioColumn.setWidth(150);

        TableColumn adresColumn = new TableColumn(table, SWT.CENTER);
        adresColumn.setText("Adres");
        adresColumn.setResizable(true);
        adresColumn.setWidth(150);

        TableColumn MobPhineColumn = new TableColumn(table, SWT.CENTER);
        MobPhineColumn.setText("Mobile phone");
        MobPhineColumn.setResizable(true);
        MobPhineColumn.setWidth(110);

        TableColumn MobPhoneColumn = new TableColumn(table, SWT.CENTER);
        MobPhoneColumn.setText("Home phone");
        MobPhoneColumn.setResizable(true);
        MobPhoneColumn.setWidth(110);

        Button buttonFirstPage = new Button(this, SWT.PUSH);
        buttonFirstPage.setBounds(50, 150, 100, 30);
        buttonFirstPage.setText("FIRST");

        Button buttonPreviousPage = new Button(this, SWT.PUSH);
        buttonPreviousPage.setBounds(180, 150, 100, 30);
        buttonPreviousPage.setText("PREVIOUS");

        Button buttonNextPage = new Button(this, SWT.PUSH);
        buttonNextPage.setBounds(330, 150, 100, 30);
        buttonNextPage.setText("NEXT");

        Button buttonLastPage = new Button(this, SWT.PUSH);
        buttonLastPage.setBounds(460, 150, 100, 30);
        buttonLastPage.setText("LAST");

        numberOfWrites.setBounds(50, 10, 277, 30);
        numberOfWrites.setText("Enter number of writes to show on a page:");

        Text numberToShow = new Text(this, SWT.BORDER);
        numberToShow.setBounds(350, 10, 30, 25);

        Button enter = new Button(this, SWT.PUSH);
        enter.setBounds(390, 10, 100, 30);
        enter.setText("enter");

        allWrites.setBounds(50, 50, 200, 30);

        allPages.setBounds(50, 100, 150, 30);

        currentPage.setBounds(250, 100, 150, 30);
    }

    public void clear() {
        table.removeAll();
    }
}

