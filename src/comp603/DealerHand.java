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
        if (deck == null)
        {
            return;
        }
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
        //clear hand by calling the clear() method
        hand.clear();
    }
    //get method for getCard
    public Card getCard(int index) {
        //Get the card at the specific index from teh hand
        return hand.getCard(index);
    }
    //get method for getHandSize
    public int getHandSize() {
        //get the current size of the hand by calling deckSize()
        return hand.deckSize();
    }


}
