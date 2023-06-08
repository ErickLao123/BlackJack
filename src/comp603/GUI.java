/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/**
 *
 * @author GGPC
 */
public class GUI {
    
    public Controller controller;
    public Login login;
    
    public CasinoPanel CPanel;
    public BlackJackPanel BJPanel;
    
    public GUI(Controller controller)
    {
        this.controller = controller;
        this.login = new Login(this.controller);
        
        this.CPanel = new CasinoPanel(this.controller);
        this.BJPanel = new BlackJackPanel(this.controller);
    }
}
