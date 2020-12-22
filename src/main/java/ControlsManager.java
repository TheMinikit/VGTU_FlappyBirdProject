public class ControlsManager {

    Bird bird = Bird.getInstance();
    MapManager mapmanager = MapManager.getInstance();
    GameManager gamemanager = GameManager.getInstance();

    public void manageGameInput(int key) {
        switch (key) {
            case 'w':
                bird.incY();
                bird.incSpeed();
                break;
            case 'q':
                java.lang.System.exit(0);
                break;
            default:
                break;
        }

    }

    public void manageGameOverInput(int key, int Score) {
        gamemanager.saveScore(Score);
        switch (key) {
            case 'r':
                mapmanager.restartMap();
                gamemanager.resetBird();
                break;
            case 'l':
                gamemanager.getScores();
                break;
            case 'q':
                java.lang.System.exit(0);
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
}
