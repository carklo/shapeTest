package org.exercise;

import java.util.Scanner;

public class ShapeHandler {

    private Shape shape1;
    private Shape shape2;

    public ShapeHandler(Shape shape1, Shape shape2) {
        this.shape1 = shape1;
        this.shape2 = shape2;
    }

    public void displayIntersection() {
        Point[] intersection = shape1.intersectionPoints(shape2);
        System.out.println("Intersection Points: ");
        for (Point point : intersection) {
            System.out.println(point);
        }
    }

    public void displayContains() {
        boolean contains = shape1.contains(shape2);
        System.out.println("Shape 1 Contains Shape 2: " + contains);
    }

    public void displayAdjacency() {
        boolean isAdjacent = shape1.isAdjacent(shape2);
        System.out.println("Shapes are Adjacent: " + isAdjacent);
    }

    private static Shape createShapeFromInput(Scanner scanner, int shapeType) {
        ShapeFactory shapeFactory = switch (shapeType) {
            case 1 -> new RectangleFactory();
            default -> throw new IllegalArgumentException("Invalid shape type");
        };

        System.out.println("Enter the coordinates for the shape (specific to the shape type):");
        return shapeFactory.createShape(scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of Shape 1 (1) Rectangle, (2) ..:");
        int shapeType1 = scanner.nextInt();
        Shape shape1 = createShapeFromInput(scanner, shapeType1);

        System.out.println("Enter the type of Shape 2 (1) Rectangle, (2) ..:");
        int shapeType2 = scanner.nextInt();
        Shape shape2 = createShapeFromInput(scanner, shapeType2);

        ShapeHandler shapeHandler = new ShapeHandler(shape1, shape2);

        while (true) {
            System.out.println("Choose the method to use: (1) Intersection, (2) Contains, (3) Adjacency, (4) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> shapeHandler.displayIntersection();
                case 2 -> shapeHandler.displayContains();
                case 3 -> shapeHandler.displayAdjacency();
                case 4 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}