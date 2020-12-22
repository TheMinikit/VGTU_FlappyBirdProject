import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GameManager {

    private static GameManager gm = null;
    Bird bird = Bird.getInstance();
    MapManager mapmanager = MapManager.getInstance();

    private int counter = 0;
    private boolean isPlaytime = true;
    private int Score = 0;

    public static GameManager getInstance() {
        if (gm == null) {
            gm = new GameManager();
        }
        return gm;
    }

    public void resetBird() {
        bird.setAlive(true);
        bird.setY(5);
    }

    public void saveScore(int Score) {

        String[] scoreDates = new String[50];
        int[] scores = new int[50];

        try {
            int i = 0;
            Scanner scanner = new Scanner(new File("Scores.txt"));
            while (scanner.hasNext()) {
                scoreDates[i] = scanner.next();
                scores[i] = scanner.nextInt();
                i++;
            }
            String tempString;
            int tempInt;
            for (int i2 = 0; i2 < i - 1; i2++) {
                for (int i3 = i2; i3 < i; i3++) {
                    if (scores[i3] > scores[i2]) {
                        tempString = scoreDates[i2];
                        tempInt = scores[i2];
                        scoreDates[i2] = scoreDates[i3];
                        scoreDates[i3] = tempString;
                        scores[i2] = scores[i3];
                        scores[i3] = tempInt;
                    }
                }
            }
            File scoresFile = new File("Scores.txt");
            FileWriter fileWriter;
            fileWriter = new FileWriter(scoresFile, true);
            fileWriter.write(java.time.LocalDate.now() + " " + Score + "\n");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Caught Exception: ");
            e.printStackTrace();
        }
    }

    public void getScores() {
        String loadedScore;
        try {
            Scanner scanner = new Scanner(new File("Scores.txt"));
            while (scanner.hasNext()) {
                loadedScore = scanner.nextLine();
                System.out.println(loadedScore);
            }
        } catch (Exception e) {
            System.out.println("Caught an Exception: ");
            e.printStackTrace();
        }
    }

    public void incCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int c) {
        counter = c;
    }

    public boolean getPlaytime() {
        return isPlaytime;
    }

    public void setPlaytime(boolean playtime) {
        isPlaytime = playtime;
    }

    public void calculateScore() {
        Score = (gm.getCounter() - 8) / mapmanager.getPipeFrequency();
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

}
