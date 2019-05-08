package View;

import Controller.Controller;
import Model.info;
import Model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;
import org.eclipse.widgets.TableComposite;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import static java.lang.String.valueOf;

public class MainDisplay {


    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
    private Controller controller;
    private info info = new info();
    private int count = 0;
    private TableComposite tableComposite;


    public MainDisplay() {

        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        shell.setBackground(gray);
        shell.setText("PPvIS 2");
        shell.setSize(1100, 890);
        controller = new Controller(info);
        initFirstWindow();
        tableComposite = new TableComposite(shell, SWT.NULL);
        tableComposite.initTable(info, controller);
        tableComposite.setBounds(50, 200, 992, 600);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private void initFirstWindow() {

        Button add = new Button(shell, SWT.PUSH);
        add.setBounds(50, 100, 100, 30);
        add.setText("add");
        Button search = new Button(shell, SWT.PUSH);
        search.setBounds(170, 100, 100, 30);
        search.setText("search");
        Button delete = new Button(shell, SWT.PUSH);
        delete.setBounds(290, 100, 100, 30);
        delete.setText("delete");
        Button save = new Button(shell, SWT.PUSH);
        save.setBounds(410, 100, 100, 30);
        save.setText("save");
        Button update = new Button(shell, SWT.PUSH);
        update.setBounds(700, 100, 100, 30);
        update.setText("update");

        Button load = new Button(shell, SWT.PUSH);
        load.setBounds(530, 100, 100, 30);
        load.setText("load");

        save.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog fd = new FileDialog(shell, SWT.SAVE);
                fd.setText("Save");
                fd.setFilterPath("C:\\Users\\vlads\\IdeaProjects\\ppvis4Sem\\SecondLab");
                String[] filterExt = {"*.xml"};
                fd.setFilterExtensions(filterExt);
                String selected = fd.open();
                controller.save(new File(selected));
            }
        });

        load.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                FileDialog fd = new FileDialog(shell, SWT.SAVE);
                fd.setText("open");
                fd.setFilterPath("home:/");
                String[] filterExt = {"*.xml"};
                fd.setFilterExtensions(filterExt);
                String selected = fd.open();
                controller.open(new File(selected));
                tableComposite.clear();
                count = 5;
                info.setMetka(count);
                tableComposite.draw(info, controller);
            }
        });

        add.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                count++;
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
}