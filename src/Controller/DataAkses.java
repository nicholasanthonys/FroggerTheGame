/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Menu;
import View.Frame;
import View.playMusic;
import View.HowPlay;
import View.Login;
import View.Register;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author frans
 */
public class DataAkses extends Frame{

    public static int id_user;
    public static String Username;
    public static String Password;
    public static ArrayList<String> Nama = new ArrayList();
    public static ArrayList<String> Score = new ArrayList();
    Menu m = new Menu();
    
    public static void cekLogin(String username, String password, JFrame frame) {
        try{
            Class.forName(Database.JDBC_DRIVER);
            
            Database.conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
            Database.stmt = Database.conn.createStatement();
            
            String query = "SELECT * FROM user";
            
            try{
                
                Database.rs = Database.stmt.executeQuery(query);
                
                while(Database.rs.next()){
                    if(username.equals(Database.rs.getString("Username"))){
                        DataAkses.id_user = Database.rs.getInt("No");
                        DataAkses.Username = Database.rs.getString("Username");
                        DataAkses.Password = Database.rs.getString("Password");
                    }
                }
                if(password.equals(DataAkses.Password)){
                    JOptionPane.showMessageDialog(null, "Welcome " + DataAkses.Username);
                    frame.dispose();
                    new HowPlay();
                }else{
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void cekRegis(String username, String password, String country, JFrame frame) {
        int cekUser = 0;
        try{
            
            Class.forName(Database.JDBC_DRIVER);
            
            Database.conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
            Database.stmt = Database.conn.createStatement();
            
            String query = "SELECT * FROM user";
            
            try{
                Database.rs = Database.stmt.executeQuery(query);
                
                while(Database.rs.next()){
                    if(username.equals(Database.rs.getString("Username"))){
                        cekUser = Database.rs.getInt("No");
                    }
                }
                if(cekUser==0){
                    String sql = "INSERT INTO user(Username, Password, Country, Score) VALUES('%s','%s','%s','%s')";
                    sql = String.format(sql, username, password, country, cekUser);
                    
                    Database.stmt.execute(sql);
                    JOptionPane.showMessageDialog(null, "Register Berhasil");
                    int go = JOptionPane.showConfirmDialog(null, "Mau Login??");
                    if(go == JOptionPane.YES_OPTION){
                        playMusic.player.close();
                        Register.unVisible();
                        Menu.Go();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Username Sudah Tersedia");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void PrintLeaderboard(){
        ArrayList<Integer> list = new ArrayList();
        ArrayList<String> listnama = new ArrayList();
        ArrayList<String> listscore = new ArrayList();
        
        try{
            Class.forName(Database.JDBC_DRIVER);
            
            Database.conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
            Database.stmt = Database.conn.createStatement();
            
            String query = "SELECT * FROM user";
            
            try{
                Database.rs = Database.stmt.executeQuery(query);
                
                while(Database.rs.next()){
                    list.add(Database.rs.getInt("Score"));
                }
                
                //ngesort data yg ada di list
                Collections.sort(list, Collections.reverseOrder());
                int i = 0;
                
                while(i!=list.size()){
                    Database.rs = Database.stmt.executeQuery(query);
                    while(Database.rs.next()){
                        if(list.get(i)==Database.rs.getInt("Score")){
                            //masukin data ke arraylist
                            listnama.add(Database.rs.getString("Username"));
                            listscore.add(String.valueOf(Database.rs.getInt("Score")));
                        }
                    }
                    i++;
                }
                DataAkses.isilead(listnama, listscore);
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //method buat masukin data ke arraylist yg dikirim ke database
    public static void isilead(ArrayList<String> list1, ArrayList<String> list2){
        DataAkses.Nama = list1;
        DataAkses.Score = list2;
    }
    
    public static void updatescore(int score, int id){
        try{
            
            Class.forName(Database.JDBC_DRIVER);
            
            Database.conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
            Database.stmt = Database.conn.createStatement();
            
            String query = "UPDATE user SET Score = %d WHERE No = %d";
            query = String.format(query, score, id);
            Database.stmt.execute(query);
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
