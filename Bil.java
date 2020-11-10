import java.awt.*;

/**
 * Model that should represent a car
 */
public class Bil implements Movable {

    /*
    Variables
    */
    public int nrDoors;                 // Number of doors on the car
    public double enginePower;          // Engine power of the car
    public double currentSpeed;         // The current speed of the car
    public Color color;                 // Color of the car
    public String modelName;            // The car model name
    double x;
    double y;

    /**
     * Construct a car with the defined parameters below
     * @param x starting position x-direction
     * @param y starting position y-direction
     * @param nrDoors number of doors
     * @param enginePower engine power of the car
     * @param color color of the car
     * @param modelName model name of the car
     * @param currentSpeed current speed of the car
     */
    public Bil(double x, double y,int nrDoors,double enginePower,Color color, String modelName,double currentSpeed){
        this.x=x;
        this.y=y;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed=currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }
    /*
    Getters and Setters
    */

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public double getX(){return x;}

    public double getY(){return y;}

    /*
    Methods
     */

    /**
     * Sets speed to 0.1 when starting the car
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine, i.e. sets the speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Getter for the speedfactor
     * @return 1% of the engine power for an unspecified car model
     */
    public double speedFactor(){
        return enginePower * 0.01;
    }

    /**
     * increase the speed of the car and sets the new currentSpeed.
     * @param amount amount of speed increased
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * decreases the speed of the car and sets the new currentSpeed
     * @param amount amount of speed decreased
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * increases speed of the car by amount
     * @param amount amount of gas
     */
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * decreases speed of the car by amount
     * @param amount amount of brake
     */
    public void brake(double amount){
        decrementSpeed(amount);
    }

    /**
     * moves the car i the x-direction and sets the new x-position
     */
    @Override
    public void move(){
        x += getCurrentSpeed();
    }

    /**
     * Turns the car left and sets the new y-position
     */
    @Override
    public void turnLeft() {
        y+=getCurrentSpeed();
    }

    /**
     * Turns the car right and sets  the new y-position
     */
    @Override
    public void turnRight() {
        y-=getCurrentSpeed();
    }

}
