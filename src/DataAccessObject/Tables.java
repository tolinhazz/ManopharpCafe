/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import javax.swing.JOptionPane;

/**
 *
 * @author Phou8
 */
public class Tables {
    public static void main (String[] args){
        try{
            String userTable = "CREATE TABLE user(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), email VARCHAR(200), Phone VARCHAR(200), address VARCHAR(200), password VARCHAR(200), securityQuestion VARCHAR(200), answer VARCHAR(200), status VARCHAR(20), UNIQUE (email))";
            String adminDetails = "INSERT INTO user(name, email, Phone, address, password, securityQuestion, answer, status) VALUES('Admin', 'admin@gmail.com', '02077771111', 'Laos', 'admin', 'What primary school did you attend?', 'ABC', 'true')";
            String categoryTable = "CREATE TABLE category(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200))";
            String productTable = "CREATE TABLE product(id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), category VARCHAR(200), price VARCHAR(200))";
            String billTable = "CREATE TABLE bill(id int PRIMARY KEY, name VARCHAR(200), Phone VARCHAR(200), email VARCHAR(200), date VARCHAR(50), total VARCHAR(200), createdBy VARCHAR(200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
            DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
            DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
