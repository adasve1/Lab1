import java.awt.*;

/**
 * A class that represents a MotorVehicle.
 */

public abstract class MotorVehicle implements Movable {
    /**
     * Number of doors on the MotorVehicle.
     */
    private int nrDoors; // Number of doors on the MotorVehicle
    /**
     * Engine power of the MotorVehicle.
     */
    private double enginePower; // Engine power of the MotorVehicle
    /**
     * The current speed of the MotorVehicle.
     */
    private double currentSpeed; // The current speed of the MotorVehicle
    /**
     *Color of the MotorVehicle.
     */
    private Color color; // Color of the MotorVehicle
    /**
     *The model name of the MotorVehicle.
     */
    private final String modelName; // The MotorVehicle model name
    /**
     * X-coordinate starting position.
     */
    private double xPosition; //x-coordinate starting position
    /**
     * Y-coordinate starting position.
     */
    private double yPosition; //y-coordinate starting position

    /**
     * The current direction of the MotorVehicle
     */
    private int direction;

    private final int[] xDirection = {1,0,-1,0}; //pos 0 is "forward" in x-direction
    private final int[] yDirection = {0,-1,0,1}; //pos 3 is "forward" in y-direction
    private double length;
    private double width;

    /**
     * Initializes a MotorVehicle. Sets the speed to 0.
     *
     * @param nrDoors the number of doors of the MotorVehicle.
     * @param enginePower the engine power of the MotorVehicle.
     * @param color the color of the MotorVehicle.
     * @param modelName the model name of the MotorVehicle.
     * @param xPosition the x-coordinate of the MotorVehicle.
     * @param yPosition the y-coordinate of the MotorVehicle.
     * @param startDirection the start direction of the MotorVehicle.
     */

    public MotorVehicle(int nrDoors, double enginePower, Color color, String modelName, double xPosition, double yPosition,int startDirection, double length,double width){
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        //this.currentSpeed=currentSpeed;
        this.color=color;
        this.modelName=modelName;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.direction=startDirection;
        this.length=length;
        this.width=width;
        stopEngine();
    }

    //Getters

    /**
     * Returns the number of doors of the MotorVehicle.
     *
     * @return the number of doors the MotorVehicle have.
     */
    int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power of the MotorVehicle.
     *
     * @return the engine power of the MotorVehicle.
     */
    double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the MotorVehicle.
     *
     * @return the speed of the MotorVehicle.
     */
    double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the color of the MotorVehicle.
     *
     * @return the color of the MotorVehicle.
     */
    Color getColor(){
        return color;
    }


    /**
     * Get the x-coordinate of the position of the MotorVehicle.
     *
     * @return the x-coordinate of the position of the MotorVehicle.
     */
    public double getXPosition(){
        return xPosition;
    }

    /**
     * Get the y-coordinate of the position of the MotorVehicle.
     *
     * @return the y-coordinate of the position of the MotorVehicle.
     */
    public double getYPosition(){
        return yPosition;
    }

    /**
     * Get the current direction of the MotorVehicle.
     * @return index of direction.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Returns for which indexes the MotorVehicle moves in x-direction.
     * @return array with indexes whether the MotorVehicle moves in x-direction or not.
     */
    public int[] getXDirection(){
        return xDirection;
    }

    /**
     * Returns for which indexes the MotorVehicle moves in y-direction.
     * @return array with indexes whether the MotorVehicle moves in y-direction or not.
     */
    public int[] getYDirection(){
        return yDirection;
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    public String getModelName(){
        return modelName;
    }

    //Setters

    /**
     * Changes the color of the MotorVehicle.
     *
     * @param clr the new color of the MotorVehicle.
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
     * Set the direction of the MotorVehicle.
     *
     * @param index in which of four directions the MotorVehicle should move
     */
    public void setDirection(int index){
        direction=index;
    }

    public void setPosition(double x, double y){
        xPosition=x;
        yPosition=y;
    }



    /**
     * Moves the MotorVehicle according to its speed and its direction.
     */
    @Override
    public void move(){
        xPosition += xDirection[direction]*getCurrentSpeed();
        yPosition +=yDirection[direction]*getCurrentSpeed();
    }

    /**
     * Turns the MotorVehicle left. The direction is updated.
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
     * Turns the MotorVehicle right. The direction is updated.
     */
    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
        if (direction < 0)
        {
            direction += 4;
        }
    }

    @Override
    public String toString(){
        return modelName;
    }
    /**
     * Returns 1% of the engine power of the MotorVehicle.
     *
     * @return 1% of the engine power of the MotorVehicle.
     */
    double speedFactor(){
        return enginePower * 0.01;
    }

    /**
     * Increases the speed according to amount without exceeding the engine power.
     *
     * @param amount the percent of the engine power that the speed increases with.
     */

    private void incrementSpeed(double amount){ //Should be private
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed according to amount to at most 0.
     *
     * @param amount the percent of the engine power that the speed decreases with.
     */

    private void decrementSpeed(double amount){ //Should be private
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Increases the speed of the MotorVehicle.
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
     * decreases speed of the MotorVehicle by amount
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

//TODO interface för vehicle