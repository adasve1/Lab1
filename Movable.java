/**
 * An interface that makes it possible for a car to move.
 * <p>
 * The car can move (along the x-axis), turn left (ascending the y-axis) and turn right (descending the y-axis).
 */

public interface Movable{
    /**
     * An abstract method for moving the car.
     */
    void move();

    /**
     * An abstract method for turning left.
     */
    void turnLeft();

    /**
     * An abstract method for turning right.
     */
    void turnRight();
}