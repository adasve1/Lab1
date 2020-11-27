import java.awt.*;

/**
 * A default class Car
 */
public abstract class Car extends MotorVehicle {

    public Car(int nrDoors, double enginePower, Color color, String modelName, double xPosition, double yPosition, int startDirection, double length, double width) {
        super(nrDoors, enginePower, color, modelName, xPosition, yPosition, startDirection, length, width);

    }

}
