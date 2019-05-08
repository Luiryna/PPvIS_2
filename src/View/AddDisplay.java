package View;

import Model.info;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

import static java.lang.String.valueOf;

import Controller.Controller;

public class AddDisplay {
    private Display display;
    private Shell shell;
    private MainDisplay mainDisplay;
    private info info;
    private Controller controller;

    public AddDisplay(Display display, Controller controller, info info, MainDisplay mainDisplay) {
        this.controller = controller;
        this.mainDisplay = mainDisplay;
        this.info = info;
        this.display = display;
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        shell.setBackground(gray);
        shell.setText("Center");
        shell.setSize(550, 400);
        initAddDisplay();
        shell.open();
    }

    private void initAddDisplay() {

        Text surname = new Text(shell, SWT.CHECK);
        surname.setBounds(10, 40, 180, 30);

        Label surnameText = new Label(shell, SWT.NONE);
        surnameText.setText("Surname");
        surnameText.setBounds(200, 40, 50, 20);

        Text name = new Text(shell, SWT.CHECK);
        name.setBounds(10, 80, 180, 30);

        Label nameText = new Label(shell, SWT.NONE);
        nameText.setText("Name");
        nameText.setBounds(200, 80, 50, 20);

        Text patronymic = new Text(shell, SWT.CHECK);
        patronymic.setBounds(10, 120, 180, 30);

        Label patronymicText = new Label(shell, SWT.NONE);
        patronymicText.setText("Patronymic");
        patronymicText.setBounds(200, 120, 50, 20);

        Text groupNumber = new Text(shell, SWT.CHECK);
        groupNumber.setBounds(10, 190, 80, 30);

        Label groupNumberText = new Label(shell, SWT.NONE);
        groupNumberText.setText("group number");
        groupNumberText.setBounds(100, 190, 100, 30);


        Text absenceWithoutReason = new Text(shell, SWT.CHECK);
        absenceWithoutReason.setBounds(270, 40, 50, 30);

        Label absenceWithoutReasonText = new Label(shell, SWT.NONE);
        absenceWithoutReasonText.setText("absences without" + "\n" + "any reason");
        absenceWithoutReasonText.setBounds(330, 40, 200, 50);

        Text absenceByDisease = new Text(shell, SWT.CHECK);
        absenceByDisease.setBounds(270, 90, 50, 30);

        Label absenceByDiseaseText = new Label(shell, SWT.NONE);
        absenceByDiseaseText.setText("absences by disease");
        absenceByDiseaseText.setBounds(330, 90, 200, 50);

        Text absenceByOtherReason = new Text(shell, SWT.CHECK);
        absenceByOtherReason.setBounds(270, 140, 50, 30);

        Label absenceByOtherReasonText = new Label(shell, SWT.NONE);
        absenceByOtherReasonText.setText("absences by other reason");
        absenceByOtherReasonText.setBounds(330, 160, 200, 50);

        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(100, 230, 90, 30);
        add.setText("add");

        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Student student = new Student(surname.getText(), name.getText(), patronymic.getText(), Integer.parseInt(groupNumber.getText()),
                        Integer.parseInt(absenceByDisease.getText()), Integer.parseInt(absenceByOtherReason.getText()),
                        Integer.parseInt(absenceWithoutReason.getText()));
                info.setStudent(student);

                surname.setText("");
                name.setText("");
                patronymic.setText("");
                groupNumber.setText("");
                absenceByDisease.setText("");
                absenceByOtherReason.setText("");
                absenceWithoutReason.setText("");
            }
        });

    }

}
