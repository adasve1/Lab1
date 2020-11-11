import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class carTest {
    private Car car;
    @Before
    public void init(){
        car = new Car(4,100,100,Color.black,"car",0,0);
    }

    @Test
    public void TestGetCurrentSpeedCar(){
        assertEquals(100, car.getCurrentSpeed(), 0.0);
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
        double location = car.getXPosition()+car.getCurrentSpeed();
        car.move();
        assertEquals(location, car.getXPosition(), 0.0);
    }

    @Test
    public void TestTurnLeftOK(){
        double location = car.getYPosition()+car.getCurrentSpeed();
        car.turnLeft();
        assertEquals(location, car.getYPosition(), 0.0);
    }

    @Test
    public void TestTurnRightOK(){
        double location = car.getYPosition()-car.getCurrentSpeed();
        car.turnRight();
        assertEquals(location, car.getYPosition(), 0.0);
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

    /*@Test
    public void TestIncrementSpeedOK(){
        double amount = 0.5;
        double currentSpeed = car.getCurrentSpeed()+ car.speedFactor()*amount;
        car.incrementSpeed(amount);
        assertEquals(currentSpeed, car.getCurrentSpeed(), 0.0);
    }*/

    /*@Test
    public void TestDecrementSpeedOK(){
        double amount = 25;
        double currentSpeed = car.getCurrentSpeed()- car.speedFactor()*amount;
        car.decrementSpeed(amount);
        assertEquals(currentSpeed, car.getCurrentSpeed(), 0.0);
    }*/
}
