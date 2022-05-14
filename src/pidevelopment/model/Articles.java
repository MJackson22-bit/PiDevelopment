/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidevelopment.model;

/**
 *
 * @author Jackson
 */
public class Articles {
    private String name;
    private String mark;
    private String model;
    private float price;
    private int amount;
    
    public Articles(String name, String mark, String model, float price, int amount){
        this.name = name;
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public Articles(){
        
    }
    
    
}
