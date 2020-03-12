package Model;

import javax.swing.ImageIcon;
import Controller.*;



public class Land extends GameObject implements Tipe {
    private int jalur;
    private String tipe;
    private String url;



    public Land(int koorX, int koorY, int lebar, int tinggi,int jalur, String tipe) {
        super(koorX, koorY, lebar, tinggi);
        this.jalur = jalur;
        this.tipe = tipe;


        if (this.tipe.toLowerCase().equals(ROAD)) {
            if (jalur == 1) {
                this.url = "img/1jalur.png";
            } else if (jalur == 2) {
                this.url = "img/2jalur.png";
            }


        } else if (this.tipe.toLowerCase().equals(RUMPUT)) {
            this.url = "img/rumputt.png";
        }
        else if (this.tipe.toLowerCase().equals(RIVER)) {
            this.url = "img/river.jpg";
        }

        setLocation(koorX, koorY);
        setSize(lebar, tinggi);
        setIcon(new ImageIcon(Controller.resizeImage(url,lebar,tinggi)));






    }

    public int getJalur() {
        return jalur;
    }

    public void setJalur(int jalur) {
        this.jalur = jalur;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }


}
