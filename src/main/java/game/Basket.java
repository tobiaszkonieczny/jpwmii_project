/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;
import java.awt.*;
import java.net.URL;
/**
 *
 * @author tobia
 */
public class Basket {
    private Image img;
    int x = 250, y = 700;

    public Basket(URL url) {
        img = Toolkit.getDefaultToolkit().getImage(url);
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, 100, 60, null);
    }

    public void move(int dx) {
        x += dx;
        if (x < 0) x = 0;
        if (x > 500) x = 500;
    }

    public Rectangle getBounds() { return new Rectangle(x, y, 100, 60); }
}