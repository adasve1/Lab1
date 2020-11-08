import java.awt.*;

public class Volvo240 extends Bil{

    private final static double trimFactor = 1.25;          //
    int nrDoors;                                            // Number of doors on the car
    double enginePower;                                     // Engine power of the car
    double currentSpeed;                                    // The current speed of the car
    Color color;                                            // Color of the car
    String modelName;                                       // The car model name

    public Volvo240(){//Synlighet på metoder o konstruktorer?
        super(4,100,Color.black,"Volvo240",0);
        //nrDoors = 4;
        //color = Color.black;
        //enginePower = 100;
        //modelName = "Volvo240";
        //stopEngine();
    }
    
   /* public int getNrDoors(){
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
    */
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
