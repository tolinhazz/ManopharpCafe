/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import Model.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Phou8
 */
public class ProductDao {

    public static void save(Product product) {
        String query = "INSERT INTO product(name, category, price) VALUES('" + product.getName() + "', '" + product.getCategory() + "', '" + product.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void update(Product product) {
        String query = "UPDATE product SET name = '" + product.getName() + "', category = '" + product.getCategory() + "', price = '" + product.getPrice() + "' WHERE id = '" + product.getId() + "'";
        DbOperations.setDataOrDelete(query, "Product Updated Successfully");
    }

    public static void delete(String id) {
        String query = "DELETE FROM product WHERE id = '" + id + "'";
        DbOperations.setDataOrDelete(query, "Product Deleted Successfully");
    }

    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE category = '" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static ArrayList<Product> filterProductByName(String name, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name LIKE '%" + name + "%' and category = '" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static Product getProductByName(String name) {
        Product product = new Product();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name = '"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
