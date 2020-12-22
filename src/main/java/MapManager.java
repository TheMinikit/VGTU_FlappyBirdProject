public class MapManager {

    Bird bird = Bird.getInstance();
    private final PipeGenerator pipes = new PipeGenerator();
    private static MapManager mapManager = null;

    private final int pipeFrequency = 15;
    private final int screenWidth = 25;
    private final int screenHeight = 15;
    private final int mapWidth = 40;
    private final int mapHeight = 15;
    private final int map[][] = new int[mapHeight][mapWidth];

    private MapManager() {
        initializeMap();
    }

    public static MapManager getInstance() {
        if (mapManager == null) {
            mapManager = new MapManager();
        }
        return mapManager;
    }

    private void initializeMap() {
        for (int i = 0; i < mapHeight; i++) {
            for (int i2 = 0; i2 < mapWidth; i2++) {
                map[i][i2] = 0;
            }
        }
    }

    public void printMap() {
        pushMap();
        for (int i = 0; i < screenHeight; i++) {
            for (int i2 = 0; i2 < screenWidth; i2++) {
                if (i == bird.getY() && i2 == bird.getX()) {
                    System.out.print('x');
                } else {
                    System.out.print(map[i][i2]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /*public void printAllMap() {
        for (int i = 0; i < mapHeight; i++) {
            for (int i2 = 0; i2 < mapWidth; i2++) {
                if (i == bird.getY() && i2 == bird.getX()) {
                    System.out.print('x');
                } else {
                    System.out.print(map[i][i2]);
                }
            }
            System.out.println();
        }
    }*/

    public boolean checkPipeCollision() {
        return (map[bird.getY()][bird.getX() + 1] == 1);
    }

    public boolean checkLowerBoundaryCollision() {
        return (bird.getY() + 1 == map.length);
    }

    public boolean checkUpperBoundaryCollision() {
        return (bird.getY() - 1 < 0);
    }

    public void pushMap() {
        for (int i = 0; i < map.length; i++) {
            for (int i2 = 1; i2 < map[0].length; i2++) {
                map[i][i2 - 1] = map[i][i2];
            }
        }
    }

    public void addNewPassage() {
        int[][] newPassage = pipes.createSinglePassage(screenHeight);
        for (int i = 0; i < map.length; i++) {
            for (int i2 = map[0].length - newPassage[0].length - 1; i2 < map[0].length - 1; i2++) {
                map[i][i2] = newPassage[i][i2 - (map[0].length - newPassage[0].length - 1)];
            }
        }
    }

    public void restartMap() {
        initializeMap();
        addNewPassage();
    }

    public void restartAllMap() {
        initializeMap();
    }

    public int getPipeFrequency() {
        return pipeFrequency;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int[][] getMap() {
        return map;
    }
}
