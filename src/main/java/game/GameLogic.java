/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;

/**
 *
 * @author tobia
 */
public class GameLogic {
    public boolean checkCollision(Basket b, FallingObject o) {
        return b.getBounds().intersects(o.getBounds());
    }
}