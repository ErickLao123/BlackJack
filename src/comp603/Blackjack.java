/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

import java.util.Scanner;

/**
 *
 * @author ericklao
 */
public class Blackjack
{
    public static void main(String[] args) 
    {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Welcome to the Casino of New Zealand.");
        System.out.println("What would you like to do? Load Data or Start a New Game?");
        String choice = input1.nextLine();

        if (choice.equalsIgnoreCase("Load Data")) 
        {
            Player player = FileIO.readPlayerInfo();
            if (player != null) 
            {
                System.out.println("Welcome back, " + player.getName() + "!");
                System.out.println("Your age is: " + player.getAge());
                System.out.println("Your balance is: " + player.getBalance());
                playBlackjack(player);
            } 
            else 
            {
                System.out.println("No existing player data found. Starting a new game...");
                startNewGame();
            }
        } 
        else if (choice.equalsIgnoreCase("Start a New Game")) 
        {
            startNewGame();
        } else 
        {
            System.out.println("Invalid choice. Goodbye!");
        }
    }

    private static void startNewGame() 
    {
        Scanner input2 = new Scanner(System.in);

        int age = 0;
        String name = "";
        double playerBalance;
        //while loop to keep asking the user for their name and age until the age they inputted is greater than 20
        while (age < 20) 
        {
            //asks the user to input their name
            System.out.print("Enter your name: ");
            name = input2.nextLine();
            //had chatgpt create a exception if the user inputs anything other than a string for their name
            if (!name.matches("^[a-zA-Z]+$")) 
            {
                System.out.println("\nPlease enter a valid name!\n");
                continue; // runs loop again
            }
            //asks the user to input their age
            System.out.print("Enter your age: ");
            age = input2.nextInt();
            //if loop to check if the age the user has entered, if it is below 20, it will print out a message
            if (age < 20) 
            {
                System.out.println("\nYou are too young to play. Wait until you are 20!!!\n");
                input2.nextLine();
            } 
        } 
        //asks the user to input the balance they want to gamble
        System.out.print("Enter your balance: ");
        playerBalance = input2.nextDouble();
        //purpose of this is to create a new player object that holds the name, age, and player balance
        Player player = new Player(name, age, playerBalance);
        //the playerinfo is written into a file in the fileIO class
        FileIO.writePlayerInfo(player);

        playBlackjack(player);
    }

