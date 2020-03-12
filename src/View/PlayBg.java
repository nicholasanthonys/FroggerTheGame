/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static View.Frame.exit;
import static View.Frame.img;

/**
 *
 * @author Ferani
 */
public class PlayBg extends JFrame implements KeyListener{
    
    Image kodok1 = new ImageIcon ("gambar/kodok1.png").getImage();
    int kodokY = 480;
    int kodokX = 10;
    
    public PlayBg(){
        
        
        addKeyListener(this);
        setBounds(0, 0, 550 ,550);
        setVisible(true);
        setTitle("Frogger The Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int jawab = JOptionPane.showConfirmDialog(null, "Are u sure? ","Exit?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,exit);
                if (jawab == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
          

        });

        
        
        
        setIconImage(img.getImage());
        
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        
        g.fillRect(0, 0, 550, 550);
        
        g.drawImage(kodok1, kodokX, kodokY, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int a = e.getKeyCode();
        
        if(a == KeyEvent.VK_LEFT){
            kodokX -=10;
        }
        if(a == KeyEvent.VK_RIGHT){
            kodokX +=10;
        }
        if(a == KeyEvent.VK_DOWN){
            kodokY +=10;
        }
        if(a == KeyEvent.VK_UP){
            kodokY -=10;
        }
        
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
