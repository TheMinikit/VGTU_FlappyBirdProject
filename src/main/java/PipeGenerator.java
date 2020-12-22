import java.util.Random;

public class PipeGenerator {

    private final int passageWidth = 5; //Pipes width
    private final int passageHeight = 5; //Height between bottom and top pipes

    public int[][] createSinglePassage(int mapHeight) {
        int[][] passage = new int[mapHeight][passageWidth];
        for (int i = 0; i < mapHeight; i++) {
            for (int i2 = 0; i2 < passageWidth; i2++) {
                passage[i][i2] = 0;
            }
        }
        Random rand = new Random();
        int spawnHeight = rand.nextInt(mapHeight - 2 - passageHeight) + 2; //Bottom of the top pipe
        for (int i = 0; i < spawnHeight; i++) {
            for (int i2 = 1; i2 < passageWidth - 1; i2++) {
                passage[i][i2] = 1;
            }
        }
        passage[spawnHeight - 1][0] = 1;
        passage[spawnHeight - 1][passageWidth - 1] = 1;
        for (int i = spawnHeight + passageHeight; i < mapHeight; i++) {
            for (int i2 = 1; i2 < passageWidth - 1; i2++) {
                passage[i][i2] = 1;
            }
        }
        passage[spawnHeight + passageHeight][0] = 1;
        passage[spawnHeight + passageHeight][passageWidth - 1] = 1;

        return passage;
    }

    public int getPassageWidth() {
        return passageWidth;
    }

    public int getPassageHeight() {
        return passageHeight;
    }
}
