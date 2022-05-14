/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidevelopment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidevelopment.bd.HelperDb;
import pidevelopment.model.Articles;
import pidevelopment.model.Client;
import pidevelopment.model.Order;

/**
 *
 * @author Jackson
 */
public class PiDevelopment {

    public static HelperDb conectar;
    private static Client client;
    private static Articles articles;
    private static Order order;
    private static ResultSet result;

    public static void main(String[] args) {
        int option;
        boolean exit = true;
        while (exit) {
            do {
                option = menu();
            } while (option < 1 && option > 5);
            switch (option) {
                case 1 -> {
                    System.out.println("Ingresar cliente");
                    addClient();
                }
                case 2 -> {
                    System.out.println("Ingresar artículos");
                    addArticles();
                }
                case 3 -> {
                    System.out.println("Registrar pedidos");
                    registerOrder();
                }
                case 4 ->
                    exit = false;
                default ->
                    System.out.println("Opción inválida");
            }
        }
    }

    private static int menu() {
        System.out.println("Elija una opción");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Ingresar artículos");
        System.out.println("3. Registrar pedidos");
        System.out.println("4. Salir");
        int option = Leer.datoInt();
        return option;
    }

    public static void addArticles() {
        conectar = new HelperDb();
        articles = new Articles();
        System.out.println("\tIngrese los datos del artículo");
        System.out.print("Nombre: ");
        articles.setName(Leer.dato());
        System.out.print("Marca: ");
        articles.setMark(Leer.dato());
        System.out.print("Modelo: ");
        articles.setModel(Leer.dato());
        System.out.print("Precio: ");
        articles.setPrice(Leer.datoFloat());
        System.out.print("Cantidad: ");
        articles.setAmount(Leer.datoInt());
        int res;
        try {
            res = conectar.pushArticles(articles.getName(), articles.getMark(), articles.getModel(), articles.getPrice(), articles.getAmount());
            if (res > 0) {
                System.out.println("Datos ingresados correctamente");
            }
        } catch (SQLException e) {
            System.err.print("Error: " + e.getMessage());
        }
    }

    public static void addClient() {
        conectar = new HelperDb();
        client = new Client();
        System.out.println("\tIngrese los datos del cliente");
        System.out.print("Nombre: ");
        client.setName(Leer.dato());
        System.out.print("Apellido: ");
        client.setLastName(Leer.dato());
        System.out.print("Dirección: ");
        client.setAddress(Leer.dato());
        System.out.print("Edad: ");
        client.setAge(Leer.datoInt());
        System.out.print("Salario: ");
        client.setSalary(Leer.datoFloat());
        int res;
        try {
            res = conectar.pushClient(client.getName(), client.getLastName(), client.getAddress(), client.getAge(), client.getSalary());
            System.out.println(res);
            if (res > 0) {
                System.out.println("Datos ingresados correctamente");
            }
        } catch (SQLException e) {
            System.err.print("Error: " + e.getMessage());
        }
    }

    private static void registerOrder() {
        conectar = new HelperDb();
        order = new Order();
        try {
            showClients();
            System.out.print("Elija su idnetificador de cliente: ");
            order.setCodeClient(Leer.datoInt());

            showArticles();
            System.out.print("Elija el artículo usando el ID de este: ");
            order.setCodeArticle(Leer.datoInt());
            System.out.println(order.getCodeClient() + " - " + order.getCodeArticle());
            System.out.print("Cantidad: ");
            order.setAmountArticle(Leer.datoInt());
            result = conectar.getArticle(order.getCodeArticle());
            while (result.next()) {
                order.setPrice(result.getFloat("price"));
            }
            float total = order.getPrice() * order.getAmountArticle();
            order.setTotal(total);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            order.setDateOrder(dtf.format(LocalDateTime.now()));
            executeOrder();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void executeOrder() {
        int res;
        try {
            res = conectar.pushOrder(order.getCodeClient(), order.getCodeArticle(), order.getAmountArticle(), order.getPrice(), order.getTotal(), order.getDateOrder());
            System.out.println(res);
            if (res > 0) {
                System.out.println("Datos ingresados correctamente");
            } else {
                System.out.println("Ha ocurrido un problema. Asegúrese de que los datos son consistentes");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showClients() {
        result = conectar.getForOrderClient();
        System.out.println("Clientes registrados");
        System.out.format("%8s%16s%17s%18s\n", "ID", "Nombre", "Apellido", "Direccion");
        try {
            while (result.next()) {
                System.out.println("------------------------------------------------------------------------");
                System.out.format("%7d%18s%18s%14s\n", result.getInt("codeClient"), result.getString("nameClient"), result.getString("lastName"), result.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PiDevelopment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void showArticles() {
        result = conectar.getForOrderArticles();
        System.out.println("Artúculos registrados");
        System.out.format("%8s%16s%17s%18s%19s%28s\n", "Código", "Nombre", "Marca", "Modelo", "Precio", "Cantidad dsisponible");
        try {
            while (result.next()) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                System.out.format("%6d%19s%17s%21s%19s%15s\n", result.getInt("codeArticle"), result.getString("nameArticle"), result.getString("mark"), result.getString("model"), result.getFloat("price"), result.getInt("amount"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PiDevelopment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
