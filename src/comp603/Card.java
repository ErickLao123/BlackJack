/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

/*
 * @author ericklao
 */
public class Card 
{
    //variables that hold the suit and rank of the cards
    private Suit suit;
    private Rank rank;
    //constructor that initializes the suit and rank variables
    public Card(Suit suit, Rank rank)
    {
        this.rank = rank;
        this.suit = suit;
    }
    //get method for rank, and return the rank of the card
    public Rank getRank()
    {
        return this.rank;
    }
    //tostring method that returns an appopriate string of the card object
    @Override
    public String toString()
    {
        return this.suit.toString()+ "-" +this.rank.toString();
    }
}
