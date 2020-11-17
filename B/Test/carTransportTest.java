import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;
import java.awt.*;
import java.lang.module.ModuleReader;
import java.util.ArrayList;

public class carTransportTest {
    private CarTransport mater;
    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;
    @Before
    public void init(){
        mater=new CarTransport();
        volvo=new Volvo240();
        saab=new Saab95();
        scania=new Scania();
        mater.lower();
    }

    @Test
    public void TestAddVehiclesToCargo(){
        mater.load(volvo);
        mater.load(saab);
        mater.load(scania);
        mater.load(mater);
        System.out.println(mater.getCargo());
    }

    @Test
    public void TestCargoPositionEqualsCarTransportPosition(){
        mater.load(volvo);
        mater.load(saab);
        mater.raise();
        mater.startEngine();
        mater.move();
        assertEquals(mater.getXPosition(), volvo.getXPosition(),0);
        assertEquals(mater.getYPosition(),volvo.getYPosition(),0);
    }

    @Test
    public void TestUnloadPositionAfterCarTransportLeaves(){
        System.out.println(mater.getXPosition());
        System.out.println(volvo.getXPosition());
        mater.load(volvo);
        mater.raise();
        mater.gas(1);
        mater.move();
        System.out.println(mater.getXPosition());
        System.out.println(volvo.getXPosition());
        mater.stopEngine();
        mater.lower();
        mater.unload();
        mater.raise();
        mater.gas(1);
        mater.move();
        assertTrue(mater.getXPosition()!=volvo.getXPosition());
        System.out.println(mater.getXPosition());
        System.out.println(volvo.getXPosition());
    }

}
