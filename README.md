# Shape Handler Program

The Shape Handler program allows users to perform geometric operations (intersection, containment, adjacency) on different shapes such as rectangles. This program is implemented in Java and can be built and run using Maven.

## Prerequisites

- Java Development Kit (JDK) installed
- Apache Maven installed

## Getting Started

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/shape-handler.git
    ```

2. Navigate to the project directory:

    ```bash
    cd shape-handler
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the program:

    ```bash
    java -jar target/shape-handler.jar
    ```

## Usage

Upon running the program, you will be prompted to enter the type and coordinates of two shapes. Currently, the program supports rectangles and circles. Follow the on-screen instructions to provide the necessary input.

### Choosing Shape Types

- For Rectangle, enter `1`.

### Entering Coordinates

For each shape, you will be prompted to enter the coordinates. The coordinates specify the position of the shape in the Cartesian plane. Depending on the shape type, you may need to provide additional information.

#### Rectangle

- Enter the x and y coordinates for the bottom-left corner.
- Enter the x and y coordinates for the upper-right corner.

### Performing Operations

After entering the shape types and coordinates, you can choose from the following operations:

1. **Intersection**: Find the intersection points between two shapes.

2. **Contains**: Check if one shape contains the other.

3. **Adjacency**: Check if two shapes are adjacent.

4. **Exit**: Terminate the program.

Follow the on-screen instructions to make your selection.
