package Controller;

import Model.Gameplay;
import Model.Map;
import Model.MovingObject;
import View.Lose;
import View.SoundEffect;
import View.playMusic;



import javax.swing.*;

public class ThreadFrog extends Thread {

     static int delay = 20;

    public void run() {
        while (Gameplay.nyawa > 0) {
            try {
                Thread.sleep(delay);

                boolean ketemu;


                if (Map.frog.getKoorY() < Map.river.getTinggi()) {
                    ketemu = false;

                    for (MovingObject i : Map.arrLog) {

                        if (Map.frog.getKoorY() == (i.getKoorY())) {

                            if (Controller.collitionBetweenTwoObject(Map.frog,i)) {
                                Map.frog.setLocation(i.getKoorX(), i.getKoorY());
                                Map.frog.setKoorX(i.getKoorX());

                                ketemu = true;
                                if (i.getTipe().equals("safeplace")) {
                                    new SoundEffect("music/win.wav");
                                    Gameplay.succesAttempt += 1;
                                   Gameplay.score +=1000;
                                    System.out.println("safeplace counter " + Gameplay.succesAttempt);

                                    //percepat obstacle
                                    ThreadMovingObject.percepat();

                                    System.out.println("score : " + Gameplay.score);
                                    Map.frog.setEnabled(false);
                                    Thread.sleep(2000);
                                   Controller.resetFrog();

                                    break;
                                } else if (i.getTipe().equals("buaya")) {
                                    new SoundEffect("music/lose.wav");
                                    Controller.showDeathImage();
                                    Controller.resetFrog();
                                }


                                if (Map.frog.getKoorX() >= 760 || Map.frog.getKoorX() <= 0 - Map.frog.getLebar() / 2) { //kalo lagi di kayu terus keseret keluar layar
                                    System.out.println("kelebihan woy");
                                    Controller.showDeathImage();

                                    if (Gameplay.nyawa == 0) {
                                        System.out.println(" game over ");
                                    }

                                    Controller.resetFrog();
                                    break;

                                }

                            }
                        }
                    }

                    if (!ketemu) {
                        System.out.println(" anda tenggelam");
                        Controller.showDeathImage();
                    }

                } else {
                    for (MovingObject i : Map.arrMobil) {
                        if (Controller.collitionBetweenTwoObject(Map.frog,i)) {
                            new SoundEffect("music/lose.wav");
                            Controller.showDeathImage();
                            if (Gameplay.nyawa == 0) {
                                System.out.println(" game over ");
                            }
                            Controller.resetFrog();
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("anda kalah -- GAMEOVER");
        JOptionPane.showMessageDialog(null, "Anda Kalah!");
        DataAkses.updatescore(Gameplay.score, DataAkses.id_user);
        playMusic.player.close();
        Map.frame.setVisible(false);
        new Lose();
        //kalo kalah
        Map.frog.setEnabled(false);
    }

}
