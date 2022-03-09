/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import Model.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Phou8
 */
public class CategoryDao {
    public static void save(Category category){
        String query = "INSERT INTO category (name) VALUES ('" +category.getName()+ "')";
        DbOperations.setDataOrDelete(query, "Category added Succesfully");
    }
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void delete(String id){
        String query = "DELETE FROM category WHERE id='"+id+"'";
        DbOperations.setDataOrDelete(query, "Category Deleted Succesfully");
    }
}
