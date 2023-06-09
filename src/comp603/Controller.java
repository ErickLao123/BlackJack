/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;
/**
 * @author Erick Lao
 */
public class Controller {
    public GUI gui;
    public Deck deck;
    public DealerHand dealerHand;
    public PlayerHand playerHand;
    //reference database and check if there is data skip the login screen if there is go to casino panel
    public Controller()
    {
        this.gui = new GUI(this);
        this.gui.exist = new Exist(this);
        this.gui.exist.setVisible(true);
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
    

    public void displayCards(boolean showDealer) {
        //if statement checks if the handsize is more than 0
        if (playerHand.getHandSize() > 0) {
            this.gui.BJPanel.getPlayerCard1().setText(playerHand.getCard(0).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard1().setText("");
        }
        if (playerHand.getHandSize() > 1) {
            this.gui.BJPanel.getPlayerCard2().setText(playerHand.getCard(1).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard2().setText("");
        }

        if (playerHand.getHandSize() > 2) {
            this.gui.BJPanel.getPlayerCard3().setText(playerHand.getCard(2).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard3().setText("");
        }

        if (playerHand.getHandSize() > 3) {
            this.gui.BJPanel.getPlayerCard4().setText(playerHand.getCard(3).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard4().setText("");
        }

        if (playerHand.getHandSize() > 4) {
            this.gui.BJPanel.getPlayerCard5().setText(playerHand.getCard(4).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard5().setText("");
        }

        if (playerHand.getHandSize() > 5) {
            this.gui.BJPanel.getPlayerCard6().setText(playerHand.getCard(5).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getPlayerCard6().setText("");
        }

        if (dealerHand.getHandSize() > 0) {
            this.gui.BJPanel.getDealerCard1().setText(dealerHand.getCard(0).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard1().setText("");
        }
        
        if (dealerHand.getHandSize() > 1) {
            if (showDealer == true)
            {
                this.gui.BJPanel.getDealerCard2().setText(dealerHand.getCard(1).toString());
            }
            else
            {
                this.gui.BJPanel.getDealerCard2().setText("???");
            }
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard2().setText("");
        }

        if (dealerHand.getHandSize() > 2) {
            this.gui.BJPanel.getDealerCard3().setText(dealerHand.getCard(2).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard3().setText("");
        }

        if (dealerHand.getHandSize() > 3) {
            this.gui.BJPanel.getDealerCard4().setText(dealerHand.getCard(3).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard4().setText("");
        }

        if (dealerHand.getHandSize() > 4) {
            this.gui.BJPanel.getDealerCard5().setText(dealerHand.getCard(4).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard5().setText("");
        }

        if (dealerHand.getHandSize() > 5) {
            this.gui.BJPanel.getDealerCard6().setText(dealerHand.getCard(5).toString());
        } else {
            //if there is a card 
            this.gui.BJPanel.getDealerCard6().setText("");
        }
    }
    public void callStart()
    {
        // Deal two cards to the player
        playerHand.drawCard(deck);
        playerHand.drawCard(deck);

        // Deal two cards to the dealer
        dealerHand.addCard(deck);
        dealerHand.addCard(deck);
    }
            
}
