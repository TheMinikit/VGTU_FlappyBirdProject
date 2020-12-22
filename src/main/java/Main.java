public class Main {

    public static void main(String args[]) {
        MapRendererThread mapThread = new MapRendererThread();
        GameInputThread inputThread = new GameInputThread();

        mapThread.start();
        inputThread.start();
    }
}