    private static void playBlackjack(Player player) 
    {
        Scanner input1 = new Scanner(System.in);
        System.out.println("\n\nWelcome to the Casino of New Zealand.");
        System.out.println("What would you like to do? Blackjack or Look Around?");
        String gameChoice = input1.nextLine();

        /**
         * purpose of this if loop is to check if the user inputs 'Blackjack', regardless of the case of the letters.
         * if the user did input 'blackjack' it will continue to run the code. had chatgpt explain how to ignore casing in the inputs
         */
        if (gameChoice.equalsIgnoreCase("Blackjack")) 
        {
            System.out.println("\nHave fun!!!\n");

            System.out.println("Welcome " + player.getName() + " to Blackjack!. You are " + player.getAge() + " years old, you are old enough to play!");
            //purpose of the code below is to generate and shuffle the cards
            Deck playingDeck = new Deck();
            playingDeck.generateCards();
            playingDeck.shuffling();

            //creating empty decks for the player and dealer
            Deck playerhand = new Deck();
            Deck dealerhand = new Deck();

            Scanner input = new Scanner(System.in);

            //the purpose of this while loop is to keep rerunning the program until the player's balance is 0
            while (player.getBalance() > 0)
            {
                FileIO.writePlayerInfo(player);

                System.out.println("You have $" + player.getBalance() + ", how much would you like to bet?");
                double playerBet = input.nextDouble();
                /*
                 * if loop to check if the bet the player has put is greater than the amount they have in their balance.
                 * if this is true, then the program will print out a message and stop the program
                 */
                if(playerBet > player.getBalance())
                {
                    System.out.println("You have been kicked out for betting without sufficient amount of money!");
                    break;   
                }

                //the code below is responsible for drawing two cards for the player and the dealer
                playerhand.draw(playingDeck);
                playerhand.draw(playingDeck);         
                dealerhand.draw(playingDeck);
                dealerhand.draw(playingDeck);

                boolean matchdone = false;
                /*
                 *the purpose of this while loop is too loop through the code while the player decides whether to hit or stand with the value of their cards
                 */
                while(true)
                {
                    //displays the rank and suit of the cards
                    System.out.println("\nYour Hand:");
                    System.out.println(playerhand.toString());
                    //displays the total value of the cards
                    System.out.println("Your hand is valued at: \n" + playerhand.cardsRank());

                    System.out.println("\nDealers hand: \n\n" + dealerhand.getCard(0).toString() + "\n[Face Down]\n");

                    int response;
                    //the purpose of this do loop is to keep asking the user to type 1 or 2 until the user inputs the valid choice
                    do 
                    {
                        System.out.println("Do you want to hit (1), stand (2)or quit (3)?\n");
                        response = input.nextInt();
                    } while (response != 1 && response != 2 && response != 3);
                    //the purpose of this if loop is, if the user input is 1, it will draw a randomized card from the deck
                    if(response == 1)
                    {
                        playerhand.draw(playingDeck);
                        System.out.println("You draw a: \n"+playerhand.getCard(playerhand.deckSize()-1).toString());
                        /*
                         *the purpose of this if loop is to check whether the player's hand is above 21, and if it is it will prompt a message
                         *after the message it will deduct the amount the player bet and end the code after prompting one more message
                         */
                        if(playerhand.cardsRank() > 21)
                        {
                            System.out.println("You have busted, your cards are valued at: "+playerhand.cardsRank());
                            player.setBalance(player.getBalance() - playerBet);
                            matchdone = true;
                            break;
                        }
                    }
                    //if the user input is two, it will end their turn and check the dealer's hand
                    if (response == 2)
                    {
                        break;   
                    }
                    if (response == 3 )
                    {
                        System.exit(0);
                    }
                }  

                System.out.println("Dealers Hand: "+dealerhand.toString());
                /*
                 *the purpose of this if loop is to check whether the dealer's hand is higher than the player's hand
                 * and prompting a message saying the dealer has a higher value of cards
                 */
                if(dealerhand.cardsRank() > playerhand.cardsRank() && matchdone == false)
                {
                    System.out.println("You have lost, Dealer has a higher value of cards than you!");
                    player.setBalance(player.getBalance() - playerBet);
                    matchdone = true;
                }
                //the purpose of this while loop is to have the dealer keep drawing until the total value of their cards is greater than 17
                while ((dealerhand.cardsRank() < 17) && matchdone == false )
                {
                    dealerhand.draw(playingDeck);
                    System.out.println("\nDealer Draws: "+dealerhand.getCard(dealerhand.deckSize()-1).toString());
                }

                System.out.println("Dealers Hand adds up to: " + dealerhand.cardsRank());
                /*
                 * the purpose of this if loop is to check if the dealer's hand is greater than 21.
                 * if the total value of the dealer's hand is greater it will prompt a message saying the dealer busts and add the amount you have bet
                 */
                if(dealerhand.cardsRank() > 21 && matchdone == false)
                {
                    System.out.println("\nDealer Busts! You have won!!!");
                    player.setBalance(player.getBalance() + playerBet);
                    matchdone = true;
                }
                /*
                 *the purpose of this if loop is to check the total value of the player and dealer's hand. 
                 *if they are equal it will prompt a message
                 */
                if((playerhand.cardsRank() == dealerhand.cardsRank()) && matchdone == false)
                {
                    System.out.println("\nPush, you have drawn with the dealer! ");
                    matchdone = true;
                }
                /*
                 *the purpose of this if loop is to determine whether the player's hand is greater than the dealer's hand
                 * if the player has a greater total value it will prompt a message saying you win the hand and you win your bet.
                 */
                if ((playerhand.cardsRank() > dealerhand.cardsRank()) && matchdone == false)
                {
                    System.out.println("You have a higher value than the dealer, you win the hand!");
                    player.setBalance(player.getBalance() + playerBet);
                    matchdone = true;
                }
                //purpose of this else if loop is to prompt a message if the dealer's hand is greater than the player's hand
                else if (matchdone == false)
                {
                    System.out.println("\nThe dealer's hand has a higher value of cards than you! You lose the hand");
                    player.setBalance(player.getBalance() - playerBet);
                    matchdone = true;
                }
                //this will move all the cards from the player and dealer's hand back to the deck.
                playerhand.moveAlltoDeck(playingDeck);
                dealerhand.moveAlltoDeck(playingDeck);

                System.out.println("\nEnd of hand.\n");   
            }
            System.out.println("\nGame over! Goodbye!");
        }
        //the else if loop will run if the user inputs "Look Around", ignores the casing of the letters
        else if (gameChoice.equalsIgnoreCase("Look Around")) 
        {
            System.out.println("\nThanks for visiting the Casino of New Zealand!");
        }       
        /*
         *purpose of this else loop is to prompt a message if the user inputs anything other than "Blackjack" and "Look Around"
         * after it will end the program
         */
        else
        {
            System.out.println("Invalid choice. Goodbye!");
        }
    }
}