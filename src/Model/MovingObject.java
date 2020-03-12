package Model;

import javax.swing.*;
import Controller.*;

public class MovingObject extends  GameObject implements  Tipe {

    private int xSpawn ;
    private int ySpawn ;
    private int velX ;
    private int velY ;
    private String url;
    private String tipe;

     MovingObject(int koorX, int koorY, int lebar, int tinggi, int xSpawn, int ySpawn, int velX,String tipe) {

        super(koorX, koorY, lebar, tinggi);

        this.xSpawn = xSpawn;
        this.ySpawn = ySpawn;
        this.velX = velX;
        this.tipe = tipe;

        if (this.tipe.toLowerCase().equals(MOBIL)) {
            if(this.velX > 0){
                this.url = "img/yellowCarGoRight.png";
            }
            else{
                this.url = "img/yellowCarGoLeft.png";
            }

        }
        else if (this.tipe.toLowerCase().equals(LOG)) {
            this.url = "img/log2-min.png";
        } else if (this.tipe.toLowerCase().equals(RIVER)) {
            this.url = "img/river.jpg";
        } else if (this.tipe.toLowerCase().equals(SAFEPLACE)) {
            this.url = "img/bg5.png";
        } else if (this.tipe.toLowerCase().equals(BUAYA)) {
            if (this.velX > 0) {
                this.url = "img/buaya2Right.png";
            } else {
                this.url = "img/buaya2Left.png";
            }

        } else if (this.tipe.toLowerCase().equals(DAUN)) {
            this.url = "img/daun.png";
        }
        else if (this.tipe.toLowerCase().equals("kodok")){
            this.url = "img/frog.png";
        }

        setLocation(koorX, koorY);
        setSize(lebar, tinggi);
        setIcon(new ImageIcon(Controller.resizeImage(this.url,lebar,tinggi)));

    }

    public int getxSpawn() {
        return xSpawn;
    }

    public void setxSpawn(int xSpawn) {
        this.xSpawn = xSpawn;
    }

    public int getySpawn() {
        return ySpawn;
    }

    public void setySpawn(int ySpawn) {
        this.ySpawn = ySpawn;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
