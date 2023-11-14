package org.exercise;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {
    Point bottomLeft;
    Point upperRight;

    public Rectangle(Point bottomLeft, Point upperRight) {
        this.bottomLeft = bottomLeft;
        this.upperRight = upperRight;
    }
    @Override
    public Point[] intersectionPoints(Shape other) {
        List<Point> intersections = new ArrayList<>();

        if (other instanceof Rectangle otherRectangle) {

            int x1 = Math.max(this.bottomLeft.getX(), otherRectangle.bottomLeft.getX());
            int y1 = Math.max(this.bottomLeft.getY(), otherRectangle.bottomLeft.getY());
            int x2 = Math.min(this.upperRight.getX(), otherRectangle.upperRight.getX());
            int y2 = Math.min(this.upperRight.getY(), otherRectangle.upperRight.getY());

            if (x1 < x2 && y1 < y2) {
                intersections.add(new Point(x1, y1));
                intersections.add(new Point(x2, y2));

                if(!(x2 < otherRectangle.upperRight.getX() && y1 < otherRectangle.upperRight.getY())) {
                    intersections.add(new Point(x2, y1));
                }
                if(!(x1 < this.upperRight.getX() && y2 < this.upperRight.getY())) {
                    intersections.add(new Point(x1, y2));
                }
            }
        }

        return intersections.toArray(new Point[0]);
    }

    public boolean contains(Shape other) {
        if (other instanceof Rectangle otherRectangle) {
            return  otherRectangle.bottomLeft.getX() >= this.bottomLeft.getX() &&
                    otherRectangle.bottomLeft.getY() >= this.bottomLeft.getY() &&
                    otherRectangle.upperRight.getX() <= this.upperRight.getX() &&
                    otherRectangle.upperRight.getY() <= this.upperRight.getY();
        }
        return false;
    }

    public boolean isAdjacent(Shape other) {
        if (other instanceof Rectangle otherRectangle) {
            return this.upperRight.getX() == otherRectangle.bottomLeft.getX() ||
                    this.bottomLeft.getX() == otherRectangle.upperRight.getX() ||
                    this.upperRight.getY() == otherRectangle.bottomLeft.getY() ||
                    this.bottomLeft.getY() == otherRectangle.upperRight.getY();
        }
        return false;
    }
}