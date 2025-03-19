package modul4;

import java.sql.Connection;
import modul4.DatabaseConnection;
import modul4.Controller.ProductController;
import modul4.View.ProductJframe;

public class Main {
    public static void main(String[] args) {
        ProductJframe view = new ProductJframe();
        
        ProductController control = new ProductController(view);

        view.setVisible(true);

        control.refreshTable();



    }
}