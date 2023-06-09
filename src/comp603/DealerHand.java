/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/**
 *
 * @author ericklao
 */
public class DealerHand
{
    private final Deck hand;
    //constructor that initialises hand to a new deck
    public DealerHand() 
    {
        hand = new Deck();
    }
    //the purpose of this addcard method is to a card to the dealers hand
    public void addCard(Deck deck)
    {
        hand.draw(deck);
    }
    //the purpose of the gettotalvalue method is to return the totalvalue of the dealers cards
    public int getTotalValue() 
    {
        return hand.cardsRank();
    }
    //the purpose of the getfirstcard method is to return the dealers first card
    public Card getFirstCard() 
    {
        return hand.getCard(0);
    }
    public void clear()
    {
        hand.clear();
    }

    public Card getCard(int index) {
        return hand.getCard(index);
    }

    public int getHandSize() {
        return hand.deckSize();
    }


}
