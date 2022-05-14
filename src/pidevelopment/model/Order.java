/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidevelopment.model;

/**
 *
 * @author Jackson
 */
public class Order{
    private int codeClient;
    private int codeArticle;
    private int amountArticle;
    private float price;
    private float total;
    private String dateOrder;
    
    public Order(){
        
    }
    
    public Order(int codeClient, int codeArticle, int amountArticle, float price, float total, String dateOrder){
        this.codeClient = codeClient;
        this.codeArticle = codeArticle;
        this.amountArticle = amountArticle;
        this.price = price;
        this.total = total;
        this.dateOrder = dateOrder;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public int getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }

    public int getAmountArticle() {
        return amountArticle;
    }

    public void setAmountArticle(int amountArticle) {
        this.amountArticle = amountArticle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }
    
}
