package modul4.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modul4.Model.Product;
import modul4.DatabaseConnection;

public class ProductDAO {

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            // System.out.println("ResultSet rs " + rs);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return products;
    }


    public int addProduct(Product product) {
        int resultcount = 0;
        String query = "INSERT INTO product (name, price) VALUES ("
                + "'" + product.getName() + "' "
                + ", " + product.getPrice() + ") ";
        Statement stmnt;
        try (Connection conn = DatabaseConnection.getConnection()) {
            stmnt = conn.createStatement();
            resultcount = stmnt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultcount = -1;
        }
        return resultcount;
    }

    public int updateProduct(Product product) {
        int resultcount = 0;
        String query = "UPDATE product SET"
                + " name ='" + product.getName() + "' "
                + ", price=" + product.getPrice() + " "
                + "WHERE id=" + product.getId();
        Statement stmnt;
        try (Connection conn = DatabaseConnection.getConnection()) {
            stmnt = conn.createStatement();
            resultcount = stmnt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultcount = -1;
        }
        return resultcount;
    }

    public int deleteProduct(int productId) {
        int resultcount = 0;
        String query = "DELETE FROM product where id=" + productId;
        Statement stmnt;
        try (Connection conn = DatabaseConnection.getConnection()) {
            stmnt = conn.createStatement();
            resultcount = stmnt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultcount = -1;
        }
        return resultcount;
    }


  




}
