public class Player extends Point {
    public Player(int x, int y) {
        super(x, y);
    }

    public void moveUp() {
        this.y = this.y - 1;
    }
    public void moveDown() {
        this.y = this.y + 1;
    }
    public void moveLeft() {
        this.x = this.x - 1;
    }
    public void moveRight() {
        this.x = this.x + 1;
    }

}
