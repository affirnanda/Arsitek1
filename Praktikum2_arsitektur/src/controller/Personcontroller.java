package src.controller;

// import src.controller.Personcontroller.saveListener.deleteListener;
import src.view.PersonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Personcontroller {
    private PersonView view;

    public Personcontroller(PersonView view) {
        this.view = view;

        this.view.addSaveListener(new saveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addUpdateListener(new UpdateListener());
    }

    class saveListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String firstname = view.getfirstname();
            String lastname = view.getlastname();
            String idNumber = view.getidNumber();

            if (firstname.isEmpty() || lastname.isEmpty() || idNumber.isEmpty()) {
                JOptionPane.showMessageDialog(view, "data ttidak ada");
                return;
            }

            view.addPersontoTable(firstname, lastname, idNumber);
            view.setfirstname("");
            view.setlastname("");
            view.setidNumber("");
        }
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int selectedRow = view.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih table yang ingin dihapus");
                return;
            }
            view.removeSelectedRow(selectedRow);
        }
    }

    class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int selectedRow = view.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih table yang ingin diupdate");
                return;
            }
            String firstname = view.getfirstname();
            String lastname = view.getlastname();
            String idNumber = view.getidNumber();

            view.removeSelectedRow(selectedRow);
            view.addPersontoTable(firstname, lastname, idNumber);
        }
    }
}