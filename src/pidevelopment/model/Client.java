/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidevelopment.model;

/**
 *
 * @author Jackson
 */
public class Client {
    private String name;
    private String lastName;
    private String address;
    private int age;
    private float salary;
    
    public Client(){
        
    }
    
    public Client(String name, String lastName, String address, int age, float salary){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
}
