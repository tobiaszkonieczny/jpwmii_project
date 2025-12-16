/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;
import javax.sound.sampled.*;
import java.io.InputStream;
import java.io.BufferedInputStream;

/**
 *
 * @author tobia
 */

public class Sound {
    public static void play(String path) {
        try {
            InputStream is = Sound.class.getResourceAsStream(path);
            if (is == null) {
                System.out.println("Nie znaleziono pliku: " + path);
                return;
            }
            BufferedInputStream bis = new BufferedInputStream(is); //this is because the sounds didn't play in jar
            AudioInputStream audio = AudioSystem.getAudioInputStream(bis);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}