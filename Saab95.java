import java.awt.*;

/**
 * An class that extends car and creates a Saab95.
 */

public class Saab95 extends Car implements Movable {

    /**
     * The Saab95 has turbo which is off by default.
     */
    static boolean turboOn; //To be able to use in test

    /**
     * Initializes a Saab95. By default the turbo is off.
     */
    public Saab95(){
        super(2,125,0,Color.red,"Saab95",0,0);
	    turboOn = false;
    }

    /**
     * Activates the turbo.
     */
    public void setTurboOn(){ //visibility
	    turboOn = true;
    }

    /**
     * Deactivates the turbo.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Returns the speed factor which differs depending whether the turbo is on or off.
     *
     * @return 1% of the engine power if the turbo is off. 1.3% of the engine power if the turbo is on.
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
