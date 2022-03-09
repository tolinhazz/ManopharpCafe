/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import Model.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Phou8
 */
public class UserDao {
    public static void save(User user){
        String query = "INSERT INTO user(name, email, Phone, address, password, securityQuestion, answer, status) VALUES('"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPhone()+"', '"+user.getAddress()+"', '"+user.getPassword()+"', '"+user.getSecurityQuestion()+"', '"+user.getAnswer()+"', 'false')";
        DbOperations.setDataOrDelete(query, "Register Successfully! Wait for Admin Approval!");
    }
    
    public static User login(String email, String password){
        User user = null; 
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '"+email+"' and password = '"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null; 
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '" +email+ "'");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email, String newPassword){
        String query = "UPDATE user SET password = '" + newPassword + "' WHERE email = '" +email+ "' ";
        DbOperations.setDataOrDelete(query, "Password has been changed");
    }
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("Phone"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void changeStatus(String email, String status){
        String query = "UPDATE user SET status = '"+status+"' WHERE email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "Status Changed Successfully");
    }
    public static void changePassword(String email, String oldPassword, String newPassword){
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '"+email+"' AND password = '"+oldPassword+"'");
            if(rs.next())
                update(email, newPassword);
            else
                JOptionPane.showMessageDialog(null, "Old Password is Wrong!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer){
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '"+email+"' AND password = '"+password+"'");
            if(rs.next()){
                update(email, securityQuestion, answer);
            }else
                JOptionPane.showMessageDialog(null, "Password is Wrong!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email, String securityQuestion, String answer){
        String query = "UPDATE user SET securityQuestion ='"+securityQuestion+"',answer='"+answer+"' WHERE email='"+email+"'";
        DbOperations.setDataOrDelete(query, "Security Question has been Changed");
    }
}
