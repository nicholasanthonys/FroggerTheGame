package Controller;


import Model.Frog;
import Model.Gameplay;
import Model.Map;
import Model.MovingObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {

    public static Image resizeImage(String url,int lebar, int tinggi) {
        Image dimg = null;


        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace(System.err);

        }
        return dimg;
    }


     static boolean collitionBetweenTwoObject(Frog frog, MovingObject obs) {
        return (obs.getKoorX() <= frog.getKoorX() + frog.getLebar() && obs.getKoorX() + obs.getLebar() >= frog.getKoorX() && obs.getKoorY() < frog.getKoorY() + frog.getTinggi() && obs.getKoorY() + obs.getTinggi() > frog.getKoorY());
    }

    static void showDeathImage() {
        try {
            Map.frog.setIcon(new ImageIcon(Controller.resizeImage("img/dead.png", Map.frog.getLebar(), Map.frog.getTinggi())));
            Map.frog. setEnabled(false);
            Thread.sleep(3000);
            Map.frog.setIcon(new ImageIcon(Controller.resizeImage("img/Frog.png", Map.frog.getLebar(), Map.frog.getTinggi())));
            Gameplay.nyawa -= 1;
            System.out.println("nyawa : " + Gameplay.nyawa);
            Gameplay.score -=400;
            resetFrog();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void resetFrog() {
        try {
            Map.frog.setKoorX( Map.frog.getxSpawn());
            Map.frog. setKoorY( Map.frog.getySpawn());
            Map.frog.setLocation( Map.frog.getKoorX(),  Map.frog.getKoorY());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map.frog.setEnabled(true);
    }

}

