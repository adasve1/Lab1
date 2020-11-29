import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<MotorVehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Saab95());

        cc.initiateVehicleStartPositions();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Point> vehiclePosition = new ArrayList<>();
            for (MotorVehicle vehicle : vehicles) {
                vehicle.move();
                vehiclePosition.add(new Point((int) Math.round(vehicle.getXPosition()), (int) Math.round(vehicle.getYPosition())));
                /*int x = (int) Math.round(vehicle.getXPosition());
                int y = (int) Math.round(vehicle.getYPosition());*/
                if (wallCollision(vehicle)) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }
            }
            frame.drawPanel.moveit(vehicles); //TODO change moveIt
            // repaint() calls the paintComponent method of the panel
            //frame.drawPanel.currentImage(vehicles);
            frame.drawPanel.repaint();
        }
    }

    private boolean wallCollision(MotorVehicle vehicle){
        Point panelSize = new Point(frame.drawPanel.getFrameSize());
        Point picSize = vehicle.getPicSize();
        if(vehicle.getXPosition() < 0 || vehicle.getXPosition()+picSize.x >= panelSize.x ||
                vehicle.getYPosition() < 0 || vehicle.getYPosition()+picSize.y >= panelSize.y) {
            return true;
        } else {
            return false;
        }
    }

    ArrayList<MotorVehicle> getVehicles(){
        return vehicles;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorVehicle vehicle : vehicles
                ) {
            vehicle.gas(gas);
        }
    }
    // Calls the break method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (MotorVehicle vehicle : vehicles) vehicle.startEngine();
    }

    void stopEngine() {
        for (MotorVehicle vehicle : vehicles) vehicle.stopEngine();
    }

    void putTurboOn() {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) ((Saab95) vehicle).setTurboOn();
        }
    }

    void putTurboOff() {
        for (MotorVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) ((Saab95) vehicle).setTurboOff();
        }
    }

    void initiateVehicleStartPositions(){
        for (MotorVehicle vehicle : vehicles){
            vehicle.setPosition(0, vehicles.indexOf(vehicle)*100);
        }
    }
}
