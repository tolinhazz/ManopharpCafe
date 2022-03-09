/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import Model.Bill;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Phou8
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
           ResultSet rs = DbOperations.getData("SELECT MAX(id) FROM bill");
           if(rs.next()){
               id = rs.getInt(1);
               id = id + 1;
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    public static void save(Bill bill){
        String query = "INSERT INTO bill VALUES('"+bill.getId()+"', '"+bill.getName()+"', '"+bill.getPhone()+"', '"+bill.getEmail()+"', '"+bill.getDate()+"', '"+bill.getTotal()+"', '"+bill.getCreatedBy()+"')";
        DbOperations.setDataOrDelete(query, "Bill Details Added Succesfully");
    }
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%"+date+"%'");
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setPhone(rs.getString("Phone"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString("date"));
            bill.setTotal(rs.getString("total"));
            bill.setCreatedBy(rs.getString("createdBy"));
            arrayList.add(bill);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
        public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%"+date+"%' ORDER BY id DESC");
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setPhone(rs.getString("Phone"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString("date"));
            bill.setTotal(rs.getString("total"));
            bill.setCreatedBy(rs.getString("createdBy"));
            arrayList.add(bill);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
