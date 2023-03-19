package nyamick.view;
import nyamick.MyTableModel;
import nyamick.State;
import nyamick.data.Organization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainWindow extends  JFrame{
    private  final JTable jTable;
    private final MyTableModel myTableModel;
    private final JTextField nameField;
    private final JComboBox orgType;
    private final JTextField actField;
    State state;

    public MainWindow() {
        super("Companies");
        myTableModel = new MyTableModel(new Organization("organization") {
            @Override
            public String processOperation() {
                return null;
            }
        });
        jTable = new JTable();
        jTable.setModel(myTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        JButton buttonDelete = new JButton("Удалить организацию");
        buttonDelete.addActionListener(e -> {
            try {
                myTableModel.delete(jTable.getSelectedRow());
            }
            catch (IndexOutOfBoundsException ex){
                JDialog jDialog = new JDialog(MainWindow.this,"Выделите строку" , true);
                jDialog.setLocationRelativeTo(null);
                jDialog.setVisible(true);
            }
        });
        String [] orgs = {"Insurance Company", "Shipbuilding Company", "Aircraft Factory"};

        orgType = new JComboBox(orgs);

        nameField = new JTextField();
        nameField.setText("Название организации:");

        JButton buttonAdd = new JButton("Добавить запись");
        buttonAdd.addActionListener(e -> {
            String type = orgType.getSelectedItem().toString();
            myTableModel.add(nameField.getText(), type);
        });


        JButton doAct = new JButton("Выполнить действие");
        doAct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actField.setText(myTableModel.doActivity(jTable.getSelectedRow()));
            }
        });
        JButton find = new JButton("Поиск");
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null, myTableModel.find(nameField.getText()));
            }
        });

        actField = new JTextField("Выполненное действие");
        actField.setEditable(false);

        JPanel panel = new JPanel();
        JPanel panelR = new JPanel();

        this.add(jScrollPane);
        panel.setLayout(new FlowLayout());
        panelR.setLayout(new GridLayout(2,1));
        panel.add(buttonAdd);
        panel.add(orgType);
        panel.add(nameField);
        panel.add(buttonDelete);
        panel.add(find);

        panelR.add(doAct);
        panelR.add(actField);
        this.add(panelR, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.pack();
        setVisible(true);


    }


}
