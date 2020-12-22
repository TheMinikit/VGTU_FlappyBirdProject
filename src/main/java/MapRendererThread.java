public class MapRendererThread extends Thread {

    GameManager gm = GameManager.getInstance();
    MapManager mapmanager = MapManager.getInstance();
    Bird bird = Bird.getInstance();

    public synchronized void run() {
        while(1 == 1) {
            try {
                while (bird.getAlive()) {
                    bird.decY();
                    bird.decSpeed();
                    if (gm.getCounter() % mapmanager.getPipeFrequency() == 0) mapmanager.addNewPassage();
                    mapmanager.printMap();
                    if (mapmanager.checkPipeCollision() || mapmanager.checkLowerBoundaryCollision() || mapmanager.checkUpperBoundaryCollision()) bird.setAlive(false);
                    gm.incCounter();
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            gm.calculateScore();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Game finished.");
            System.out.println("Your score is: " + gm.getScore() + " pipes!");
            System.out.println();
            System.out.println("'r' to restart the game");
            System.out.println("'l' to view the leaderboard");
            System.out.println("'q' to quit the game");
            System.out.print("Your input: ");
            gm.setCounter(0);
            gm.setPlaytime(false);
            while(!gm.getPlaytime()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
