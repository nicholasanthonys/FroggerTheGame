package Model;

import Controller.ThreadFrog;
import Controller.ThreadMain;
import Controller.ThreadMovingObject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.ArrayList;


public class Map extends JFrame {

    public static JFrame frame;
    private JPanel pnlPanel1;
    private JLabel lblScore;
    private JLabel lblNyawa;

    public static JLabel valScore;
    public static JLabel valNyawa;
    public static Frog frog;
    public static ArrayList<MovingObject> arrMobil = new ArrayList<>();
    public static ArrayList<MovingObject> arrLog = new ArrayList<>();
    public static Land river;

    private static Integer score = 0;


     Map() {

        initComponent();
        ThreadMain tMap = new ThreadMain();
        tMap.start();

        ThreadFrog tfrog = new ThreadFrog();
        tfrog.start();

        ThreadMovingObject tObstacle = new ThreadMovingObject();
        tObstacle.start();
    }

    private void initComponent() {


        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);

        frame.setTitle(" frogger the game ");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(800, 800);
        pnlPanel1.setLayout(null);

        frame.add(pnlPanel1);


        frog = new Frog(25, 650, 50, 50, 25, 650, 100, 50, "kodok");
        pnlPanel1.add(frog);


        lblScore = new JLabel("Score");
        lblScore.setFont(new Font("Verdana", Font.BOLD, 16));
        lblScore.setBounds(700, -10, 100, 50);
        pnlPanel1.add(lblScore);


        valScore = new JLabel(score.toString());
        valScore.setFont(new Font("Verdana", Font.BOLD, 16));
        valScore.setBounds(700, 20, 100, 50);
        pnlPanel1.add(valScore);

        lblNyawa = new JLabel("Nyawa");
        lblNyawa.setFont(new Font("Verdana", Font.BOLD, 16));
        lblNyawa.setBounds(10, -10, 100, 50);
        pnlPanel1.add(lblNyawa);

        valNyawa = new JLabel(Gameplay.nyawa.toString());
        valNyawa.setFont(new Font("Verdana", Font.BOLD, 16));
        valNyawa.setBounds(10, 20, 100, 50);
        pnlPanel1.add(valNyawa);


      //      mobil lv 1
        arrMobil.add(new MovingObject(0, 600, 50, 50, 0, 600, -1,  "mobil"));
        arrMobil.add(new MovingObject(375, 600, 50, 50, 0, 600, -1,  "mobil"));
        arrMobil.add(new MovingObject(725, 600, 50, 50, 0, 600, -1,  "mobil"));


              //mobil lv 2
        arrMobil.add(new MovingObject(0, 500, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(175, 500, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(525, 500, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(700, 500, 50, 50, 0, 600, 2,  "mobil"));


            //mobil lv3
        arrMobil.add(new MovingObject(0, 400, 50, 50, 0, 600, -3,  "mobil"));
        arrMobil.add(new MovingObject(350, 400, 50, 50, 0, 600, -3,  "mobil"));
        arrMobil.add(new MovingObject(700, 400, 50, 50, 0, 600, -3,  "mobil"));

        arrMobil.add(new MovingObject(0, 350, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(175, 350, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(350, 350, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(525, 350, 50, 50, 0, 600, 2,  "mobil"));
        arrMobil.add(new MovingObject(700, 350, 50, 50, 0, 600, 2,  "mobil"));


        for (MovingObject i : arrMobil) {

            pnlPanel1.add(i);

        }

        //        //level 1
        arrLog.add(new MovingObject(0, 250, 50, 50, 0, 250, 1,  "log"));
        arrLog.add(new MovingObject(125, 250, 100, 50, 125, 250, 1,  "buaya"));
        arrLog.add(new MovingObject(350, 250, 50, 50, 350, 250, 1,  "log"));
        arrLog.add(new MovingObject(475, 250, 50, 50, 475, 250, 1,  "log"));
        arrLog.add(new MovingObject(600, 250, 50, 50, 600, 250, 1,  "log"));


           //level 2
        arrLog.add(new MovingObject(800, 200, 50, 50, 800, 200, -2, "log"));
        arrLog.add(new MovingObject(925, 200, 100, 50, 925, 200, -2,  "buaya"));
        arrLog.add(new MovingObject(1050, 200, 50, 50, 1050, 200, -2,  "log"));
        arrLog.add(new MovingObject(1175, 200, 50, 50, 1175, 200, -2,  "log"));
        arrLog.add(new MovingObject(1300, 200, 100, 50, 1300, 200, -2,  "buaya"));


        //level 3

        arrLog.add(new MovingObject(0, 100, 100, 50, 0, 100, 1,  "buaya"));
        arrLog.add(new MovingObject(200, 100, 50, 50, 200, 100, 1,  "log"));
        arrLog.add(new MovingObject(325, 100, 50, 50, 325, 100, 1,  "log"));
        arrLog.add(new MovingObject(450, 100, 50, 50, 450, 100, 1,  "log"));


        arrLog.add(new MovingObject(200, 150, 50, 50, 200, 150, 0,  "daun"));
        arrLog.add(new MovingObject(400, 150, 50, 50, 400, 150, 0,  "daun"));
        arrLog.add(new MovingObject(600, 150, 50, 50, 600, 150, 0,  "daun"));

        arrLog.add(new MovingObject(0, 50, 50, 50, 0, 50, -2,  "log"));
        arrLog.add(new MovingObject(100, 50, 100, 50, 100, 50, -2,  "buaya"));
        arrLog.add(new MovingObject(250, 50, 50, 50, 250, 50, -2,  "log"));
        arrLog.add(new MovingObject(375, 50, 50, 50, 375, 50, -2,  "log"));
        arrLog.add(new MovingObject(500, 50, 50, 50, 500, 50, -2,  "log"));
        arrLog.add(new MovingObject(625, 50, 100, 50, 625, 50, -2,  "buaya"));


        //safeplace
        for (int i = 1; i <= 5; i++) {
            arrLog.add(new MovingObject(125 * i, 0, 50, 50, 125 * i, 0, 0,  "safeplace"));


        }


        for (MovingObject i : arrLog) {
            pnlPanel1.add(i);

        }






        //background River
        river = new Land(0, 0, 800, 300, 0, "river");
        pnlPanel1.add(river);

        Land jLevel1 = new Land(0, 600, 800, 50, 1, "road");
        pnlPanel1.add(jLevel1);


        Land jLevel2 = new Land(0, 500, 800, 50, 1, "road");
        pnlPanel1.add(jLevel2);

        Land jLevel3 = new Land(0, 350, 800, 100, 2, "road");
        pnlPanel1.add(jLevel3);

        Land rumputLv1 = new Land(0, 650, 800, 50, 1, "rumput");
        pnlPanel1.add(rumputLv1);

        Land rumputLv2 = new Land(0, 550, 800, 50, 1, "rumput");
        pnlPanel1.add(rumputLv2);

        Land rumputLv3 = new Land(0, 450, 800, 50, 1, "rumput");
        pnlPanel1.add(rumputLv3);

        Land rumputLv4 = new Land(0, 300, 800, 50, 1, "rumput");
        pnlPanel1.add(rumputLv4);

    }

    public static Integer getScore() {
        return score;
    }

    public static void setScore(Integer score) {
        Map.score = score;
    }
}

