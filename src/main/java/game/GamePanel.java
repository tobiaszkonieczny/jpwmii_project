/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author tobia
 */
public class GamePanel extends JComponent {
        private Image bg;
        private Basket basket;

        
    public GamePanel() {
        bg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/resources/bg.jpg"));
        basket = new Basket(getClass().getResource("/main/resources/basket.png"));
    }
    
       @Override
       protected void paintComponent(Graphics g) {
               super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        basket.draw(g);   
    }
       
       @Override
       public Dimension getPreferredSize() {
            return new Dimension(600, 800);
        }
}
