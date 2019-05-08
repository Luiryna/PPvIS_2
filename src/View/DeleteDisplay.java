package View;

import Controller.Controller;

import Model.info;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;
import org.eclipse.widgets.TableComposite;

import static java.lang.String.valueOf;

public class DeleteDisplay {
    Display display;
    info info;
    Controller controller;
    private Shell shell;
    public TableComposite tableComposite;

    public DeleteDisplay(Display display, info info, Controller controller) {
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        this.info = info;
        this.controller = controller;
        shell.setBackground(gray);
        shell.setText("Delete window");
        shell.setSize(1200, 800);
        tableComposite = new TableComposite(shell, SWT.NONE);
        tableComposite.initTable(info, controller);
        tableComposite.setBounds(50, 200, 992, 500);
        initSearhDisplay();
        shell.open();
    }

    private void initSearhDisplay() {

        Text surname = new Text(shell, SWT.CHECK);
        surname.setBounds(10, 40, 180, 30);

        Label surnameText = new Label(shell, SWT.NONE);
        surnameText.setText("surname");
        surnameText.setBounds(200, 40, 50, 30);

        Text groupNumber = new Text(shell, SWT.CHECK);
        groupNumber.setBounds(10, 90, 80, 30);

        Label groupNumberText = new Label(shell, SWT.NONE);
        groupNumberText.setText("group number");
        groupNumberText.setBounds(100, 90, 100, 30);

        Text surname1 = new Text(shell, SWT.CHECK);
        surname1.setBounds(350, 40, 180, 30);

        Label surnameText1 = new Label(shell, SWT.NONE);
        surnameText1.setText("surname");
        surnameText1.setBounds(560, 40, 180, 30);

        Combo typeOfMissing = new Combo(shell, SWT.READ_ONLY);
        typeOfMissing.setBounds(350, 90, 180, 30);
        typeOfMissing.add("due disease");
        typeOfMissing.add("without reason");
        typeOfMissing.add("due other reason");

        Label typeOfMissingText = new Label(shell, SWT.NONE);
        typeOfMissingText.setText("Type of missings");
        typeOfMissingText.setBounds(560, 90, 180, 30);

        Text surname2 = new Text(shell, SWT.CHECK);
        surname2.setBounds(700, 40, 180, 30);

        Label surname2Text = new Label(shell, SWT.NONE);
        surname2Text.setText("Surname");
        surname2Text.setBounds(890, 40, 180, 30);

        Text countMissings = new Text(shell, SWT.NONE);
        countMissings.setBounds(700, 110, 180, 30);

        Combo typeOfMissing1 = new Combo(shell, SWT.READ_ONLY);
        typeOfMissing1.setBounds(700, 80, 180, 30);
        typeOfMissing1.add("due disease");
        typeOfMissing1.add("without reason");
        typeOfMissing1.add("due other reason");


        Label countMissingsText = new Label(shell, SWT.NONE);
        countMissingsText.setText("Count missings");
        countMissingsText.setBounds(890, 90, 180, 30);

        Button delete1 = new Button(shell, SWT.PUSH);
        delete1.setText("Delete");
        delete1.setBounds(10, 145, 80, 30);

        Button delete2 = new Button(shell, SWT.PUSH);
        delete2.setText("Delete");
        delete2.setBounds(350, 145, 180, 30);

        Button delete3 = new Button(shell, SWT.PUSH);
        delete3.setText("Delete");
        delete3.setBounds(700, 145, 180, 30);

        delete1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (controller.find1Student(surname.getText(), Integer.parseInt(groupNumber.getText())).size() == 0) {
                    new MessageBox(shell);
                } else {
                    for (Student student : controller.find1Student(surname.getText(), Integer.parseInt(groupNumber.getText()))) {
                        tableComposite.draw(info, controller);
                        info.getStudents().remove(student);
                    }
                    surname.setText("");
                    groupNumber.setText("");
                }
            }
        });

        delete2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                for (Student student : controller.find2Student(surname1.getText(), typeOfMissing.getText())) {
                    tableComposite.draw(info, controller);
                    info.getStudents().remove(student);
                }
                surname1.setText("");
                typeOfMissing.setText("");
            }
        });

        delete3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                for (Student student : controller.find3Student(surname2.getText(), typeOfMissing1.getText(), Integer.parseInt(countMissings.getText()))) {
                    tableComposite.draw(info, controller);
                    info.getStudents().remove(student);
                }
                surname2.setText("");
                typeOfMissing1.setText("");
            }
        });
    }
}