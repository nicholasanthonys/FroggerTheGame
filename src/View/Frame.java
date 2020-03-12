/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ferani
 */
public class Frame extends JFrame{
    static JFrame frame;
    static ImageIcon img = new ImageIcon("gambar/icon.png");
    static ImageIcon exit = new ImageIcon("gambar/exit.png");
    static boolean play = true;
    
    public Frame() {
         
        
        frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.setTitle("Frogger The Game");

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int jawab = JOptionPane.showConfirmDialog(null, "Are u sure? ","Exit?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,exit);
                if (jawab == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
          

        });

        
        
        
        frame.setIconImage(img.getImage());
    }
}
