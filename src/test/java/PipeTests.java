import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PipeTests {

    PipeGenerator pg = new PipeGenerator();
    MapManager mm = MapManager.getInstance();


    @Test
    public void pipeHasCorrectPassageHeight() {
        int[][] map;
        int height = 0;

        map = pg.createSinglePassage(mm.getMapHeight());
        for(int i = 0; i < mm.getMapHeight(); i++) {
            if(map[i][pg.getPassageWidth() / 2] == 0) {
                height++;
            }
        }

        assertEquals(pg.getPassageHeight(), height);
    }

    @Test
    public void pipePassageGeneratesRandomly() {
        int[][] pipes1;
        int[][] pipes2;
        int[][] pipes3;
        boolean isDifferent = true;

        pipes1 = pg.createSinglePassage(mm.getMapHeight());
        pipes2 = pg.createSinglePassage(mm.getMapHeight());
        pipes3 = pg.createSinglePassage(mm.getMapHeight());

        if(pipes1 == pipes2) isDifferent = false;
        if(pipes1 == pipes3) isDifferent = false;
        if(pipes2 == pipes3) isDifferent = false;

        assertTrue(isDifferent);
    }

    @Test
    public void pipeIsTShaped() {
        int[][] map;
        int counter = 0;

        map = pg.createSinglePassage(mm.getMapHeight());
        for(int i = 0; i < mm.getMapHeight(); i++) {
            if(map[i][0] == 1) counter++;
            if(map[i][pg.getPassageWidth() - 1] == 1) counter++;
        }

        assertEquals(4, counter);
    }
}
