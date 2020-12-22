import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MapTests {

    @Test
    public void mapShouldClear() {
        MapManager mm = MapManager.getInstance();
        boolean isClear = true;

        mm.restartAllMap();
        for (int i = 0; i < mm.getMapHeight(); i++) {
            for (int i2 = 0; i2 < mm.getMapWidth(); i2++) {
                if (mm.getMap()[i][i2] == 1) isClear = false;
            }
        }

        assertTrue(isClear);
    }

    @Test
    public void mapGeneratesUpperPipe() {
        MapManager mm = MapManager.getInstance();

        mm.addNewPassage();

        assertEquals(1, mm.getMap()[1][mm.getMapWidth() - 3]);
        mm.restartAllMap();
    }

    @Test
    public void mapGeneratesLowerPipe() {
        MapManager mm = MapManager.getInstance();

        mm.addNewPassage();

        assertEquals(1, mm.getMap()[mm.getMapHeight() - 1][mm.getMapWidth() - 3]);
        mm.restartAllMap();
    }

    @Test
    public void mapIsPushed() {
        MapManager mm = MapManager.getInstance();

        mm.addNewPassage();
        mm.pushMap();

        assertEquals(0, mm.getMap()[mm.getMapHeight() - 1][mm.getMapWidth() - 3]);
        mm.restartAllMap();
    }
}
