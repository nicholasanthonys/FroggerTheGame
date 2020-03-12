/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Gameplay;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;


/**
 *
 * @author Ferani
 */
public class HowPlay extends Frame{

    JLabel label,labelJudul,labelBg;
    JPanel panel,panelJudul,panelBg,panelButton;
    Timer tm,t;
    String [] list = {"img/hp1.jpg","img/hp2.jpg","img/hp3.jpg","img/hp4.jpg","img/hp5.jpg"};
    ImageIcon img,bg;
    Font font,font1,font2;
    JProgressBar prog;
    JButton play;
    
    public HowPlay(){
        
         font = new Font("Copperplate Gothic Bold", Font.BOLD, 40);
         font1 = new Font("Verdana",Font.PLAIN , 13);
         font1 = new Font("Verdana",Font.BOLD , 15);
        
        frame.setSize(550,550);
        
        //background
        panelBg = new JPanel();
        panelBg.setBounds(0, 0, 550, 550);
        
        bg = new ImageIcon(new ImageIcon("gambar/bgLoad.jpg").getImage().getScaledInstance(frame.getWidth(),frame.getHeight(), Image.SCALE_DEFAULT));
        labelBg = new JLabel();
        labelBg.setIcon(bg);
        
        panelBg.add(labelBg);
        
        //Judul
       
        labelJudul = new JLabel("How To Play:  ");
        labelJudul.setForeground(Color.BLUE);
        labelJudul.setFont(font);
        
        panelJudul = new JPanel();
        panelJudul.setBackground(new Color(0,255,0,30));
        panelJudul.setBounds(60,50,400,50);
        
        panelJudul.add(labelJudul);
        
        //button
        panelButton = new JPanel();
        panelButton.setBounds(200,420,140,50);
        panelButton.setBackground(new Color(250,250,250,0));
        
        play = new JButton("Lets Play!!");
        play.setBackground(Color.GREEN);
        play.setForeground(Color.white);
        play.setPreferredSize(new Dimension(130, 40));
        play.setFont(font2);
        
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic.player.close();
                frame.dispose();
                new playMusic("music/backsound.mp3");
                //panggil game
                new Gameplay();
            }
        });
        
        
        panelButton.add(play);
        
        //progress Bar
        prog = new JProgressBar(0,2000);
        prog.setBounds(40,430,420,20);
        t = new Timer(50,new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e){
                i = i + 10;
                prog.setValue(i);
                if(i == 2000){
                    prog.setVisible(false);
                    panelButton.setVisible(true);
                    t.stop();
                }
            }

           
        });
        t.start();
        
        prog.setStringPainted(true);    

        //setPanel slideshow
        panel = new JPanel();
        panel.setBounds(50,110,420,300);
        
        label = new JLabel();
        
        setImage(0);
        tm = new Timer(3000,new ActionListener() {
            int a = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                setImage(a);
                a ++;
                if(a >= list.length ){
                    a = 0; 
                }
                new SoundEffect("music/flip.wav");
            }

           
        });
        
        tm.start();
       
        
        panel.add(label);
        
        
        panelButton.setVisible(false);
        frame.getContentPane().add(panelButton);
        frame.getContentPane().add(prog);
        frame.getContentPane().add(panelJudul);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panelBg);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
    
    public void setImage(int a){
        img = new ImageIcon(new ImageIcon(list[a]).getImage().getScaledInstance(panel.getWidth(),panel.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(img);
    }
    
}
