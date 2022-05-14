/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidevelopment.bd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author Jackson
 */
public class HelperDb {

    public java.sql.Connection connection;
    private PreparedStatement consulta;
    public PreparedStatement consultaDelete;
    Statement statementGetForOrder;

    public HelperDb() {

    }

    public Connection conectar() {
        try {
            java.sql.Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "2208");
            System.out.println("Conexion exitosa");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public int pushClient(String nameClient, String lastName, String address, int age, float salary) throws SQLException {
        connection = conectar();
        try {
            consulta = connection.prepareStatement("INSERT INTO Clients (nameClient,lastName,address,age,salary) VALUES (?,?,?,?,?)");
            consulta.setString(1, nameClient);
            consulta.setString(2, lastName);
            consulta.setString(3, address);
            consulta.setInt(4, age);
            consulta.setFloat(5, salary);
            return consulta.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            return 0;
        }
    }

    public int pushArticles(String nameArticle, String mark, String model, float price, int amount) throws SQLException {
        connection = conectar();
        try {
            consulta = connection.prepareStatement("INSERT INTO Articles (nameArticle,mark,model,price,amount) VALUES (?,?,?,?,?)");
            consulta.setString(1, nameArticle);
            consulta.setString(2, mark);
            consulta.setString(3, model);
            consulta.setFloat(4, price);
            consulta.setInt(5, amount);
            return consulta.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            return 0;
        }
    }
    
    public int pushOrder(int codeClient, int codeArticle, int cantidadArticle, float price, float total, String dateOrder) throws SQLException {
        connection = conectar();
        try {
            consulta = connection.prepareStatement("INSERT INTO Orders (codeClient,codeArticle,cantidadArticle,price,total,dateOrder) VALUES (?,?,?,?,?,?)");
            consulta.setInt(1, codeClient);
            consulta.setInt(2, codeArticle);
            consulta.setInt(3, cantidadArticle);
            consulta.setFloat(4, price);
            consulta.setFloat(5, total);
            consulta.setString(6, dateOrder);
            return consulta.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            return 0;
        }
    }

    public ResultSet getForOrderClient() {
        connection = conectar();
        try {
            statementGetForOrder = connection.createStatement();
            return statementGetForOrder.executeQuery("SELECT * FROM Clients");
        } catch (SQLException ex) {
            return null;
        }
    }
    public ResultSet getForOrderArticles() {
        connection = conectar();
        try {
            statementGetForOrder = connection.createStatement();
            return statementGetForOrder.executeQuery("SELECT * FROM Articles");
        } catch (SQLException ex) {
            return null;
        }
        
    }
     public ResultSet getArticle(int id) {
        connection = conectar();
        try {
            statementGetForOrder = connection.createStatement();
            return statementGetForOrder.executeQuery("SELECT * FROM Articles WHERE codeArticle = " + id);
        } catch (SQLException ex) {
            return null;
        }
        
    }
}
