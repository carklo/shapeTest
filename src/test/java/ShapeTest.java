import org.exercise.Point;
import org.exercise.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testIntersectionWithOverlapTwoIntersections() {
        Rectangle rect1 = new Rectangle(new Point(0, -5), new Point(5, 0));
        Rectangle rect2 = new Rectangle(new Point(3, -8), new Point(8, -3));
        Point[] intersection = rect1.intersectionPoints(rect2);
        Point[] expected = {new Point(3, -5), new Point(5, -3)};
        assertTrue(Arrays.asList(expected).containsAll(Arrays.asList(intersection)));
    }

    @Test
    void testIntersectionWithOverlapFourIntersections() {
        Rectangle rect1 = new Rectangle(new Point(0, -6), new Point(8, 0));
        Rectangle rect2 = new Rectangle(new Point(2, -8), new Point(7, 2));
        Point[] intersection = rect1.intersectionPoints(rect2);
        Point[] expected = {new Point(2, -6), new Point(7, 0), new Point(2, 0), new Point(7, -6)};
        assertTrue(Arrays.asList(expected).containsAll(Arrays.asList(intersection)));
    }

    @Test
    void testIntersectionWithoutOverlap() {
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(5, 5));
        Rectangle rect3 = new Rectangle(new Point(10, 10), new Point(15, 15));
        Point[] noIntersection = rect1.intersectionPoints(rect3);
        assertArrayEquals(new Point[0], noIntersection);
    }

    @Test
    public void testIsWhollyContained_WhollyContained() {
        Rectangle outerRectangle = new Rectangle(new Point(1, 1), new Point(6, 6));
        Rectangle innerRectangle = new Rectangle(new Point(2, 2), new Point(4, 4));
        assertTrue(outerRectangle.contains(innerRectangle));
    }

    @Test
    public void testIsWhollyContained_NotWhollyContained() {
        Rectangle outerRectangle = new Rectangle(new Point(1, 1), new Point(6, 6));
        Rectangle nonContainedRectangle = new Rectangle(new Point(7, 7), new Point(9, 9));
        assertFalse(outerRectangle.contains(nonContainedRectangle));
    }

    @Test
    public void testIsWhollyContained_SameBounds() {
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(6, 6));
        assertTrue(rectangle.contains(rectangle));
    }

    @Test
    public void testIsWhollyContained_IntersectingButNotContained() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 1), new Point(5, 5));
        Rectangle rectangle2 = new Rectangle(new Point(4, 4), new Point(8, 8));
        assertFalse(rectangle1.contains(rectangle2));
    }

    @Test
    void testIsAdjacent_SubLine() {
        // Two rectangles sharing a sub-line (e.g., bottom side of rect1 with top side of rect2)
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(5, 5));
        Rectangle rect2 = new Rectangle(new Point(3, 5), new Point(8, 10));
        assertTrue(rect1.isAdjacent(rect2));
    }

    @Test
    void testIsAdjacent_Proper() {
        // Two rectangles sharing a proper side (e.g., right side of rect1 with left side of rect2)
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(5, 5));
        Rectangle rect2 = new Rectangle(new Point(5, 2), new Point(10, 8));
        assertTrue(rect1.isAdjacent(rect2));
    }

    @Test
    void testIsAdjacent_Partial() {
        // Two rectangles sharing a partial side (e.g., top-right corner of rect1 with bottom-right corner of rect2)
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(5, 5));
        Rectangle rect2 = new Rectangle(new Point(5, 2), new Point(8, 8));

        assertTrue(rect1.isAdjacent(rect2));
    }

    @Test
    void testIsNotAdjacent() {
        // Two rectangles that are not adjacent
        Rectangle rect1 = new Rectangle(new Point(0, 0), new Point(5, 5));
        Rectangle rect3 = new Rectangle(new Point(10, 10), new Point(15, 15));
        assertFalse(rect1.isAdjacent(rect3));
    }
}
