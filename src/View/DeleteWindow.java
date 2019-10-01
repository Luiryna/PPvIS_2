package View;

import Controller.Controller;

import Model.StudentsData;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

class DeleteWindow {
    private Shell shell;

    DeleteWindow(Display display, Controller controller, MainWindow mainWindow) {
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Delete window");
        shell.setSize(330, 790);

        Label labelText1 = new Label(shell, SWT.NONE);
        labelText1.setText("Enter surname");
        labelText1.setBounds(10, 10, 100, 30);

        Text text1 = new Text(shell, SWT.BORDER);
        text1.setBounds(10, 45, 100, 30);

        Label labelText12 = new Label(shell, SWT.NONE);
        labelText12.setText("Enter home or mobile phone");
        labelText12.setBounds(10, 80, 200, 30);

        Button radio1 = new Button(shell, SWT.RADIO);
        radio1.setText("Home");
        radio1.setBounds(10, 115, 200, 30);

        Button radio2 = new Button(shell, SWT.RADIO);
        radio2.setText("Mobile");
        radio2.setBounds(10, 140, 200, 30);

        Text text12 = new Text(shell, SWT.BORDER);
        text12.setBounds(10, 175, 100, 30);

        Button button = new Button(shell, SWT.NONE);
        button.setText("first delete");
        button.setBounds(10, 210, 100, 30);

        Label label2 = new Label(shell, SWT.NONE);
        label2.setText("Enter street and number of home");
        label2.setBounds(10, 245, 300, 30);

        Text text2 = new Text(shell, SWT.BORDER);
        text2.setBounds(10, 280, 100, 30);
        Text text22 = new Text(shell, SWT.BORDER);
        text22.setBounds(10, 315, 100, 30);

        Button radio21 = new Button(shell, SWT.RADIO);
        radio21.setText("Home");
        radio21.setBounds(10, 350, 100, 30);

        Button radio22 = new Button(shell, SWT.RADIO);
        radio22.setText("Mobile");
        radio22.setBounds(10, 385, 100, 30);

        Text text23 = new Text(shell, SWT.BORDER);
        text23.setBounds(10, 420, 100, 30);

        Button button2 = new Button(shell, SWT.NONE);
        button2.setText("second delete");
        button2.setBounds(10, 455, 100, 30);

        Label laber3 = new Label(shell, SWT.NONE);
        laber3.setText("Enter surname");
        laber3.setBounds(10, 490, 200, 30);

        Text text3 = new Text(shell, SWT.BORDER);
        text3.setBounds(10, 525, 100, 30);

        Label label33 = new Label(shell, SWT.NONE);
        label33.setText("Enter numerals of ph.number");
        label33.setBounds(10, 560, 300, 30);

        Button radio31 = new Button(shell, SWT.RADIO);
        radio31.setText("Home");
        radio31.setBounds(10, 595, 100, 30);

        Button radio32 = new Button(shell, SWT.RADIO);
        radio32.setText("Mobile");
        radio32.setBounds(10, 620, 100, 30);

        Text text32 = new Text(shell, SWT.BORDER);
        text32.setBounds(10, 655, 100, 30);

        Button button3 = new Button(shell, SWT.NONE);
        button3.setText("third delete");
        button3.setBounds(10, 690, 100, 30);

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

        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                int count = 0;

                if (radio21.getSelection()){
                    for (Student student : controller.SearchByAdresAndHomePhone(text2.getText(), text22.getText(), text23.getText())) {
                        controller.getStudents().remove(student);
                        count++;
                    }
                } else {
                    if (radio22.getSelection()) {
                        for (Student student : controller.SearchByAdresAndMobilePhone(text2.getText(), text22.getText(), text23.getText())) {
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

        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                int count = 0;

                if (radio31.getSelection()){
                    for (Student student : controller.SearchBySurnameAndNumeralsOfHomePhone(text3.getText(), text32.getText())) {
                        controller.getStudents().remove(student);
                        count++;
                    }
                } else {
                    if (radio32.getSelection()) {
                        for (Student student : controller.SearchBySurnameAndNumeralsOfMobilePhone(text3.getText(), text32.getText())) {
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

        shell.open();
    }

}