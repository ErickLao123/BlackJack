//Had chatgpt assist me in creating this. used examples that are different that they gave me and turned it into my own while following its structure

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ericklao
 */
public class FileIO 
{
    public static void writePlayerInfo(Player player) 
    {
        try 
        {
            //creates a writer object to write to the file
            FileWriter writer = new FileWriter("player.txt");
            //player information written to the file
            writer.write("Name: " + player.getName() + "\n\n");
            writer.write("Age: " + player.getAge() + "\n");
            writer.write("Balance: " + player.getBalance() + "\n");
            writer.close();
            //if IOException occurs, it will catch and handle it
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
        }
    }
    
    public static Player readPlayerInfo() 
    {
        //initialises variables
        String name = "";
        int age = 0;
        double balance = 0;
        //creates a new object named file 
        try 
        {
            File myObj = new File("player.txt");
            Scanner myReader = new Scanner(myObj);
            //purpose of the while loop is to go through each line
            while (myReader.hasNextLine()) 
            {
                String data = myReader.nextLine();
                //purpose of this if loop is to check if it contains the name 
                if (data.contains("Name:")) 
                {
                    name = data.substring(6);
                } 
                //purpose of this else if loop is to check if it contains the age
                else if (data.contains("Age:")) 
                {
                    age = Integer.parseInt(data.substring(5));
                } 
                //purpose of this else if loop is to check if it contains the balance
                else if (data.contains("Balance:")) 
                {
                    balance = Double.parseDouble(data.substring(9));
                }
            }
            myReader.close();
        } 
        //if an exception is thrown, it will catch the exception and prompt a message
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
        }
        //returns the player object filled with the name, age and balance of the user
        return new Player(name, age, balance);
    }
}
