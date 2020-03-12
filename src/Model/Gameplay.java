package Model;

public class Gameplay {
    public static Integer score = 0;
    public static Integer nyawa = 5;
    public static int succesAttempt = 0;

    public Gameplay(){
        new Map();
        Map.frame.setVisible(true);

    }
}
