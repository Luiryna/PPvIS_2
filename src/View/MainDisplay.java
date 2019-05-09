package View;

import Controller.Controller;
import Model.Info;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.io.File;

import static java.lang.String.valueOf;

public class MainDisplay {


    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private Controller controller;
    private Info info = new Info();
    private TableComposite tableComposite;


    public MainDisplay() {
        shell.setText("PPvIS 2");
        shell.setSize(750, 600);
        controller = new Controller(info);
        initFirstWindow();
        tableComposite = new TableComposite(shell, SWT.NULL);
        tableComposite.initTable(info, controller);
        tableComposite.setBounds(50, 150, 992, 400);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }


    private void initFirstWindow() {

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



            }

        });

        MenuItem item4 = new MenuItem(menuBar, SWT.PUSH);
        item4.setText("&Search");

        item4.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {




            }

        });

        MenuItem item5 = new MenuItem(menuBar, SWT.PUSH);
        item5.setText("&Delete");

        item5.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {



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
        Button update = new Button(shell, SWT.PUSH);
        update.setBounds(310, 100, 100, 30);
        update.setText("update");
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
                AddDisplay addDisplay = new AddDisplay(display, controller, info, MainDisplay.this);
            }
        });

        search.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                SearchDisplay searchDisplay = new SearchDisplay(display, controller, info);
            }
        });

        delete.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DeleteDisplay deleteDisplay = new DeleteDisplay(display, info, controller);
            }
        });

        update.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                tableComposite.clear();
                tableComposite.draw(info, controller);
            }
        });
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
        tableComposite.clear();
        tableComposite.draw(info, controller);
    }


}