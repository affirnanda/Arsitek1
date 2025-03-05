package src.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;



public class PersonView extends JFrame {
    private JTextField textfirstname = new JTextField(10);
    private JTextField textlastname = new JTextField(10);
    private JTextField textidNumber = new JTextField(10);
    private JButton btnsave = new JButton("save");
    private JButton btndelete= new JButton("delete");
    private JButton btnupdate = new JButton("update");
    private JTable table;
    private DefaultTableModel tableModel;


    
    public PersonView () {
        setTitle("Java Gui Mvc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        //staar panel input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput.add(new JLabel("First name"));
        panelInput.add(textfirstname);
        //untukfirst name

        panelInput.add(new JLabel("Last name"));
        panelInput.add(textlastname);
        //untuk lastname

        panelInput.add(new JLabel("NIM"));
        panelInput.add(textidNumber);
        //untuk menginput id number atau nim

        JPanel panelButton =new JPanel();
        panelButton.add(btnsave);
        panelButton.add(btndelete);
        panelButton.add(btnupdate);
        //End - panel input

        //start table
        tableModel = new DefaultTableModel(
                new String[] {"first name", "last name", "NIM"}, 
                0);


        table = new JTable(tableModel);
        JScrollPane tabelScrollPane = new JScrollPane(table);
        //end table 

        //add component to Jframe 
        add(panelInput, BorderLayout.NORTH); //atas
        add(panelButton, BorderLayout.CENTER); //tengah 
        add(tabelScrollPane, BorderLayout.SOUTH); // bawah 

    }

    //start Getter and Setter button
    public String getfirstname() {
        return textfirstname.getText();
    }
    public String getlastname() {
        return textlastname.getText();
    }
    public String getidNumber() {
        return textidNumber.getText();
    }

    public void setfirstname(String firstname) {
        textfirstname.setText(firstname);
    }
    public void setlastname(String lastname) {
        textlastname.setText(lastname);
    }
    public void setidNumber(String idNumber) {
        textidNumber.setText(idNumber);
    }

    public void addPersontoTable(String firstname, String lastname, String idNumber) {
        tableModel.addRow(new Object[] {firstname, lastname, idNumber});
    }

    public void addSaveListener(ActionListener listener){
        btnsave.addActionListener(listener);
    }
    public void addDeleteListener(ActionListener listener){
        btndelete.addActionListener(listener);
    }
    public void addUpdateListener(ActionListener listener){
        btnupdate.addActionListener(listener);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public void removeSelectedRow (int index) {
        tableModel.removeRow(index);
    }
    //End Getter and Setter button 
}
