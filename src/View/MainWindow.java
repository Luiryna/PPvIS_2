package View;

import Controller.Controller;
import Model.StudentsData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.io.File;

public class MainWindow {

    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private Controller controller;
    private StudentsData studentsData = new StudentsData();
    private Pagination pagination;

    public MainWindow() {
        shell.setText("PPvIS 2");
        shell.setSize(750, 900);
        controller = new Controller(studentsData);
        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);

        MenuItem item1 = new MenuItem(menuBar, SWT.PUSH);
        item1.setText("&Open");

        item1.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                open();
            }

        });

        MenuItem item2 = new MenuItem(menuBar, SWT.PUSH);
        item2.setText("&Save");

        item2.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                save();
            }

        });

        MenuItem item3 = new MenuItem(menuBar, SWT.PUSH);
        item3.setText("&Add");

        item3.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                AddWindow addWindow = new AddWindow(display, controller, studentsData, MainWindow.this);
            }

        });

        MenuItem item4 = new MenuItem(menuBar, SWT.PUSH);
        item4.setText("&Search");

        item4.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                SearchWindow searchWindow = new SearchWindow(display, controller, studentsData);


            }

        });

        MenuItem item5 = new MenuItem(menuBar, SWT.PUSH);
        item5.setText("&Delete");

        item5.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {

                DeleteWindow deleteWindow = new DeleteWindow(display, studentsData, controller, MainWindow.this);

            }

        });


        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(50, 50, 100, 30);
        add.setText("add");
        Button search = new Button(shell, SWT.PUSH);
        search.setBounds(180, 50, 100, 30);
        search.setText("search");
        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(310, 50, 100, 30);
        delete.setText("delete");
        Button save = new Button(shell, SWT.PUSH);
        save.setBounds(440, 50, 100, 30);
        save.setText("save");

        Button open = new Button(shell, SWT.PUSH);
        open.setBounds(570, 50, 100, 30);
        open.setText("open");

        save.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                save();
            }
        });

        open.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                open();
            }
        });


        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                AddWindow addWindow = new AddWindow(display, controller, studentsData, MainWindow.this);
            }
        });

        search.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                SearchWindow searchWindow = new SearchWindow(display, controller, studentsData);
            }
        });

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DeleteWindow deleteWindow = new DeleteWindow(display, studentsData, controller, MainWindow.this);
            }
        });


        pagination = new Pagination(shell, SWT.NULL);
        pagination.createTableForWrites(studentsData, controller);
        pagination.setBounds(50, 150, 992, 600);



        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public void redraw(){
        pagination.clear();
        pagination.drawWrites(studentsData, controller);
    }
    private void save() {
        FileDialog fd = new FileDialog(shell, SWT.SAVE);
        fd.setText("Save");
        fd.setFilterPath("home:/");
        String[] filterExt = {"*.xml"};
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        controller.save(new File(selected));
    }

    private void open() {
        FileDialog fd = new FileDialog(shell, SWT.OPEN);
        fd.setText("open");
        fd.setFilterPath("home:/");
        String[] filterExt = {"*.xml"};
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        controller.open(new File(selected));
        pagination.clear();
        pagination.drawWrites(studentsData, controller);
    }


}