package View;

import Controller.Controller;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class DeleteWindow {
    private Shell shell;
    public Controller controller;

    public DeleteWindow(Display display, Controller controller, MainWindow mainWindow) {
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Delete window");
        shell.setSize(330, 600);
        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.marginTop = 10;
        shell.setLayout(rowLayout);
        Group group1 = new Group(shell, SWT.SHADOW_IN);
        group1.setText("first delete");
        group1.setLayout(new RowLayout(SWT.VERTICAL));

        Label labelText1 = new Label(group1, SWT.NONE);
        labelText1.setText("Enter surname");

        Text text1 = new Text(group1, SWT.BORDER);

        Label labelText12 = new Label(group1, SWT.NONE);
        labelText12.setText("Enter home or mobile phone");

        Button radio1 = new Button(group1, SWT.RADIO);
        radio1.setText("Home");

        Button radio2 = new Button(group1, SWT.RADIO);
        radio2.setText("Mobile");

        Text text12 = new Text(group1, SWT.BORDER);

        Button button = new Button(group1, SWT.NONE);
        button.setText("delete");

        Group group2 = new Group(shell, SWT.SHADOW_IN);
        group2.setText("second delete");
        group2.setLayout(new RowLayout(SWT.VERTICAL));

        Label label2 = new Label(group2, SWT.NONE);
        label2.setText("Enter phone number and adress");

        Text text2 = new Text(group2, SWT.BORDER);
        Text text22 = new Text(group2, SWT.BORDER);

        Button button2 = new Button(group2, SWT.NONE);
        button2.setText("delete");

        Group group3 = new Group(shell, SWT.SHADOW_IN);
        group3.setText("third delete");
        group3.setLayout(new RowLayout(SWT.VERTICAL));

        Label laber3 = new Label(group3, SWT.NONE);
        laber3.setText("Enter surname and numerals of ph.number");

        Text text3 = new Text(group3, SWT.BORDER);
        Text text32 = new Text(group3, SWT.BORDER);

        Button button3 = new Button(group3, SWT.NONE);
        button3.setText("delete");

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                int count = 0;

                if (radio1.getSelection()){
                    for (Student student : controller.SearchBySurnameAndHomePhone(text1.getText(), text12.getText())) {
                        controller.getStudents().remove(student);
                        count++;
                    }
                } else {
                    if (radio2.getSelection()) {
                        for (Student student : controller.SearchBySurnameAndMobilePhone(text1.getText(), text12.getText())) {
                            controller.getStudents().remove(student);
                            count++;
                        }
                    }
                }



                if (count == 0) {

                    MessageBox warning = new MessageBox(shell, SWT.COLOR_RED);
                    warning.setMessage("no items to delete");
                    warning.open();

                } else {

                    MessageBox warning1 = new MessageBox(shell, SWT.COLOR_RED);
                    warning1.setMessage(count + " items was deleted");
                    warning1.open();
                    mainWindow.redraw();
                    shell.close();

                }


            }
        });

        this.controller = controller;
        shell.open();
    }

}