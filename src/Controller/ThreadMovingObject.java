package Controller;


import Model.Gameplay;
import Model.MovingObject;
import Model.Map;

public class ThreadMovingObject extends Thread {
    private static int delay = 10;

    public static void setDelay(int delay) {
        ThreadMovingObject.delay = delay;
    }

     static void percepat() {

        if (Gameplay.succesAttempt % 5 == 0) {
            if (delay - 1 > 0 && ThreadFrog.delay - 1 > 0 && ThreadMain.delay - 1 > 0) {
                delay -= 1;
                ThreadFrog.delay -= 1;
                ThreadMain.delay -= 1;

            }
        }

    }

    @Override
    public void run() {

        while (true) {
            try {

                Thread.sleep(delay);
                for (MovingObject i : Map.arrLog) {

//                    i.koorX += i.velX;
                    i.setKoorX(i.getKoorX() + i.getVelX());
                    i.setLocation(i.getKoorX(), i.getKoorY());

//                    i.setLocation(i.koorX, i.koorY);

                    if (i.getVelX() > 0) {
                        if (i.getKoorX() > 800) {
                            i.setKoorX(-100);
//                            i.koorX = 0 - 100;
                        }
                    } else {
                        if (i.getKoorX() < -100) {
                            i.setKoorX(800);
//                            i.koorX = 800;
                        }
                    }

                }

                for (MovingObject i : Map.arrMobil) {
                    i.setKoorX(i.getKoorX() + i.getVelX());
//                    i.koorX += i.velX;
                    i.setLocation(i.getKoorX(), i.getKoorY());
//                    i.setLocation(i.koorX, i.koorY);


                    if (i.getVelX() > 0) {
                        if (i.getKoorX() > 800) {
                            i.setKoorX(-100);
//                            i.koorX = 0 - 100;
                        }
                    } else {
                        if (i.getKoorX() < -100) {
                            i.setKoorX(800);
//                            i.koorX = 800;
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
