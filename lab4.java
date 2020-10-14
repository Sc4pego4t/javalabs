import java.awt.*;

class Triangle {

    private Point a, b, c;

    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Point getMedianCrossingPoint() {
        return new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
    }

    double getPerimeter() {
        return getDistanceBetweenPoints(a, b) + getDistanceBetweenPoints(b, c) + getDistanceBetweenPoints(c, a);
    }

    double getSquare() {
        return Math.abs(0.5 * (((a.getX() - c.getX()) * (b.getY() - c.getY())) - ((b.getX() - c.getX()) * (a.getY() - c.getY()))));
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    private double getDistanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}

public class lab4 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(0,0), new Point(7,5), new Point(3,2));
        System.out.println(triangle.getSquare());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getA());
    }
}
