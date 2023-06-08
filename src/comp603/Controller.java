/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/**
 *
 * @author Erick Lao
 */
public class Controller {
    public GUI gui;
    //reference database and check if there is data skip the login screen if there is go to casino panel
    public Controller()
    {
        this.gui = new GUI(this);
        this.gui.login.setVisible(true);
    }
    private double userMoney; // Assuming user's money is stored as a double variable

    // Other code in the Controller class

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double money) {
        userMoney = money;
    }
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        
    }
    
}
