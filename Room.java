
public class Room {
    Point topLeft, bottomRight;

    public Room(Point topLeft, Point bottomRight) throws Exception {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        if (topLeft.getX() > bottomRight.getX() || topLeft.getY() > bottomRight.getY())
            throw new Exception("Room corners are invalid");
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public boolean isWall(Point p) {
        if (getTopLeft().getX() == p.getX() && getTopLeft().getY() <= p.getY()
                && getBottomRight().getY() >= p.getY()) // Left Wall
            return true;

        if (getBottomRight().getX() == p.getX() && getBottomRight().getY() >= p.getY()
                && getTopLeft().getY() <= p.getY()) // Right Wall
            return true;

        if (getTopLeft().getY() == p.getY() && getBottomRight().getX() >= p.getX()
                && getTopLeft().getX() <= p.getX()) // Top Wall
            return true;

        if (getBottomRight().getY() == p.getY() && getBottomRight().getX() >= p.getX()
                && getTopLeft().getX() <= p.getX()) // Bottom Wall
            return true;

        return false;
    }

    public boolean isInside(Point p) {
        if (p.getX() > getTopLeft().getX() && p.getX() < getBottomRight().getX() &&
            p.getY() > getTopLeft().getY() && p.getY() < getBottomRight().getY()) {
            return true;
        }

        return false;
    }
}