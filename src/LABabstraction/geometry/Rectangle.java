package LABabstraction.geometry;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }


    public boolean contains(int x, int y){
        return bottomLeft.getX() <= x && bottomLeft.getY() <= y
                && topRight.getX() >=x && topRight.getY() >= y;
    }
}
