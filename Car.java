import java.awt.*;

/**
 * A class that represents a car.
 */

public class Car implements Movable {
    /**
     * Number of doors on the car.
     */
    private int nrDoors; // Number of doors on the car
    /**
     * Engine power of the car.
     */
    private double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */
    private double currentSpeed; // The current speed of the car
    /**
     *Color of the car.
     */
    private Color color; // Color of the car
    /**
     *The model name of the car.
     */
    private final String modelName; // The car model name
    /**
     * X-coordinate starting position.
     */
    private double xPosition; //x-coordinate starting position
    /**
     * Y-coordinate starting position.
     */
    private double yPosition; //y-coordinate starting position

    /**
     * The current direction of the car
     */
    private int direction;

    private final int[] xDirection = {1,0,-1,0}; //pos 0 is "forward" in x-direction
    private final int[] yDirection = {0,-1,0,1}; //pos 3 is "forward" in y-direction

    /**
     * Initializes a car.
     *
     * @param nrDoors the number of doors of the car.
     * @param enginePower the engine power of the car.
     * @param currentSpeed the current speed of the car.
     * @param color the color of the car.
     * @param modelName the model name of the car.
     * @param xPosition the x-coordinate of the car.
     * @param yPosition the y-coordinate of the car.
     * @param startDirection the start direction of the car.
     */

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPosition, double yPosition,int startDirection){
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.currentSpeed=currentSpeed;
        this.color=color;
        this.modelName=modelName;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.direction=startDirection;
    }

    //Getters

    /**
     * Returns the number of doors of the car.
     *
     * @return the number of doors the car have.
     */
    int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power of the car.
     *
     * @return the engine power of the car.
     */
    double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the car.
     *
     * @return the speed of the car.
     */
    double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the color of the car.
     *
     * @return the color of the car.
     */
    Color getColor(){
        return color;
    }


    /**
     * Get the x-coordinate of the position of the car.
     *
     * @return the x-coordinate of the position of the car.
     */
    public double getXPosition(){
        return xPosition;
    }

    /**
     * Get the y-coordinate of the position of the car.
     *
     * @return the y-coordinate of the position of the car.
     */
    public double getYPosition(){
        return yPosition;
    }

    /**
     * Get the current direction of the car.
     * @return index of direction.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Returns for which indexes the car moves in x-direction.
     * @return array with indexes whether the car moves in x-direction or not.
     */
    public int[] getXDirection(){
        return xDirection;
    }

    /**
     * Returns for which indexes the car moves in y-direction.
     * @return array with indexes whether the car moves in y-direction or not.
     */
    public int[] getYDirection(){
        return yDirection;
    }

    //Setters

    /**
     * Changes the color of the car.
     *
     * @param clr the new color of the car.
     */
    void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the speed to 0.1.
     */
    void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the speed to 0.
     */
    void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Set the direction of the car.
     *
     * @param index in which of four directions the car should move
     */
    public void setDirection(int index){
        direction=index;
    }


    /**
     * Moves the car according to its speed and its direction.
     */
    @Override
    public void move(){
        xPosition += xDirection[direction]*getCurrentSpeed();
        yPosition +=yDirection[direction]*getCurrentSpeed();
    }

    /**
     * Turns the car left. The direction is updated.
     */
    @Override
    public void turnLeft() {
        direction = (direction - 1) % 4;
        if (direction < 0)
        {
            direction += 4;
        }
    }

    /**
     * Turns the car right. The direction is updated.
     */
    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
        if (direction < 0)
        {
            direction += 4;
        }
    }

    /**
     * Returns 1% of the engine power of the car.
     *
     * @return 1% of the engine power of the car.
     */
    double speedFactor(){
        return enginePower * 0.01;
    }

    /**
     * Increases the speed according to amount without exceeding the engine power.
     *
     * @param amount the percent of the engine power that the speed increases with.
     */

    void incrementSpeed(double amount){ //Should be private
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed according to amount to at most 0.
     *
     * @param amount the percent of the engine power that the speed decreases with.
     */

    void decrementSpeed(double amount){ //Should be private
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Increases the speed of the car.
     *
     * @param amount amount of gas.
     */
    public void gas(double amount) {
        try{
            if (amount < 0 || amount > 1) {
                throw new Exception("amount has to be between 0 and 1");
            }
            else incrementSpeed(amount);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * decreases speed of the car by amount
     * @param amount amount of brake
     */
    public void brake(double amount) {
        try {
            if (amount < 0 || amount > 1) {
                throw new Exception("amount has to be between 0 and 1");
            }
            else decrementSpeed(amount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}