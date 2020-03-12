/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.Frog;
import Model.Gameplay;
import static Model.Gameplay.score;
import Model.Map;
import static Model.Map.valScore;
import static View.Frame.frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ferani
 */
public class Lose extends Frame{
    JPanel panelLose ,imgPanel,panelButton, panelLead, panelScore;
    JLabel lose, imgLabel, lblScore, valScore;
    Font font = new Font("Snap ITC", Font.BOLD, 35);
    Font font1 = new Font("Copperplate Gothic Bold", Font.BOLD, 13);
    ImageIcon loseIcon;
    JButton button, buttonLead;
    Timer t,t1;
    
    public Lose(){
        
        
        new SoundEffect("music/lose.wav");
        
        lblScore = new JLabel("Score");
        lblScore.setFont(new Font("Verdana", Font.BOLD, 16));
        lblScore.setBounds(100, -10, 100, 50);
        
        valScore = new JLabel(score.toString());
        valScore.setFont(new Font("Verdana", Font.BOLD, 16));
        valScore.setBounds(100, 20, 100, 50);
        
        panelScore  = new JPanel();
        panelScore.setBounds(180, 410, 160, 50);
        panelScore.add(lblScore);
        panelScore.add(valScore);
        panelScore.setBackground(Color.cyan);
        panelScore.setVisible(true);
        
        //lose
        panelLose = new JPanel();
        panelLose.setBounds(50,60,400,70);
        panelLose.setBackground(Color.black);
        
        lose = new JLabel("Game Over :(");
        lose.setFont(font);
        lose.setForeground(Color.red);
        panelLose.add(lose);
        
        //png
        loseIcon = new ImageIcon(new ImageIcon("gambar/lose.png").getImage().getScaledInstance(210,170, Image.SCALE_DEFAULT));
        imgLabel = new JLabel();
        imgLabel.setIcon(loseIcon);
        imgPanel = new JPanel();
        imgPanel.setBounds(10,140,220,200);
        imgPanel.setBackground(new Color(255,255,255,0));
        imgPanel.add(imgLabel);
        
        t1 = new Timer(50,new ActionListener() {
        int x = 10;
            @Override
            public void actionPerformed(ActionEvent e) {
              x = x +5;
             imgPanel.setBounds(x,140,220,200);
            }

           
        });
        t1.start();
        new SoundEffect("music/lose1.wav");
        
        //button
        button = new JButton("Try Again?");
        button.setBackground(Color.black);
        button.setForeground(Color.red);
        button.setPreferredSize(new Dimension(150, 60));
        button.setFont(font1);
        
        panelButton = new JPanel();
        panelButton.setBounds(100,320,160,70);
        panelButton.setBackground(new Color(255,255,255,0));
        panelButton.add(button);
        panelButton.setVisible(false);
        
        buttonLead = new JButton("LeaderBoard?");
        buttonLead.setBackground(Color.YELLOW);
        buttonLead.setForeground(Color.black);
        buttonLead.setPreferredSize(new Dimension(150, 60));
        buttonLead.setFont(font1);
        
        panelLead = new JPanel();
        panelLead.setBounds(260, 320, 160, 70);
        panelLead.setBackground(new Color(255,255,255,0));
        panelLead.add(buttonLead);
        panelLead.setVisible(false);
        
        //
        
        t = new Timer(3000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              panelButton.setVisible(true);
              panelLead.setVisible(true);
                
            }

           
        });
        t.start();
        
        frame.getContentPane().add(panelScore);
        frame.getContentPane().add(panelLead);
        frame.getContentPane().add(panelButton);
        frame.getContentPane().add(imgPanel);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().add(panelLose);
        frame.setVisible(true);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.red);
                button.setForeground(Color.black);
                
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.black);
                button.setForeground(Color.red);
            }
        });
        
        buttonLead.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonLead.setBackground(Color.WHITE);
                buttonLead.setForeground(Color.black);
                
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLead.setBackground(Color.YELLOW);
                buttonLead.setForeground(Color.black);
            }
        });
        
        //action
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new playMusic("music/backsound.mp3");
                Map.frame.setVisible(true);
                Gameplay.nyawa = 5;
                Gameplay.score = 0; 
                Map.frog.setEnabled(true);
                ThreadMovingObject.setDelay(10);
                new ThreadMain().start();
                new ThreadFrog().start();
            }
        
    });
        
        buttonLead.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UnVisible();
                DataAkses.PrintLeaderboard();
                new SoundEffect("music/button.wav");
                new LeaderBoard(frame);
                DataAkses.id_user = 0;
                DataAkses.Username = null;
                DataAkses.Password = null;
            }
        });
    }
    
    public void UnVisible(){
        panelLose.setVisible(false);
        imgPanel.setVisible(false);
        panelButton.setVisible(false);
        panelLead.setVisible(false);
        button.setVisible(false); 
        buttonLead.setVisible(false);
    }
    
}