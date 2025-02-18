/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/**
 *
 * @author ericklao
 */
public class PlayerHand {
    private Deck hand;
    
    //constructor intializes the instance by creating a new deck and giving it to the hand class
    public PlayerHand() {
        this.hand = new Deck();
    }
    //draw method that takes in an argument and calls the draw method.
    public void drawCard(Deck deck) {
        hand.draw(deck);
    }
    
    public Card getCard(int index) {
        return hand.getCard(index);
    }

    public int getHandValue() {
        return hand.cardsRank();
    }
    public void clear() 
    {
        //clear hand by calling the clear() method
        hand.clear();
    }
    public int getHandSize() {
        //get the current size of the hand by calling deckSize()
        return hand.deckSize();
    }



}
