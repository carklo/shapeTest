package org.exercise;

public interface Shape {

    Point[] intersectionPoints(Shape other);
    boolean contains(Shape other);
    boolean isAdjacent(Shape other);
}
