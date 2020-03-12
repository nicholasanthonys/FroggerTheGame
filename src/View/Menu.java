/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DataAkses;
import static View.Frame.frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ferani
 */
public class Menu extends Frame implements MouseListener {

    public static JFrame frame1;
    public static JPanel panelBackground, panelbuttonregis, panelbuttonLeader, panelbuttonLogin, panel, panelimg;
    JPanel panelex;
    Font font, font1;
    JLabel label, labelBg, labelimg;
    JButton buttonLogin, buttonRegis, buttonLeader, buttonEx;
    ImageIcon icon, iconimg;
    Timer tm;
    DataAkses da;
    
    public Menu() {
        frame1 = new JFrame();
        frame1 = frame;
        new playMusic("music/backsound.mp3");

        Menu.panel = new JPanel();
        Menu.panel.setBounds(10, 30, 480, 80);
        Menu.panel.setBackground(new Color(0, 255, 0, 0));

        font = new Font("Copperplate Gothic Bold", Font.BOLD, 40);
        label = new JLabel("Frogger The Game! ");
        label.setForeground(new Color(255, 255, 255));
        label.setFont(font);

        font1 = new Font("Berlin Sans FB Demi", Font.PLAIN, 16);

        //buttonregis
        Menu.panelbuttonregis = new JPanel();
        Menu.panelbuttonregis.setBounds(20, 360, 120, 60);
        Menu.panelbuttonregis.setBackground(new Color(0, 255, 0, 0));

        buttonRegis = new JButton("Register");
        buttonRegis.setBackground(Color.blue);
        buttonRegis.setForeground(Color.white);
        buttonRegis.setPreferredSize(new Dimension(120, 60));
        buttonRegis.setFont(font1);

        //buttonlogin
        Menu.panelbuttonLogin = new JPanel();
        Menu.panelbuttonLogin.setBounds(170, 360, 130, 60);
        Menu.panelbuttonLogin.setBackground(new Color(0, 255, 0, 0));

        buttonLogin = new JButton("Login");
        buttonLogin.setBackground(Color.red);
        buttonLogin.setForeground(Color.white);
        buttonLogin.setPreferredSize(new Dimension(130, 60));
        buttonLogin.setFont(font1);

        //buttonLeaderboard
        Menu.panelbuttonLeader = new JPanel();
        Menu.panelbuttonLeader.setBounds(320, 360, 130, 60);
        Menu.panelbuttonLeader.setBackground(new Color(0, 255, 0, 0));

        buttonLeader = new JButton("LeaderBoard");
        buttonLeader.setBackground(Color.orange);
        buttonLeader.setForeground(Color.white);
        buttonLeader.setPreferredSize(new Dimension(130, 60));
        buttonLeader.setFont(font1);
        
        //buttonexit
        panelex = new JPanel();
        panelex.setBounds(200,440, 80, 30);
        panelex.setBackground(new Color(0, 255, 0, 0));
        
        buttonEx = new JButton("Exit");
        buttonEx.setBackground(Color.black);
        buttonEx.setForeground(Color.white);
        buttonEx.setPreferredSize(new Dimension(70,20));
        
        
        //Panel Bg
        Menu.panelBackground = new JPanel();
        Menu.panelBackground.setBounds(0, 0, 500, 500);
        Menu.panelBackground.setBackground(new Color(0, 255, 0, 0));

        labelBg = new JLabel();
        icon = new ImageIcon(new ImageIcon("gambar/bgGreen1.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        labelBg.setIcon(icon);

        //PanelImage
        Menu.panelimg = new JPanel();
        Menu.panelimg.setBounds(100, 110, 280, 280);
        Menu.panelimg.setBackground(new Color(0, 255, 0, 0));

        labelimg = new JLabel();
        iconimg = new ImageIcon(new ImageIcon("gambar/frog.png").getImage().getScaledInstance(210, 210, Image.SCALE_DEFAULT));
        labelimg.setIcon(iconimg);

          //
        panel.add(label);
        
        Menu.panelimg.add(labelimg);
        Menu.panelbuttonregis.add(buttonRegis);
        Menu.panelbuttonregis.add(buttonRegis);
        Menu.panelbuttonLogin.add(buttonLogin);
        Menu.panelbuttonLeader.add(buttonLeader);
        panelex.add(buttonEx);
        Menu.panelBackground.add(labelBg);
          //
        frame.getContentPane().add(panelex);
        frame.getContentPane().add(Menu.panelimg);
        frame.getContentPane().add(Menu.panelbuttonLeader);
        frame.getContentPane().add(Menu.panelbuttonLogin);
        frame.getContentPane().add(Menu.panelbuttonregis);
        frame.getContentPane().add(Menu.panel);
        frame.getContentPane().add(Menu.panelBackground);

        //Command for button
        buttonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tm.stop();
                new SoundEffect("music/button.wav");
                setUnVisible();
                Menu.Go();
            }
            
        });
        
        buttonRegis.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tm.stop();
                new SoundEffect("music/button.wav");
                setUnVisible();
                new Register(frame,Menu.panelBackground);

            }
        });

        buttonLeader.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tm.stop();
                DataAkses.PrintLeaderboard();
                new SoundEffect("music/button.wav");
                setUnVisible();
                new LeaderBoard(frame);

            }
        });
        
        buttonEx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    
                int jawab = JOptionPane.showConfirmDialog(null, "Are u sure? ","Exit?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,exit);
                if (jawab == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }

        });
        
         //effect mouseover
        buttonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonLogin.setBackground(Color.yellow);
                buttonLogin.setForeground(Color.red);
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLogin.setBackground(Color.red);
                buttonLogin.setForeground(Color.white);
            }
        });
        
        buttonRegis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRegis.setBackground(Color.yellow);
                buttonRegis.setForeground(Color.red);
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonRegis.setBackground(Color.BLUE);
                buttonRegis.setForeground(Color.white);
            }
        });
        
        buttonLeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonLeader.setBackground(Color.yellow);
                buttonLeader.setForeground(Color.red);
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLeader.setBackground(Color.ORANGE);
                buttonLeader.setForeground(Color.white);
            }
        });
        
        //blinking text
        
        
        tm = new Timer(300,new ActionListener() {
            int a=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                a++;
                if(a %2 == 0 ){
                    Menu.panel.setVisible(false);
                }else{
                    Menu.panel.setVisible(true);
                }
               
            }
            
           
        });
        tm.start();
        
        frame.setVisible(true);

    }

    public static void setUnVisible() {
        Menu.panelbuttonregis.setVisible(false);
        Menu.panelbuttonLeader.setVisible(false);
        Menu.panelbuttonLogin.setVisible(false);
        Menu.panelBackground.setVisible(false);
        Menu.panelimg.setVisible(false);
        Menu.panel.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void Go(){
        new Login(frame1, Menu.panelBackground);
    }
    
}