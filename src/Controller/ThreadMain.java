package Controller;


import Model.Gameplay;
import Model.Map;


//import Model.Frog;

public class ThreadMain extends Thread {

     static int delay = 10;


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);

                Map.valScore.setText(Gameplay.score.toString());
                Map.valNyawa.setText(Gameplay.nyawa.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
