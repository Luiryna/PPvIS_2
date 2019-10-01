package View;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.util.List;


public class Pagination extends Composite {

    private Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
            SWT.V_SCROLL | SWT.H_SCROLL);
    private Label numberOfWrites = new Label(this, SWT.NONE);
    private Label allWrites = new Label(this, SWT.NONE);
    private Label allPages = new Label(this, SWT.NONE);
    private Label currentPage = new Label(this, SWT.NONE);
    private Text numberToShow = new Text(this, SWT.BORDER);
    private List<Student> students;
    private int count = 5;
    private int currentPageNumber = 0;
    private int lastPage = 1;

    public Pagination(Composite composite, int i) {

        super(composite, i);

    }

    public void insertWrites() {
        clear();

        //int toIndex = currentPageNumber*count+count <= studentsData.getStudents().size() ? currentPageNumber*count+count : studentsData.getStudents().size();
        //double result = studentsData.getStudents().size()/count;
        //lastPage = (int) Math.ceil(result);
        lastPage = students.size() % count == 0 ?students.size() / count : students.size() / count + 1;
        int toIndex = (currentPageNumber + 1) * count > students.size() ? students.size() : (currentPageNumber + 1) * count;
        System.out.println(students.size());
        System.out.println(count);
        //System.out.println(result);
        System.out.println(lastPage);

        List<Student> studentList = students.subList(currentPageNumber*count, toIndex);

        for (Student student : studentList) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(0, student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
            tableItem.setText(1, student.getStreet() + " " + student.getHome());
            tableItem.setText(2, student.getMobPhone());
            tableItem.setText(3, student.getHomePhone());

        }

        allWrites.setText("Total number of writes: " + students.size());
        allPages.setText("Pages at all: " + lastPage);
        currentPage.setText("Current page: " + (currentPageNumber + 1));

        table.redraw();
        super.redraw();
    }

    private void createColumn(Table table, String text, int width){
        TableColumn fioColumn = new TableColumn(table, SWT.CENTER);
        fioColumn.setText(text);
        fioColumn.setResizable(true);
        fioColumn.setWidth(width);
    }

    public void createTableForWrites() {

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
                insertWrites();
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

                insertWrites();
            }
        });

        Button buttonNextPage = new Button(this, SWT.PUSH);
        buttonNextPage.setBounds(330, 150, 100, 30);
        buttonNextPage.setText("NEXT");

        buttonNextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (table.getItems().length == count && currentPageNumber + 1 < lastPage){
                    currentPageNumber++;
                    insertWrites();
                }
            }
        });

        Button buttonLastPage = new Button(this, SWT.PUSH);
        buttonLastPage.setBounds(460, 150, 100, 30);
        buttonLastPage.setText("LAST");

        buttonLastPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                currentPageNumber = lastPage - 1;
                insertWrites();
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
                currentPageNumber = 0;
                insertWrites();
            }});

        allWrites.setBounds(50, 50, 200, 30);
        allPages.setBounds(50, 100, 150, 30);
        currentPage.setBounds(250, 100, 150, 30);
    }

    public void clear() {

        table.removeAll();

    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void insertWrites(List<Student> students) {
        setStudents(students);
        insertWrites();
    }
}

