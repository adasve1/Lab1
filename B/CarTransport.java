import java.awt.*;
import java.util.*;

public class CarTransport extends MotorVehicle implements Loadable {
    private boolean rampDown;
    private double lengthCapacityLeft;
    private final double widthCapacity=2;
    private ArrayList<MotorVehicle> cargo;
    private final double weightFactor=0.1;

    /**
     * Initializes a black Car Transport with 2 doors, 700 engine power,
     * with initial length capacity of 30m, and ramp is not extended.
     * Starting position is in origo, and direction pointing east.
     * Size of the truck is 18m long and 2.6m wide.
     * It can carry cargo on two stories.
     */
    public CarTransport(){
        super(2,700, Color.black,"Thåströms Toe Truck",0,0,0,18,2.6);
        rampDown=false;
        lengthCapacityLeft=30;
        cargo=new ArrayList<>();
    }

    @Override
    public void lower() {
        if (getCurrentSpeed()==0) {
            rampDown = true;
        }
    }

    @Override
    public void raise() {
        rampDown=false;
    }

    public void load(MotorVehicle m) {
        if (rampDown==true && distanceBetween(m)<=10 && capacityForVehicle(m)==true){
            cargo.add(m);
            lengthCapacityLeft-=m.getLength();
            m.setPosition(this.getXPosition(),this.getYPosition());
            m.stopEngine();
        }
    }

    public void unload() {
        if (rampDown==true&&cargo.size()>0){
            int index=cargo.size()-1;
            cargo.get(index).setPosition(this.getXPosition(),this.getYPosition());
            cargo.remove(index);
        }
    }

    @Override
    public double speedFactor(){
        return getEnginePower()*0.01*weightFactor;
    }

    @Override
    public void move(){
        super.move();
        for (int i=0; i<cargo.size(); i++){
            cargo.get(i).setPosition(this.getXPosition(),this.getYPosition());
        }
    }

    public boolean getRampStatus(){
        return rampDown;
    }

    public double getLengthCapacityLeft(){
        return lengthCapacityLeft;
    }

    public ArrayList<MotorVehicle> getCargo(){
        return cargo;
    }

    public double distanceBetween(MotorVehicle m){
        double xPosVehicle1=this.getXPosition();
        double xPosVehicle2=m.getXPosition();
        double yPosVehicle1=this.getYPosition();
        double yPosVehicle2=m.getYPosition();
        double xDist = xPosVehicle2-xPosVehicle1;
        double yDist = yPosVehicle2-yPosVehicle1;
        double distance = Math.sqrt(Math.pow(xDist,2)+Math.pow(yDist,2));
        return distance;
    }

    public boolean capacityForVehicle(MotorVehicle m){
        return (lengthCapacityLeft>=m.getLength()&&widthCapacity>=m.getWidth());
    }

    @Override
    public void gas(double amount){
        if (rampDown==false){
            super.gas(amount);
        }
    }

    @Override
    public void startEngine(){
        if (rampDown==false){
            super.startEngine();
        }
    }


    //TODO
}
