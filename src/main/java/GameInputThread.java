import java.io.IOException;

public class GameInputThread extends Thread {

    private final ControlsManager controls = new ControlsManager();
    GameManager gm = GameManager.getInstance();
    private final ConsoleInput console = new ConsoleInput();
    Bird bird = Bird.getInstance();
    private int inputKey = 0;


    public synchronized void run() {
        while (1 == 1) {
            while (bird.getAlive()) {
                try {
                    inputKey = requestInputKey();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                controls.manageGameInput(inputKey);
            }
            try {
                inputKey = requestInputKey();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controls.manageGameOverInput(inputKey, gm.getScore());
            gm.setPlaytime(true);
        }
    }

    public int requestInputKey() throws IOException {
        return console.readConsoleInput();
    }

}
