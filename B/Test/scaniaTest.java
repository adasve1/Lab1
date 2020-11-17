import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class scaniaTest {
    Scania truck;
    @Before
    public void init(){
        truck = new Scania();
    }

    @Test
    public void TestIncrementSpeedWithFlatBedRaised(){
        truck.raise();
        truck.gas(0.5);
        assertEquals(0,truck.getCurrentSpeed(),0);
    }

    @Test
    public void TestStartEngineWithFlatBedRaised(){
        truck.raise();
        truck.startEngine();
        assertEquals(0,truck.getCurrentSpeed(),0);
    }

    @Test
    public void TestIncrementSpeedWithFlatBedDown(){
        truck.gas(0.5);
        assertTrue(truck.getCurrentSpeed()>0);
    }
}
