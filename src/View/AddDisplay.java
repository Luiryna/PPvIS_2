package View;

import Model.Info;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import Controller.Controller;

public class AddDisplay {
    private Display display;
    private Shell shell;
    private MainDisplay mainDisplay;
    private Info info;
    private Controller controller;

    public AddDisplay(Display display, Controller controller, Info info, MainDisplay mainDisplay) {
        this.controller = controller;
        this.mainDisplay = mainDisplay;
        this.info = info;
        this.display = display;
        shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Add display");
        shell.setSize(200, 650);
        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 50;
        rowLayout.marginTop = 50;
        shell.setLayout(rowLayout);
        initAddDisplay();
        shell.open();
    }

    private void initAddDisplay() {

        Label labelSurname = new Label(shell, SWT.NONE);
        labelSurname.setText("Enter surname");
        Text surname = new Text(shell, SWT.BORDER);

        Label labelName = new Label(shell, SWT.NONE);
        labelName.setText("Enter name");
        Text name = new Text(shell, SWT.BORDER);

        Label labelPatronymic = new Label(shell, SWT.NONE);
        labelPatronymic.setText("Enter patronymic");
        Text patronymic = new Text(shell, SWT.BORDER);

        Label labelStreet = new Label(shell, SWT.NONE);
        labelStreet.setText("Enter street");
        Text street = new Text(shell, SWT.BORDER);

        Label labelHome = new Label(shell, SWT.NONE);
        labelHome.setText("Enter home");
        Text home = new Text(shell, SWT.BORDER);

        Label labelMobile = new Label(shell, SWT.NONE);
        labelMobile.setText("Enter mob.ph.");
        Text mobPhone = new Text(shell, SWT.BORDER);

        Label labelHomePh = new Label(shell, SWT.NONE);
        labelHomePh.setText("Enter home ph.");
        Text homePhone = new Text(shell, SWT.BORDER);


        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(100, 230, 90, 30);
        add.setText("add");

        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Student student = new Student(surname.getText(), name.getText(), patronymic.getText(), street.getText(),
                        home.getText(), mobPhone.getText(), homePhone.getText());
                info.setStudent(student);

                surname.setText("");
                name.setText("");
                patronymic.setText("");
                street.setText("");
                home.setText("");
                mobPhone.setText("");
                homePhone.setText("");
            }
        });

    }

}
