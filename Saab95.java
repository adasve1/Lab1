import java.awt.*;

public class Saab95 extends Bil{

    private boolean turboOn;
    int nrDoors;                 // Number of doors on the car
    double enginePower;          // Engine power of the car
    double currentSpeed;         // The current speed of the car
    Color color;                 // Color of the car
    String modelName;            // The car model name
    
    public Saab95(){
        super(0,0,2,125,Color.red,"Saab95",0);
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    // TODO fix this method according to lab pm
    //public void gas(double amount){
    //    incrementSpeed(amount);
    //}

    // TODO fix this method according to lab pm
    //public void brake(double amount){
    //    decrementSpeed(amount);
    //}
}
