/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/**
 *
 * @author ericklao
 */

public class Player 
{
    //private instance variables
    private String name;
    private int age;
    private double balance;
    //constructor to initialise name, age and balance
    public Player(String name, int age, double balance) 
    {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
    //get method to return name
    public String getName() 
    {
        return name;
    }
    //get method to return age
    public int getAge()
    {
        return age;
    }
    //get method to return balance
    public double getBalance() 
    {
        return balance;
    }
    //set method for balance
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
}
