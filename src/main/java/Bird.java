public class Bird {

    private int x = 5;
    private int y = 5;
    private int speed = 0;
    private boolean isAlive = true;

    private static Bird bird = null;

    public static Bird getInstance() {
        if (bird == null) {
            bird = new Bird();
        }
        return bird;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int pos) {
        x = pos - 1;
    }

    public void setY(int pos) {
        y = pos - 1;
    }

    public void incY() {
        y--;
    }

    public void decY() {
        y++;
    }

    public int getSpeed() {
        return speed;
    }

    public void decSpeed() {
        speed--;
    }

    public void incSpeed() {
        speed += 2;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean state) {
        isAlive = state;
    }

    public void resetBird() {
        this.x = 5;
        this.y = 5;
        this.isAlive = true;
    }

}
