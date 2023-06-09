/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package comp603;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GGPC
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Deck.
     */
/**
     * Test of deckSize(), of class Deck.
     */
    @Test
    public void testGetSizeEmpty() {
        System.out.println("getSize-Empty"); //name of test
        Deck instance = new Deck(); //creating the instance
        int expResult = 0; //expected result
        int result = instance.deckSize(); //actual result/wat u get from it
        assertEquals(expResult, result); //checks if the they are correct or not
    }

    /**
     * Test of deckSize(), of class Deck.
     */
    @Test
    public void testGetSize1() {
        System.out.println("getSize-1"); //name of test
        Deck instance = new Deck(); //creating the instance
        int expResult = 1; //expected result
        instance.addCard(new Card(Suit.CLUBS, Rank.ACE));
        int result = instance.deckSize(); //actual result/wat u get from it
        assertEquals(expResult, result); //checks if the they are correct or not
    }

    /**
     * Test of deckSize(), of class Deck.
     */
    @Test
    public void testGetSize2() {
        System.out.println("getSize-2"); //name of test
        Deck instance = new Deck(); //creating the instance
        int expResult = 2; //expected result
        instance.addCard(new Card(Suit.DIAMONDS, Rank.TWO));
        instance.addCard(new Card(Suit.HEARTS, Rank.THREE));
        int result = instance.deckSize(); //actual result/wat u get from it
        assertEquals(expResult, result); //checks if the they are correct or not
    }
}
