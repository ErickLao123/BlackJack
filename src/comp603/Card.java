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
    public String toString() {
        String rankString;
        String suitString;

        // Get the rank string
        switch (rank) {
            case ACE:
                rankString = "Ace";
                break;
            case TWO:
                rankString = "Two";
                break;
            case THREE:
                rankString = "Three";
                break;
            case FOUR:
                rankString = "Four";
                break;
            case FIVE:
                rankString = "Five";
                break;
            case SIX:
                rankString = "Six";
                break;
            case SEVEN:
                rankString = "Seven";
                break;
            case EIGHT:
                rankString = "Eight";
                break;
            case NINE:
                rankString = "Nine";
                break;
            case TEN:
                rankString = "Ten";
                break;
            case JACK:
                rankString = "Jack";
                break;
            case QUEEN:
                rankString = "Queen";
                break;
            case KING:
                rankString = "King";
                break;
            default:
                rankString = ""; // Handle unknown ranks if necessary
                break;
        }

        // Get the suit string
        switch (suit) {
            case CLUBS:
                suitString = "Clubs";
                break;
            case DIAMONDS:
                suitString = "Diamonds";
                break;
            case HEARTS:
                suitString = "Hearts";
                break;
            case SPADES:
                suitString = "Spades";
                break;
            default:
                suitString = ""; // Handle unknown suits if necessary
                break;
        }

        return "<html>"+rankString+"<br>of<br>" + suitString + "</html>";
    }

}
