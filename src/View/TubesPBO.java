/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Ferani
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static View.Frame.frame;

/**
 *
 * @author Ferani
 */
public class TubesPBO {

    public static void main(String[] args) {
        //new TubesPBO();
        //new Menu();
//        new HowPlay();
        //new Lose();
        //new Win();
        new Menu();
        
    }
    
    public TubesPBO(){
        frame.addWindowListener(new WindowAdapter() {

           @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Welcome to Frogger the Game!");
            }
        
        });
    }
        


}
