package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import Controller.Controller;

class AddWindow {

    AddWindow(Display display, Controller controller, MainWindow mainWindow) {
        Shell shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
        shell.setText("Add display");
        shell.setSize(200, 650);
        RowLayout rowLayout = new RowLayout();
        rowLayout.spacing = 10;
        rowLayout.marginLeft = 50;
        rowLayout.marginTop = 50;
        shell.setLayout(rowLayout);
        Label labelSurname = new Label(shell, SWT.NONE);
        labelSurname.setText("Enter name");
        Text surname = new Text(shell, SWT.BORDER);

        Label labelName = new Label(shell, SWT.NONE);
        labelName.setText("Enter surname");
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
        add.setBounds(100, 300, 90, 30);
        add.setText("add");

        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                controller.addStudent(surname.getText(), name.getText(), patronymic.getText(), street.getText(),
                     home.getText(), mobPhone.getText(), homePhone.getText());

                surname.setText("");
                name.setText("");
                patronymic.setText("");
                street.setText("");
                home.setText("");
                mobPhone.setText("");
                homePhone.setText("");

                mainWindow.redraw();
            }
        });
        shell.open();
    }

}
