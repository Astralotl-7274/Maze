public class Corridor extends Room {
    public Corridor(Point topLeft, Point bottomRight) throws Exception {
        super(topLeft, bottomRight);
    }

    public boolean isOpening(Point p) {
        
        // horizontal
        if (getTopLeft().getY() + 2 == getBottomRight().getY() && p.getY() > getTopLeft().getY() && p.getY() < getBottomRight().getY()) {
            if (p.getX() == getTopLeft().getX() || p.getX() == getBottomRight().getX())
            {
                return true;
            }
        }

        // vertical
        if (getTopLeft().getX() + 2 == getBottomRight().getX() && p.getX() > getTopLeft().getX() && p.getX() < getBottomRight().getX()) {
            if (p.getY() == getTopLeft().getY() || p.getY() == getBottomRight().getY())
            {
                return true;
            }
        }

        return false;
    }
}
