import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class volvoTest {
    private Volvo240 volvo;
    private Volvo240 volvo2;
    @Before //nrDoors 4, enginepower 100, currenspeed 0,Color.black, "Volvo240",x 0,y 0
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void TestGetCurrentSpeedVolvoOK(){
        assertEquals(0, volvo.getCurrentSpeed(), 0.0);
    }

    @Test
    public void TestSpeedFactorOK(){
        assertEquals(volvo.enginePower*Volvo240.trimFactor*0.01,volvo.speedFactor(),0.0);
    }

    @Test
    public void TestIncrementSpeedOK(){
        double amount = 10;
        double currentSpeed = Math.min(volvo.getCurrentSpeed() + volvo.speedFactor() * amount,volvo.enginePower);
        volvo.incrementSpeed(amount);
        assertEquals(currentSpeed,volvo.getCurrentSpeed(),0.0);
    }

    /*@Test
    public void TestDecrementSpeedOK(){
        double amount = 10;
        double currentSpeed = Math.max(volvo.getCurrentSpeed() - volvo.speedFactor() * amount,0);
        volvo.decrementSpeed(amount);
        assertEquals(currentSpeed,volvo.getCurrentSpeed(),0.0);
    }*/

    @Test
    public void TestGasOK(){
        volvo2 = new Volvo240();
        double amount = 0.1;
        volvo2.incrementSpeed(amount);
        volvo.gas(amount);
        assertEquals(volvo2.getCurrentSpeed(),volvo.getCurrentSpeed(),0.0);
    }

   /* @Test
    public void TestBrakeOK(){
        volvo2 = new Volvo240();
        double amount = 10;
        volvo2.decrementSpeed(amount);
        volvo.brake(amount);
        assertEquals(volvo2.getCurrentSpeed(),volvo.getCurrentSpeed(),0.0);
    }*/
}