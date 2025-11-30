/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;
import javax.swing.*;

/**
 *
 * @author tobia
 */
public class Game {
       public static void main(String[] args) {
        JFrame f = new JFrame("ProjektKoniecznyTobiasz");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        f.add(new GamePanel());
        f.pack();
        f.repaint();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
       }
}
