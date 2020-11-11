import java.awt.*;

/**
 * A class that represents a car.
 */

public class Car implements Movable {
    /**
     * Number of doors on the car.
     */
    int nrDoors; // Number of doors on the car
    /**
     * Engine power of the car.
     */
    double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */
    double currentSpeed; // The current speed of the car
    /**
     *Color of the car.
     */
    Color color; // Color of the car
    /**
     *The model name of the car.
     */
    String modelName; // The car model name
    /**
     * X-coordinate starting position.
     */
    double xPosition; //x-coordinate starting position
    /**
     * Y-coordinate starting position.
     */
    double yPosition; //y-coordinate starting position

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
     */

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPosition, double yPosition){
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.currentSpeed=currentSpeed;
        this.color=color;
        this.modelName=modelName;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
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
     * Moves the car along the x-axis according to its speed.
     */
    public void move(){
     xPosition += getCurrentSpeed();
    }

    /**
     * Move the car up the y-axis according to its speed.
     */
    public void turnLeft(){
    yPosition += getCurrentSpeed();
    }

    /**
     * Move the car down the y-axis according to its speed.
     */
    public void turnRight(){
    yPosition -= getCurrentSpeed();
    }

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
     * @param amount is the percent of the engine power that the speed increases with.
     */

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed according to amount to at most 0.
     *
     * @param amount is the percent of the engine power that the speed decreases with.
     */

    private void decrementSpeed(double amount){
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
                throw new Exception("amount has to be between 0 and 1!");
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
                throw new Exception("amount has to be between 0 and 1!");
            }
            else decrementSpeed(amount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}