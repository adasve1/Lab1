import java.awt.*;
import java.util.*;

public class CarTransport extends MotorVehicle implements Loadable {
    private boolean rampDown;
    private double lengthCapacityLeft;
    private ArrayList<Car> cargo;
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

    /**
     * Method which lowers  the ramp. Can only be done if CurrentSpeed is 0.
     */
    @Override
    public void lower() {
        if (getCurrentSpeed()==0) {
            rampDown = true;
        }
    }

    /**
     * Method which is raising the ramp
     */
    @Override
    public void raise() {
        rampDown=false;
    }

    /**
     * Method to load a vehicle onto the transport. Can only be done if the distance between the car transport and
     * the vehicle is less than 10 units adn if there is room on the trailer.
     * @param c is of the typ MotorVehicle
     */
    public void load(Car c) {
        if (rampDown==true && distanceBetween(c)<=10 && capacityForVehicle(c)==true){
            cargo.add(c);
            lengthCapacityLeft-=c.getLength();
            c.setPosition(this.getXPosition(),this.getYPosition());
            c.stopEngine();
        }
    }

    /**
     * Method to unload from the trailer. Can only be done if the trailer is non-empty and
     * the ramp is down.
     */
    public void unload() {
        if (rampDown==true&&cargo.size()>0){
            int index=cargo.size()-1;
            cargo.get(index).setPosition(this.getXPosition(),this.getYPosition());
            lengthCapacityLeft+=cargo.get(index).getLength();
            cargo.remove(index);
        }
    }

    /**
     * Method to get the speedfactor of the car transport.
     * @return 1 % of the total enginepower times a specific weightfactor.
     */
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

    /**
     * Method to get the status of the ramp
     * @return boolean true if ramp is down, false if ramp is up.
     */
    public boolean getRampStatus(){
        return rampDown;
    }

    /**
     * Method to get the capacity left on the transport.
     * @return LengthCapacityLeft
     */
    public double getLengthCapacityLeft(){
        return lengthCapacityLeft;
    }

    /**
     * Method to get the list of the cars on the transport.
     * @return cargo, which is an ArrayList.
     */
    public ArrayList<MotorVehicle> getCargo(){
        return cargo;
    }

    /**
     * Method which computes the distance between a vehicle and a car transporter.
     * @param m MotorVehicle
     * @return a double with the distance apart.
     */
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

    /**
     * A method which checks if there is capacity for another car, measured in metres.
     * @param m is the MotorVehicle we want to check if it fits
     * @return true if it fits, false if there is no room.
     */
    public boolean capacityForVehicle(MotorVehicle m){
        return (lengthCapacityLeft>=m.getLength());
    }

    /**
     * Method to use gas on the transporter.
     * @param amount amount of gas.
     */
    @Override
    public void gas(double amount){
        if (rampDown==false){
            super.gas(amount);
        }
    }

    /**
     * Method to start the engine f the Car transport.
     */
    @Override
    public void startEngine(){
        if (rampDown==false){
            super.startEngine();
        }
    }

}
