import java.awt.*;

/**
 * An class that extends car and creates a Volvo240.
 */

public class Volvo240 extends Car{
    /**
     * The volvo240 is trimmed by default.
     */
    private final static double trimFactor = 1.25;
    /**
     * Initializes a Volvo240.
     */
    public Volvo240(){
        super(4,100,0,Color.black, "Volvo240",0,0,0);
    }

    /**
     * Returns the trim factor.
     *
     * @return trim factor.
     */
    public double getTrimFactor(){
        return trimFactor;
    }

    /**
     * Returns the speed factor.
     *
     * @return 1% of the engine power times the trim factor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
