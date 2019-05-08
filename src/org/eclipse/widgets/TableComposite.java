package org.eclipse.widgets;

import Model.Student;
import Model.info;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import Controller.Controller;

import static java.lang.String.valueOf;

public class TableComposite extends Composite {
    public Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION |
            SWT.V_SCROLL | SWT.H_SCROLL);

    public TableComposite(Composite composite, int i) {
        super(composite, i);
    }

    public void draw(info info, Controller controller) {

        for (Student student : info.getStudents()) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(1, String.valueOf(student.getGroupNumb()));
            tableItem.setText(0, student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
            tableItem.setText(2, String.valueOf(student.getMissingDueDisease()));
            tableItem.setText(5, valueOf(controller.countMissings(student)));
            tableItem.setText(3, String.valueOf(student.getMissingDueOtherReason()));
            tableItem.setText(4, String.valueOf(student.getMissingWithoutReason()));
        }


    }

    public void draw(int start, int end, info info, Controller controller) {
        for (Student student : info.getStudents().subList(start, end)) {
            TableItem tableItem = new TableItem(table, SWT.PUSH);
            tableItem.setText(1, String.valueOf(student.getGroupNumb()));
            tableItem.setText(0, student.getSurname() + student.getName() + student.getPatronymic());
            tableItem.setText(2, String.valueOf(student.getMissingDueDisease()));
            tableItem.setText(4, String.valueOf(student.getMissingWithoutReason()));
            tableItem.setText(3, String.valueOf(student.getMissingDueOtherReason()));
            tableItem.setText(5, valueOf(controller.countMissings(student)));
        }
    }

    public void initTable(info info, Controller controller) {

        table.setBounds(50, 50, 892, 300);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);






        TableColumn fioColumn = new TableColumn(table, SWT.LEFT);
        fioColumn.setText("student's FIO");
        fioColumn.setResizable(true);
        fioColumn.setWidth(300);



        TableColumn groupColumn = new TableColumn(table, SWT.CENTER);
        groupColumn.setText("group number");
        groupColumn.setResizable(true);
        groupColumn.setWidth(220);

        TableColumn studentsMisses = new TableColumn(table, SWT.RIGHT);
        studentsMisses.setText("disease");
        studentsMisses.setResizable(true);
        studentsMisses.setWidth(80);

        TableColumn studentsMisses1 = new TableColumn(table, SWT.RIGHT);
        studentsMisses1.setText("other reasons");
        studentsMisses1.setResizable(true);
        studentsMisses1.setWidth(110);

        TableColumn studentMisses2 = new TableColumn(table, SWT.RIGHT);
        studentMisses2.setText("without reason");
        studentMisses2.setResizable(true);
        studentMisses2.setWidth(130);

        TableColumn studentsMisses3 = new TableColumn(table, SWT.RIGHT);
        studentsMisses3.setText("all");
        studentsMisses3.setResizable(true);
        studentsMisses3.setWidth(50);








    }

    public void clear() {
        table.removeAll();
    }
}

