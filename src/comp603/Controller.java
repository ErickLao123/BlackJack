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
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        
    }
    
}
