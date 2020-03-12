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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ferani
 */
public class Login extends JFrame {
    
    JPanel panelJudul, panelForm, panelSubmit, panelBack;
    JLabel labelJudul, username, password;
    Font font;
    JTextField fieldUser;
    JPasswordField fieldPass;
    JButton submit, back;
    ImageIcon icon;
    
    public Login(final JFrame frame, JPanel bg) {
        
        //judul
        panelJudul = new JPanel();
        panelJudul.setBounds(0, 90, 500, 100);
        panelJudul.setBackground(new Color(255, 255, 255, 0));

        font = new Font("Copperplate Gothic Bold", Font.BOLD, 48);
        labelJudul = new JLabel("Login");
        labelJudul.setForeground(new Color(255, 255, 255));
        labelJudul.setFont(font);

        //Login Form
        panelForm = new JPanel(new GridLayout(2, 1));
        panelForm.setBounds(40, 200, 350, 50);
        panelForm.setBackground(new Color(0, 255, 0, 10));

        //label
        username = new JLabel("Username ");
        username.setForeground(Color.black);
        fieldUser = new JTextField(20);

        password = new JLabel("Password");
        password.setForeground(Color.black);
        fieldPass = new JPasswordField(10);

        //submit
        panelSubmit = new JPanel();
        panelSubmit.setBounds(210, 290, 130, 40);
        panelSubmit.setBackground(new Color(255, 255, 255, 0));

        submit = new JButton("Login");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setPreferredSize(new Dimension(130, 40));

        //Back
        panelBack = new JPanel();
        panelBack.setBounds(30, 350, 100, 70);
        panelBack.setBackground(new Color(255, 255, 255, 0));

        back = new JButton();
        icon = new ImageIcon(new ImageIcon("gambar/Back.png").getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));
        back.setIcon(icon);
        back.setBackground(new Color(0, 255, 204));

        //Command For Button
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SoundEffect("music/button.wav");
                playMusic.player.close();
                frame.dispose();
                new Menu();
            }
        });

        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fieldUser.getText();
                String password = new String(fieldPass.getPassword());
                
                DataAkses.cekLogin(username, password, frame);
                
            }
        });

        //
        panelJudul.add(labelJudul);

        panelForm.add(username);
        panelForm.add(fieldUser);
        panelForm.add(password);
        panelForm.add(fieldPass);

        panelSubmit.add(submit);
        panelBack.add(back);

        //
        frame.getContentPane().add(panelJudul);
        frame.getContentPane().add(panelForm);
        frame.getContentPane().add(panelSubmit);
        frame.getContentPane().add(panelBack);
        frame.getContentPane().add(bg);

        bg.setVisible(true);

    }

    

}
