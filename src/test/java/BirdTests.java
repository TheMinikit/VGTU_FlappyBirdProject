import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class BirdTests {

    @Test
    public void birdStartsAtXY5() {
        Bird bird = Bird.getInstance();

        bird.resetBird();

        assertEquals(5, bird.getY());
        assertEquals(5, bird.getX());
    }

    @Test
    public void birdCanDieAtBottom() {
        Bird bird = Bird.getInstance();
        MapManager mm = MapManager.getInstance();

        bird.setY(mm.getMapHeight());
        if (mm.checkLowerBoundaryCollision()) {
            bird.setAlive(false);
        }

        assertFalse(bird.getAlive());
        bird.resetBird();
    }

    @Test
    public void birdCanDieAtTop() {
        Bird bird = Bird.getInstance();
        MapManager mm = MapManager.getInstance();

        bird.setY(1);
        if (mm.checkUpperBoundaryCollision()) bird.setAlive(false);

        assertFalse(bird.getAlive());
        bird.resetBird();
    }

    @Test
    public void birdCanDieAtPipe() {
        Bird bird = Bird.getInstance();
        MapManager mm = MapManager.getInstance();

        mm.addNewPassage();
        bird.setY(2);
        bird.setX(mm.getMapWidth() - 5);
        if (mm.checkPipeCollision()) bird.setAlive(false);

        assertFalse(bird.getAlive());
        bird.resetBird();
        mm.restartAllMap();
    }

    @Test
    public void birdFliesUp() {
        ControlsManager cm = new ControlsManager();
        Bird bird = Bird.getInstance();

        cm.manageGameInput('w');

        assertEquals(4, bird.getY());
        bird.resetBird();
    }

    @Test
    public void birdFallsDown() {
        Bird bird = Bird.getInstance();

        bird.decY();

        assertEquals(6, bird.getY());
        bird.resetBird();
    }


}