package Model;

import View.SoundEffect;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frog extends MovingObject implements KeyListener {

    private int velY;

     Frog(int koorX, int koorY, int lebar, int tinggi, int xSpawn, int ySpawn, int velX, int velY, String tipe) {
        super(koorX, koorY, lebar, tinggi, xSpawn, ySpawn, velX,  tipe);
        this.velY = velY;

        addKeyListener(this);
        setFocusable(true);

    }







    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            new SoundEffect("music/boing.wav");
            setKoorY(getKoorY()-getVelY());
            setLocation(getKoorX(), getKoorY());
            Gameplay.score += 100;



        }
        if (code == KeyEvent.VK_DOWN) {
            if (getKoorY() != 650) {
                new SoundEffect("music/boing.wav");
                setKoorY(getKoorY() + getVelY());
                setLocation(getKoorX(),getKoorY());
                Gameplay.score -=50;

            }



        }
        if (code == KeyEvent.VK_LEFT) {
            if (getKoorX() != 25) {
                new SoundEffect("music/boing.wav");
                setKoorX(getKoorX()-getVelX());
                setLocation(getKoorX(), getKoorY());

            }



        }
        if (code == KeyEvent.VK_RIGHT) {
            if (getKoorX() != 725) {
                new SoundEffect("music/boing.wav");
                setKoorX(getKoorX() + getVelX());
                setLocation(getKoorX(), getKoorY());

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public int getVelY() {
        return velY;
    }

    @Override
    public void setVelY(int velY) {
        this.velY = velY;
    }
}
