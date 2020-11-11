import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class saabTest {
    private Saab95 saab;
    private Saab95 saab2;
    @Before //nrDoors 2, enginepower 125, currenspeed 0,Color.black, "Volvo240",x 0,y 0
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void TestGetCurrentSpeedSaabOK(){
        assertTrue(0==saab.getCurrentSpeed());
    }

    @Test
    public void TestSetTurboOnOK(){
        saab.setTurboOn();
        assertTrue(saab.getTurboStatus());
    }

    @Test
    public void TestSetTurboOffOK(){
        saab.setTurboOff();
        assertEquals(false, saab.getTurboStatus());
    }

    @Test
    public void TestSpeedFactorWithTurboOnOK(){
        saab.setTurboOn();
        double turbo=1.3;
        assertEquals(saab.getEnginePower() * turbo * 0.01, saab.speedFactor(), 0.0);
    }

    @Test
    public void TestSpeedFactorWithTurboOffOK(){
        saab.setTurboOff();
        double turbo=1;
        assertEquals(saab.getEnginePower()*turbo*0.01,saab.speedFactor(),0.0);
    }

    @Test
    public void TestGasOK(){
        saab2 = new Saab95();
        double amount = 1;
        saab.gas(amount);
        saab2.incrementSpeed(amount);
        double currentSpeed = saab.getCurrentSpeed();
        double currentSpeed2 = saab2.getCurrentSpeed();
        assertEquals(currentSpeed, currentSpeed2,0.0);
    }

   /* @Test
    public void TestBrakeOK(){
        saab2 = new Saab95();
        double amount = 10;
        saab.brake(amount);
        saab2.decrementSpeed(amount);
        double currentSpeed = saab.getCurrentSpeed();
        double currentSpeed2 = saab2.getCurrentSpeed();
        assertEquals(currentSpeed, currentSpeed2,0.0);
    }*/
}
