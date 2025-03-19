package modul4.Controller;

import java.util.List;

import javax.swing.JOptionPane;
// import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modul4.DAO.ProductDAO;
import modul4.Model.Product;
import modul4.View.ProductJframe;


public class ProductController {
    
    private ProductJframe view;
    private ProductDAO productDAO = new ProductDAO();

    public ProductController(ProductJframe view){
        this.view = view;
        refreshTable();
    }

    public void addProduct(){
        String name = view.getProductname();
        double price = view.getProductPrice();
        Product product = new Product(0, name, price);
        product.setName(name);
        product.setPrice(price);
        productDAO.addProduct(product); // Panggil method DAO untuk menyimpan data
        refreshTable(); // Refresh tabel setelah menambahkan data
    }
    
    public void updateProduct(){
        String name = view.getProductname();
        double price = view.getProductPrice();
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1){
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0).toString());
            Product product = new Product(id, name, price);
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            productDAO.updateProduct(product); // Panggil method DAO untuk memperbarui data
            refreshTable(); // Refresh tabel setelah memperbarui data
        }
    }
    
    public void deleteProduct(){
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1){
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0).toString());
            productDAO.deleteProduct(id); // Panggil method DAO untuk menghapus data
            refreshTable(); // Refresh tabel setelah menghapus data
        }
    }


    public void refreshTable(){
        List<Product> products = productDAO.getAllProduct();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        for (Product p : products){
            model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice()});
        }
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getProductname().isEmpty() || view.getProductPrice() == 0.0) {
                JOptionPane.showMessageDialog(view, "Data Tidak boleh Kosong");
                return;
            }
            addProduct();
            view.setProductField("", "");
        }
    }

    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Please Select a row to Update");
                return;
            }
            updateProduct();
        }
    }

    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Please Select a row to Delete");
                return;
            }
            deleteProduct();
        }
    }

}
