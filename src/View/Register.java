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
public class Register{

    public static JPanel panelJudul, panelForm, panelSubmit;
    JPanel panelBack;
    JLabel labelJudul, username, password, country;
    Font font;
    JTextField fieldUser;
    JPasswordField fieldPass;
    JButton submit, back, login;
    JComboBox pilih;
    ImageIcon icon;
    public static boolean cek = false;
    
    
    public Register(final JFrame frame, JPanel bg) {

        //judul
        Register.panelJudul = new JPanel();
        Register.panelJudul.setBounds(0, 90, 500, 100);
        Register.panelJudul.setBackground(new Color(255, 255, 255, 0));

        font = new Font("Copperplate Gothic Bold", Font.BOLD, 48);
        labelJudul = new JLabel("Register");
        labelJudul.setForeground(new Color(255, 255, 255));
        labelJudul.setFont(font);

        //PanelForm
        Register.panelForm = new JPanel(new GridLayout(3, 1));
        Register.panelForm.setBounds(40, 200, 350, 80);
        Register.panelForm.setBackground(new Color(0, 255, 0, 10));

        //label
        username = new JLabel("Username ");
        username.setForeground(Color.black);
        fieldUser = new JTextField(20);

        password = new JLabel("Password");
        password.setForeground(Color.black);
        fieldPass = new JPasswordField(10);

        country = new JLabel("Country");
        country.setForeground(Color.black);

        Object arpilih[] = {"indonesia", "english"};
        pilih = new JComboBox(arpilih);

        Register.panelSubmit = new JPanel();
        Register.panelSubmit.setBounds(210, 290, 130, 40);
        Register.panelSubmit.setBackground(new Color(255, 255, 255, 0));

        submit = new JButton("Register");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setPreferredSize(new Dimension(130, 40));

        //back Button
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
        
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fieldUser.getText();
                String password = new String(fieldPass.getPassword());
                String country = (String)pilih.getSelectedItem();
                
                DataAkses.cekRegis(username, password, country, frame);
                if(Register.cek == true){
                    unVisible();
                    new Login(frame, panelBack);
                }
                
            }
        });
        
        //
        Register.panelForm.add(username);
        Register.panelForm.add(fieldUser);
        Register.panelForm.add(password);
        Register.panelForm.add(fieldPass);
        Register.panelForm.add(country);
        Register.panelForm.add(pilih);

        Register.panelJudul.add(labelJudul);

        Register.panelSubmit.add(submit);

        panelBack.add(back);

        frame.getContentPane().add(Register.panelSubmit);
        frame.getContentPane().add(Register.panelForm);
        frame.getContentPane().add(Register.panelJudul);
        frame.getContentPane().add(panelBack);
        frame.getContentPane().add(bg);

        bg.setVisible(true);
    }
    
    public static void unVisible(){
        Register.panelForm.setVisible(false);
        Register.panelJudul.setVisible(false);
        Register.panelSubmit.setVisible(false);
    }
    
}
