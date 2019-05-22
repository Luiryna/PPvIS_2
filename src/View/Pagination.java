package View;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.util.List;


public class Pagination extends Composite {

    public Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
            SWT.V_SCROLL | SWT.H_SCROLL);
    public Label numberOfWrites = new Label(this, SWT.NONE);
    public Label allWrites = new Label(this, SWT.NONE);
    public Label allPages = new Label(this, SWT.NONE);
    public Label currentPage = new Label(this, SWT.NONE);
    public Text numberToShow = new Text(this, SWT.BORDER);
    //private List<Student> students;
    int count = 5;
    int currentPageNumber = 0;
    int lastPage = 1;

    public Pagination(Composite composite, int i) {

        super(composite, i);

    }

    public void insertWrites(StudentsData studentsData) {
        clear();

        //int toIndex = currentPageNumber*count+count <= studentsData.getStudents().size() ? currentPageNumber*count+count : studentsData.getStudents().size();
        //double result = studentsData.getStudents().size()/count;
        //lastPage = (int) Math.ceil(result);
        lastPage = studentsData.getStudents().size() % count == 0 ? studentsData.getStudents().size() / count : studentsData.getStudents().size() / count + 1;
        int toIndex = (currentPageNumber + 1) * count > studentsData.getStudents().size() ? studentsData.getStudents().size() : (currentPageNumber + 1) * count;
        System.out.println(studentsData.getStudents().size());
        System.out.println(count);
        //System.out.println(result);
        System.out.println(lastPage);

        List<Student> studentList = studentsData.getStudents().subList(currentPageNumber*count, toIndex);

        for (Student student : studentList) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
            tableItem.setText(1, student.getStreet() + " " + student.getHome());
            tableItem.setText(2, student.getMobPhone());
            tableItem.setText(3, student.getHomePhone());

        }

        allWrites.setText("Total number of writes: " + studentsData.getStudents().size());
        allPages.setText("Pages at all: " + lastPage);
        currentPage.setText("Current page: " + (currentPageNumber + 1));
    }

    private void createColumn(Table table, String text, int width){
        TableColumn fioColumn = new TableColumn(table, SWT.CENTER);
        fioColumn.setText(text);
        fioColumn.setResizable(true);
        fioColumn.setWidth(width);
    }

    public void createTableForWrites(StudentsData studentsData) {

        table.setBounds(50, 200, 520, 300);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        createColumn(table, "Student's FIO", 150);

        createColumn(table, "Address", 150);

        createColumn(table, "Mobile phone", 110);

        createColumn(table, "Home phone", 110);

        Button buttonFirstPage = new Button(this, SWT.PUSH);
        buttonFirstPage.setBounds(50, 150, 100, 30);
        buttonFirstPage.setText("FIRST");

        buttonFirstPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                currentPageNumber = 0;
                insertWrites(studentsData);
            }
        });

        Button buttonPreviousPage = new Button(this, SWT.PUSH);
        buttonPreviousPage.setBounds(180, 150, 100, 30);
        buttonPreviousPage.setText("PREVIOUS");

        buttonPreviousPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (currentPageNumber > 0){
                    currentPageNumber--;
                }

                insertWrites(studentsData);
            }
        });

        Button buttonNextPage = new Button(this, SWT.PUSH);
        buttonNextPage.setBounds(330, 150, 100, 30);
        buttonNextPage.setText("NEXT");

        buttonNextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (currentPageNumber < lastPage){
                    currentPageNumber++;
                }
                insertWrites(studentsData);
            }
        });

        Button buttonLastPage = new Button(this, SWT.PUSH);
        buttonLastPage.setBounds(460, 150, 100, 30);
        buttonLastPage.setText("LAST");

        buttonLastPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                currentPageNumber = lastPage - 1;
                insertWrites(studentsData);
            }
        });

        numberOfWrites.setBounds(50, 10, 277, 30);
        numberOfWrites.setText("Enter number of writes to show on a page:");
        numberToShow.setBounds(350, 10, 30, 25);

        Button enter = new Button(this, SWT.PUSH);
        enter.setBounds(390, 10, 100, 30);
        enter.setText("enter");

        enter.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                count = Integer.parseInt(numberToShow.getText());
                insertWrites(studentsData);
            }});

        allWrites.setBounds(50, 50, 200, 30);
        allPages.setBounds(50, 100, 150, 30);
        currentPage.setBounds(250, 100, 150, 30);
    }

    public void clear() {

        table.removeAll();

    }
}

