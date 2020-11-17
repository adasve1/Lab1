import java.awt.*;

public class Scania extends MotorVehicle implements Loadable  {
    private int flatBedAngle;
    private final int flatBedAngularChange=5;
    private final double weightFactor = 0.1;
    public Scania(){
        super(2,500, Color.blue,"BigTruck",0,0,0,9,2.6);
        flatBedAngle=0;
    }
    @Override
    public double speedFactor(){
        return getEnginePower()*0.01*weightFactor;
    }

    @Override
    public void lower() {
        if (getCurrentSpeed()==0 && flatBedAngle>0) {
            flatBedAngle-=flatBedAngularChange;
        }
    }

    @Override
    public void raise() {
        if (getCurrentSpeed()==0 && flatBedAngle<70) {
            flatBedAngle+=flatBedAngularChange;
        }
    }

    /*@Override
    public void unload() {
        System.out.println("1 ton of gravel to you, sir.");
    }

    @Override
    public void load() {
        System.out.println("1 ton of gravel loaded.");
    }*/

    @Override
    public void gas(double amount){
        if (flatBedAngle==0){
            super.gas(amount);
        }
    }

    @Override
    public void startEngine(){
        if (flatBedAngle==0){
            super.startEngine();
        }
    }

    public int getFlatBedAngle(){
        return flatBedAngle;
    }
    // TODO

}
