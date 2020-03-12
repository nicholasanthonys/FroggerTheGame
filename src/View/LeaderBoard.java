/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DataAkses;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author Ferani
 */
public class LeaderBoard{
    private JPanel panelBg ,panelJudul, panelButton;
    private JLabel labelBg, labelJudul;
    private ImageIcon bg;
    private Font font = new Font("Copperplate Gothic Bold", Font.BOLD, 48);
    private Font font1 = new Font("Verdana", Font.BOLD, 15);
    private JTable tabel;
    private JScrollPane scroll;
    private JButton button;
    DataAkses da;
    
    public LeaderBoard(final JFrame frame){
        new SoundEffect("music/tada.wav");
        //background
        bg = new ImageIcon (new ImageIcon("gambar/bgLead.jpg").getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT));
        labelBg = new JLabel();
        labelBg.setIcon(bg);
        
        panelBg = new JPanel();
        panelBg.setBounds(0, 0, 500, 500);
        panelBg.add(labelBg);
        
        labelJudul = new JLabel("LeaderBoard");
        labelJudul.setForeground(Color.cyan);
        labelJudul.setFont(font);
        
        panelJudul = new JPanel();
        panelJudul.setBounds(0, 70, 500, 100);
        panelJudul.setBackground(new Color(255, 255, 255, 0));
        
        panelJudul.add(labelJudul);
        //tabel
        String[][] data = { 
            { "1", DataAkses.Nama.get(0), DataAkses.Score.get(0) }, 
            { "2", DataAkses.Nama.get(1), DataAkses.Score.get(1) }, 
            { "3", DataAkses.Nama.get(2), DataAkses.Score.get(2) }, 
            { "4", DataAkses.Nama.get(3), DataAkses.Score.get(3) }, 
            { "5", DataAkses.Nama.get(4), DataAkses.Score.get(4) }, 
            { "6", DataAkses.Nama.get(5), DataAkses.Score.get(5) }, 
            { "7", DataAkses.Nama.get(6), DataAkses.Score.get(6) }, 
            { "8", DataAkses.Nama.get(7), DataAkses.Score.get(7) }, 
            { "9", DataAkses.Nama.get(8), DataAkses.Score.get(8) }, 
            { "10", DataAkses.Nama.get(9), DataAkses.Score.get(9) }
        }; 
        String[] kolom = { "Rank", "Name", "Score" }; 
        
        tabel = new JTable(data,kolom);
        tabel.setBounds(40,150,400,160);
        
        //button menu
        button = new JButton("Menu");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.white);
        button.setPreferredSize(new Dimension(130, 60));
        button.setFont(font1);
        
        panelButton = new JPanel();
        panelButton.setBounds(170,360,140,70);
        panelButton.add(button);
        panelButton.setBackground(Color.DARK_GRAY);
        
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SoundEffect("music/button.wav");
                playMusic.player.close();
                frame.dispose();
                new Menu();
            }
        });
        
         button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.white);
                button.setForeground(Color.blue);                
                
                new SoundEffect("music/boing.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.white);
            }
        });
        
        frame.getContentPane().add(panelButton);
        frame.getContentPane().add(tabel);
        frame.getContentPane().add(panelJudul);
        frame.getContentPane().add(panelBg);
    }
}
