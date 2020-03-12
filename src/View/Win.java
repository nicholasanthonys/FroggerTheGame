/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ferani
 */
public class Win extends Frame{
    JPanel panelWin ,imgPanel,panelButton,panelBg, panelButton1;
    JLabel win, imgLabel, bgLabel;
    Font font = new Font("Century Gothic", Font.BOLD, 50);
    Font font1 = new Font("Copperplate Gothic Bold", Font.BOLD, 12);
    ImageIcon winIcon, bgIcon;
    JButton button, button1;
    
    public Win(){
        new SoundEffect("music/win.wav");
        
        //win
        panelWin = new JPanel();
        panelWin.setBounds(50,60,400,70);
        panelWin.setBackground(new Color(0,255,255,50));
        
        win = new JLabel("YOU WIN!!!");
        win.setFont(font);
        win.setForeground(Color.yellow);
        panelWin.add(win);
        
        //png
        winIcon = new ImageIcon(new ImageIcon("gambar/win.png").getImage().getScaledInstance(210,170, Image.SCALE_DEFAULT));
        imgLabel = new JLabel();
        imgLabel.setIcon(winIcon);
        imgPanel = new JPanel();
        imgPanel.setBounds(110,140,270,200);
        imgPanel.setBackground(new Color(255,255,255,0));
        imgPanel.add(imgLabel);
        
         //button
        button = new JButton("Try Again?");
        button.setBackground(Color.green);
        button.setForeground(Color.red);
        button.setPreferredSize(new Dimension(140, 60));
        button.setFont(font1);
        
        panelButton = new JPanel();
        panelButton.setBounds(90,320,150,70);
        panelButton.setBackground(new Color(255,255,255,0));
        panelButton.add(button);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED);
                button.setForeground(Color.green);
                
                
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.green);
                button.setForeground(Color.RED);
            }
        });
        
        
        //butonlead
        button1 = new JButton("LeaderBoard");
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        button1.setPreferredSize(new Dimension(140, 60));
        button1.setFont(font1);
        
        panelButton1 = new JPanel();
        panelButton1.setBounds(260,320,150,70);
        panelButton1.setBackground(new Color(255,255,255,0));
        panelButton1.add(button1);
        
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(Color.white);
                button1.setForeground(Color.blue);
                
                
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1.setBackground(Color.BLUE);
                button1.setForeground(Color.white);
            }
        });
        
        //bg
        panelBg = new JPanel();
        panelBg.setBounds(0, 0, 550, 550);
        
        bgIcon = new ImageIcon(new ImageIcon("gambar/bgWin.jpg").getImage().getScaledInstance(550,550, Image.SCALE_DEFAULT));
        bgLabel = new JLabel();
        bgLabel.setIcon(bgIcon);
        
        panelBg.add(bgLabel);
        
        frame.getContentPane().add(panelButton1);
        frame.getContentPane().add(panelButton);
        frame.getContentPane().add(imgPanel);
        frame.getContentPane().add(panelWin);
        frame.getContentPane().add(panelBg);
        frame.setVisible(true);
    }
}
