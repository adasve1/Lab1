import java.awt.*;

public class Bil implements Movable {

    public int nrDoors;                 // Number of doors on the car
    public double enginePower;          // Engine power of the car
    public double currentSpeed;         // The current speed of the car
    public Color color;                 // Color of the car
    public String modelName;            // The car model name
    double x;
    double y;

    public Bil(int nrDoors,double enginePower,Color color, String modelName,double currentSpeed){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed=currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

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
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public double speedFactor(){
        return enginePower * 0.01;
    }
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    public double getX(){return x;}
    
    public double getY(){return y;}

    @Override
    public void move(){
        x += getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        y+=getCurrentSpeed();
    }

    @Override
    public void turnRight() {
        y-=getCurrentSpeed();
    }

}
