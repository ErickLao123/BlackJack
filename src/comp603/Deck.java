/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ericklao
 */
public class Deck {
    
    //instance Variable to hold the cards
    private ArrayList<Card> cards;
    
    //the purpose of this Constructor is too initialise the deck with a list of empty cards
    public Deck()
    {
        this.cards = new ArrayList<Card>();
    }
    //purpose of this toString method is too output the list of the cards
    @Override
    public String toString()
    {
        String cardListOutput ="";
        for(Card ACard : this.cards)
        {
            cardListOutput += "\n" + ACard.toString();
        }
        return cardListOutput;
    }
    //purpose of this method is too generate a full deck of cards by going through each rank and suit
    public void generateCards()
    {
        for (Suit s : Suit.values())
        {
            for (Rank v : Rank.values())
            {
                Card newCard = new Card(s, v);
                this.cards.add(newCard);
            }
        }
    }
    //purpose of this method is to shuffle the cards in the deck to ensure the cards picekd are random
    public void shuffling()
    {
        Collections.shuffle(this.cards);
    }
    //method to remove a card from the deck do 
    public void removeCard(int i)
    {
        this.cards.remove(i);
    }
    //method to get a card from the deck
    public Card getCard(int i)
    {
        return this.cards.get(i);
    }
    //method to add a card from the deck
    public void addCard(Card addCard)
    {
        this.cards.add(addCard);
    }
    //method too draw a card from a different deck and into its deck 
    public void draw(Deck From)
    {
        this.cards.add(From.getCard(0));
        From.removeCard(0);
    }
    //method to check the deck size
    public int deckSize()
    {
        return this.cards.size();
    }
    //method thats purpose is to move all the cards from one deck to another
    public void moveAlltoDeck(Deck moveTo)
    {
        int thisDeckSize = this.cards.size();
        
        for(int i = 0; i < thisDeckSize; i++)
        {
            moveTo.addCard(this.getCard(i));
        }
        
        for(int i = 0; i < thisDeckSize; i++)
        {
            this.removeCard(0);
        }
    }
    //method to determine the rank of the cards in the deck
    public int cardsRank()
    {
        int totalRank = 0;
        int aces = 0;
        //hashmap too hold the value of each card/rank
        Map<Rank, Integer> rankValues = new HashMap<>();
        rankValues.put(Rank.TWO, 2);
        rankValues.put(Rank.THREE, 3);
        rankValues.put(Rank.FOUR, 4);
        rankValues.put(Rank.FIVE, 5);
        rankValues.put(Rank.SIX, 6);
        rankValues.put(Rank.SEVEN, 7);
        rankValues.put(Rank.EIGHT, 8);
        rankValues.put(Rank.NINE, 9);
        rankValues.put(Rank.TEN, 10);
        rankValues.put(Rank.JACK, 10);
        rankValues.put(Rank.QUEEN, 10);
        rankValues.put(Rank.KING, 10);
        rankValues.put(Rank.ACE, 11);

        //a for loop to loop over the players hand
        for (Card aCard : this.cards)
        {
            totalRank += rankValues.get(aCard.getRank());
            //an if loop too increase the ace counter if the card is an ace
            if (aCard.getRank() == Rank.ACE)
            {
                aces += 1;
            }
        }
        //for loop to check if the player is holding an ace and to check if the rank should be determined and counted as a 1 or 11
        for (int i = 0; i < aces; i++)
        {
            /*
             *the purpose of this if loop is if the ace makes the player's hand to be greater than 21,
             *it will subtract 10 and the ace will count as a 1.
             */
            if (totalRank > 21)
            {
                totalRank -= 10; 
            }
        }
        //returns the total value of the cards in the players hand
        return totalRank;
    }
    public void clear()
    {
        //clears the hand using the clear() method
        cards.clear();
    }
}
