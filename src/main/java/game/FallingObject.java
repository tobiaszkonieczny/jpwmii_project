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
public class FallingObject {
    Image img;
    int x, y;
    boolean good;

    public FallingObject(int x, int y, URL url) {
        this.x = x;
        this.y = y;
        this.img = Toolkit.getDefaultToolkit().getImage(url);
        this.good = url.toString().contains("fruit");
    }

    public void update() { y += 5; }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, 50, 50, null);
    }

    public boolean isGood() { return good; }

    public Rectangle getBounds() { return new Rectangle(x, y, 50, 50); }
}