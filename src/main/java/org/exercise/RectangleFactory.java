package org.exercise;

import java.util.Scanner;

public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape(Scanner scanner) {
        int bottomLeftX = scanner.nextInt();
        int bottomLeftY = scanner.nextInt();
        int upperRightX = scanner.nextInt();
        int upperRightY = scanner.nextInt();
        return new Rectangle(new Point(bottomLeftX, bottomLeftY), new Point(upperRightX, upperRightY));
    }
}
