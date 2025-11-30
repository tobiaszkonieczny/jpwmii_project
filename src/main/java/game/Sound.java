/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.game;
import javax.sound.sampled.*;
import java.io.InputStream;
/**
 *
 * @author tobia
 */

public class Sound {
    public static void play(String path) {
        try {
            InputStream is = Sound.class.getResourceAsStream(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception ignored) {}
    }
}