package Model;
 
import javax.swing.JLabel;

public abstract  class GameObject extends JLabel
{
    private int koorX;
    private int koorY;
    private int lebar;
    private int tinggi;


     GameObject(int koorX, int koorY, int lebar, int tinggi) {
        this.koorX = koorX;
        this.koorY = koorY;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public int getKoorX() {
        return koorX;
    }

    public void setKoorX(int koorX) {
        this.koorX = koorX;
    }

    public int getKoorY() {
        return koorY;
    }

    public void setKoorY(int koorY) {
        this.koorY = koorY;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }
    
}
