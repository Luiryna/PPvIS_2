package View;

import Controller.Controller;
import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class SearchWindow {
    private Shell shell;
    public Controller controller;
    private StudentsData studentsData;
    public Pagination pagination;
    StudentsData studentsData1 = new StudentsData();

    public SearchWindow(Display display, Controller controller, StudentsData studentsData) {
        this.studentsData = studentsData;
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Search window");
        shell.setSize(800, 800);
        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.marginTop = 10;
        shell.setLayout(rowLayout);
        Group group1 = new Group(shell, SWT.SHADOW_IN);
        group1.setText("first search");
        group1.setLayout(new RowLayout(SWT.VERTICAL));

        Label label = new Label(group1, SWT.NONE);
        label.setText("Enter surname and phone number");

        Text text1 = new Text(group1, SWT.BORDER);
        Text text12 = new Text(group1, SWT.BORDER);

        Button button = new Button(group1, SWT.NONE);
        button.setText("search");

        Group group2 = new Group(shell, SWT.SHADOW_IN);
        group2.setText("second search");
        group2.setLayout(new RowLayout(SWT.VERTICAL));

        Label label2 = new Label(group2, SWT.NONE);
        label2.setText("Enter phone number and adress");

        Text text2 = new Text(group2, SWT.BORDER);
        Text text22 = new Text(group2, SWT.BORDER);

        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("search");

        Group group3 = new Group(shell, SWT.SHADOW_IN);
        group3.setText("third search");
        group3.setLayout(new RowLayout(SWT.VERTICAL));

        Label laber3 = new Label(group3, SWT.NONE);
        laber3.setText("Enter surname and numerals of ph.number");

        Text text3 = new Text(group3, SWT.BORDER);
        Text text32 = new Text(group3, SWT.BORDER);

        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("search");
        //StudentsData studentsData1;

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //studentsData1 = new StudentsData();
                studentsData1.students = controller.firstSearch(text1.getText(), text12.getText());
                pagination.draw(studentsData1, controller);
                text1.setText("");
                text12.setText("");
            }
        });

        pagination = new Pagination(shell, SWT.NONE);
        this.controller = controller;
        pagination.initTable(studentsData1, controller);
        shell.open();
    }

}
