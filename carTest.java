import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class carTest {
    private Car car;
    private Car car2;
    @Before
    public void init(){
        car = new Car(4,100,0,Color.black,"car",0,0,0);
    }

    @Test
    public void TestGetCurrentSpeedCar(){
        assertEquals(0, car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestGetColor(){
        assertSame(Color.black, car.getColor());
    }

    @Test
    public void TestSetColor(){
        car.setColor(Color.red);
        assertSame(Color.red, car.getColor());
    }

    @Test
    public void TestGetXPosition(){
        assertEquals(0, car.getXPosition(), 0.0);
    }

    @Test
    public void TestGetYPosition(){
        assertEquals(0, car.getYPosition(), 0.0);
    }


    @Test
    public void TestMoveOK(){
        car.incrementSpeed(10);
        car.setDirection(1);
        double xLocation = car.getXPosition()+car.getXDirection()[car.getDirection()]*car.getCurrentSpeed();
        double yLocation = car.getYPosition()+car.getYDirection()[car.getDirection()]*car.getCurrentSpeed();
        car.move();
        assertEquals(xLocation, car.getXPosition(), 0.0);
        assertEquals(yLocation, car.getYPosition(),0.0);
    }

    @Test
    public void TestTurnLeftOK(){
        int direction = car.getDirection();
        int future_dir = (direction-1) % 4;
        if(future_dir <0){
            future_dir = 4 + future_dir;
        }
        car.turnLeft();
        assertEquals(future_dir, car.getDirection(), 0.0);
    }

    @Test
    public void TestTurnLeftManyTimes(){
        for(int i= 0; i<400; i++) {
            car.turnLeft();
        }
        assertEquals(0, car.getDirection(), 0.0);
    }

    @Test
    public void TestTurnRightOK(){
        int direction = car.getDirection();
        int future_dir = (direction+1) % 4;
        if(future_dir <0){
            future_dir = 4 + future_dir;
        }
        car.turnRight();
        assertEquals(future_dir, car.getDirection(), 0.0);
    }

    @Test
    public void TestTurnRightManyTimes(){
        for(int i= 0; i<101; i++) {
            car.turnRight();
        }
        assertEquals(1, car.getDirection(), 0.0);
    }


    @Test
    public void TestGetNrDoorsOK(){
        assertEquals(4, car.getNrDoors());
    }

    @Test
    public void TestGetEnginePowerOK(){
        assertEquals(100, car.getEnginePower(), 0.0);
    }

    @Test
    public void TestStartEngineOK(){
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestStopEngineOK(){
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestSpeedFactorOK(){
        double speedFactor = car.getEnginePower()*0.01;
        assertEquals(speedFactor, car.speedFactor(), 0.0);
    }

    @Test
    public void TestIncrementSpeedOK(){
        double amount = 0.5;
        double currentSpeed = Math.min(car.getCurrentSpeed() + car.speedFactor() * amount,car.getEnginePower());
        car.incrementSpeed(amount);
        assertEquals(currentSpeed, car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestDecrementSpeedOK(){
        double amount = 25;
        double currentSpeed = Math.max(car.getCurrentSpeed() - car.speedFactor() * amount,0);
        car.decrementSpeed(amount);
        assertEquals(currentSpeed, car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestGasTooMuch() throws Exception{
        car.gas(2);
        assertEquals(car.getCurrentSpeed(),0,0.0);
    }

    @Test
    public void TestGasTooLittle() throws Exception{
        car.gas(-2);
        assertEquals(car.getCurrentSpeed(),0,0.0);
    }

    @Test
    public void TestGasOK(){
        car.gas(0.1);
        car2 = new Car(4,100,0,Color.red,"car2",0,0,0);
        car2.incrementSpeed(0.1);
        assertEquals(car.getCurrentSpeed(),car2.getCurrentSpeed(),0.0);
    }

    @Test
    public void TestBrakeTooMuch() throws Exception{
        car.brake(2);
        assertEquals(car.getCurrentSpeed(),0,0.0);
    }

    @Test
    public void TestBrakeTooLittle() throws Exception{
        car.brake(-2);
        assertEquals(car.getCurrentSpeed(),0,0.0);
    }

    @Test
    public void TestBrakeOK(){
        car.brake(0.1);
        car2 = new Car(4,100,0,Color.red,"car2",0,0,0);
        car2.decrementSpeed(0.1);
        assertEquals(car.getCurrentSpeed(),car2.getCurrentSpeed(),0.0);
    }
    //TODO: brake
}
