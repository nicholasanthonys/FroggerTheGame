/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author Ferani
 */
public class playMusic {

    public static Player player;

    public playMusic(String audio) {

        try {
            FileInputStream fis = new FileInputStream(audio);
            player = new Player(fis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
        
        //buat stop: playMusic.player.close();
    }
}
