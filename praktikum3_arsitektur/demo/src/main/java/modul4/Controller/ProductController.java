package modul4.Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

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
        double Price = view.getProductPrice();
    }

    public void updateProduct(){
        String name = view.getProductname();
        double Price = view.getProductPrice();
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1){
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0 ).toString());
        }
    }

    public void deleteProduct(){
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1){
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0 ).toString());
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


}
