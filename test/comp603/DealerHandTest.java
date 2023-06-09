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
public class DealerHandTest {

    public DealerHandTest() {
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

    @Test
    public void testAddCard_NullDeck() {
        Deck deck = null;
        DealerHand instance = new DealerHand();
        instance.addCard(deck);
        assertEquals(0, instance.getHandSize());

    }

    @Test
    public void testAddCard_NonNullDeck() {
        // Arrange
        Deck deck = new Deck();
        DealerHand instance = new DealerHand();
        instance.addCard(deck);
        assertEquals(1, instance.getHandSize());
        assertEquals(deck.getCard(0), instance.getCard(0));
    }

}
