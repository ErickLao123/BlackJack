/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/*
 * @author GGPC
 */
public class CardPicture extends Canvas{
    
    public Card C;
    
    public void paintcomponent (Graphics g)
    {
        Image cardPicture = Toolkit.getDefaultToolkit().getImage("Face of cards/" +C.toString() +".png");
        g.drawImage(cardPicture, 15, 15, null);
    }
}
