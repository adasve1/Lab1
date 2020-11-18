import java.awt.*;

public class Scania extends MotorVehicle implements Loadable{

    private int flatbedAngle;
    private final double weightFactor = 0.1;
    private final int flatbedAngularChange = 5;

    /**
     * Initializes a gray Scania truck with engine power 500 and 2 doors.
     * The angle of the flatbed is set to 0. Starts in x=0 and y=0.
     */
    public Scania(){
        super(2,500, Color.gray,"Big Truck",0,0,0,9,2.6);
        flatbedAngle=0;
    }

    /**
     *
     * @return 1% times the weightfactor of the total engine power.
     */
    @Override
    public double speedFactor(){
        return getEnginePower()*0.01*weightFactor;
    }

    /**
     * Raises the flatbed of the truck if and only if the current speed is 0
     * and the flatbedAngle is below 70. flatBedAngle is measured in degrees.
     */
    @Override
    public void raise(){
        if(getCurrentSpeed()==0 && flatbedAngle<70){
            flatbedAngle+=flatbedAngularChange;
        }
    }
    /**
     * Lowers the flatbed of the truck if and only if the current speed is 0
     * and the flatbedAngle is above 0. flatbedAngle is measured in degrees.
     */
    @Override
    public void lower(){
        if(getCurrentSpeed()==0 && flatbedAngle>0) {
            flatbedAngle -= flatbedAngularChange;
        }
    }

    /**
     *Increases the speed of the truck. Only if the flatbedAngle is 0.
     * @param amount amount of gas.
     */
    @Override
    public void gas(double amount){
        if(flatbedAngle==0) {
            super.gas(amount);
        }
    }

    /**
     * Sets the speed to 0.1 when starting the truck, if flatbedAngle is 0.
     */
    @Override
    public void startEngine(){
        if (flatbedAngle==0) {
            super.startEngine();
        }
    }

    /**
     * gets the angle of the flatbed.
     * @return angle of the flatbed.
     */
    public int getFlatbedAngle(){
        return flatbedAngle;
    }

}
