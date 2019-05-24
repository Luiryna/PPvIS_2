package View;

import Controller.Controller;
import Model.Student;
import Model.StudentsData;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class SearchWindow {
    public Controller controller;
    public Pagination pagination;

    public SearchWindow(Display display, Controller controller) {
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Search window");
        shell.setSize(620, 800);
        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.marginTop = 10;
        shell.setLayout(rowLayout);
        Group group1 = new Group(shell, SWT.SHADOW_IN);
        group1.setText("first search");
        group1.setLayout(new RowLayout(SWT.VERTICAL));

        Label labelText1 = new Label(group1, SWT.NONE);
        labelText1.setText("Enter surname");

        Text text1 = new Text(group1, SWT.BORDER);

        Button radio1 = new Button(group1, SWT.RADIO);
        radio1.setText("Home");

        Button radio2 = new Button(group1, SWT.RADIO);
        radio2.setText("Mobile");

        Text text12 = new Text(group1, SWT.BORDER);

        Label space = new Label(group1, SWT.NONE);
        space.setText("");

        Button button = new Button(group1, SWT.NONE);
        button.setText("search");

        Group group2 = new Group(shell, SWT.SHADOW_IN);
        group2.setText("second search");
        group2.setLayout(new RowLayout(SWT.VERTICAL));

        Label label2 = new Label(group2, SWT.NONE);
        label2.setText("Enter street and number of home");

        Text text2 = new Text(group2, SWT.BORDER);
        Text text22 = new Text(group2, SWT.BORDER);

        Button radio21 = new Button(group2, SWT.RADIO);
        radio21.setText("Home");

        Button radio22 = new Button(group2, SWT.RADIO);
        radio22.setText("Mobile");

        Text text23 = new Text(group2, SWT.BORDER);

        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("search");

        Group group3 = new Group(shell, SWT.SHADOW_IN);
        group3.setText("third search");
        group3.setLayout(new RowLayout(SWT.VERTICAL));

        Label laber3 = new Label(group3, SWT.NONE);
        laber3.setText("Enter surname");

        Text text3 = new Text(group3, SWT.BORDER);

        Label label33 = new Label(group3, SWT.NONE);
        label33.setText("Enter numerals of ph.number");

        Button radio31 = new Button(group3, SWT.RADIO);
        radio31.setText("Home");

        Button radio32 = new Button(group3, SWT.RADIO);
        radio32.setText("Mobile");

        Text text32 = new Text(group3, SWT.BORDER);

        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("search");
        //StudentsData studentsData1;

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //studentsData1 = new StudentsData();
                List<Student> students;
                if (radio1.getSelection()) {
                students = controller.SearchBySurnameAndHomePhone(text1.getText(), text12.getText());
                pagination.insertWrites(students);
                    if (students.size() == 0){
                        MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                        alert.setMessage("no items founded");
                        alert.open();
                    }
                } else {
                    if (radio2.getSelection()) {
                        students = controller.SearchBySurnameAndMobilePhone(text1.getText(), text12.getText());
                        pagination.insertWrites(students);
                        if (students.size() == 0){
                            MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                            alert.setMessage("no items founded");
                            alert.open();
                        }
                    } else {}
                }


            }
        });

        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //studentsData1 = new StudentsData();
                List<Student> students;
                if (radio21.getSelection()) {
                    students = controller.SearchByAdresAndHomePhone(text2.getText(), text22.getText(), text23.getText());
                    pagination.insertWrites(students);
                    if (students.size() == 0){
                        MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                        alert.setMessage("no items founded");
                        alert.open();
                    }
                    } else {
                    if (radio22.getSelection()) {
                        students = controller.SearchByAdresAndMobilePhone(text2.getText(), text22.getText(), text23.getText());
                        pagination.insertWrites(students);
                        if (students.size() == 0){
                            MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                            alert.setMessage("no items founded");
                            alert.open();
                        }

                    } else {}
                }

            }
        });

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                //studentsData1 = new StudentsData();
                List<Student> students;
                if (radio31.getSelection()) {
                    students = controller.SearchBySurnameAndNumeralsOfHomePhone(text3.getText(), text32.getText());
                    pagination.insertWrites(students);
                    if (students.size() == 0){
                        MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                        alert.setMessage("no items founded");
                        alert.open();
                    }
                } else {
                    if (radio32.getSelection()) {
                        students = controller.SearchBySurnameAndNumeralsOfMobilePhone(text3.getText(), text32.getText());
                        pagination.insertWrites(students);
                        if (students.size() == 0){
                            MessageBox alert = new MessageBox(shell, SWT.COLOR_RED);
                            alert.setMessage("no items founded");
                            alert.open();
                        }
                    } else {}
                }


            }
        });

        pagination = new Pagination(shell, SWT.NONE);
        this.controller = controller;
        pagination.createTableForWrites();
        shell.open();
    }

}
