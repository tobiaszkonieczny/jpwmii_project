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
public class GamePanel extends JComponent implements ActionListener, KeyListener {
    private Image bg;
    private Basket basket;
    private java.util.List<FallingObject> objects = new ArrayList<>();
    private javax.swing.Timer timer;
    private int points = 0;
    private int lives = 3;
    private Random rand = new Random();
    private boolean gameOver = false;
    private GameLogic logic = new GameLogic();

    public GamePanel() {
        bg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/resources/bg.jpg"));
        basket = new Basket(getClass().getResource("/main/resources/basket.png")); //Import background and basket
        timer = new javax.swing.Timer(16, this); //timer triggers each 16 ms = 60 fps
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        basket.draw(g);

        for (FallingObject o : objects) o.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("Points: " + points, 10, 20);
        g.drawString("Lives: " + lives, 10, 40);

        if (gameOver) g.drawString("GAME OVER", getWidth()/2 - 40, getHeight()/2);
    }
    
    @Override
    public Dimension getPreferredSize() { return new Dimension(600, 800); }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        if (rand.nextInt(25) == 0)
            objects.add(new FallingObject(
                    rand.nextInt(560),
                    0,
                    rand.nextBoolean() ? getClass().getResource("/main/resources/fruit.png")
                                       : getClass().getResource("/main/resources/bomb.png")
            ));

        for (Iterator<FallingObject> it = objects.iterator(); it.hasNext();) {
            FallingObject o = it.next();
            o.update();

            if (logic.checkCollision(basket, o)) {
                if (o.isGood()) {
                    points++;
                    Sound.play("/main/resources/catch.wav");
                } else {
                    lives--;
                    Sound.play("/main/resources/explosion.wav");
                    if (lives <= 0) gameOver = true;
                }
                it.remove();
            }

            if (o.y > getHeight()) it.remove();
        }

        repaint();
    }
    
    public void resetGame() {
    points = 0;
    lives = 3;
    objects.clear();
    gameOver = false;
    repaint();
}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) basket.move(-20);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) basket.move(20);
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}