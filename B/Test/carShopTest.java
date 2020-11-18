import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class carShopTest {

    private CarTransport mater;
    private Scania lastbil;
    private Volvo240 volvo;
    private Saab95 saab;
    private CarShop<Car> generalCarShop;
    private CarShop<Volvo240> volvo240CarShop;
    private CarShop<Saab95> saab95CarShop;
    private int capacity=2;

    @Before
    public void init(){
        mater=new CarTransport();
        lastbil=new Scania();
        volvo=new Volvo240();
        saab=new Saab95();
        generalCarShop=new CarShop<>(capacity);
        volvo240CarShop=new CarShop<>(capacity);
        saab95CarShop=new CarShop<>(capacity);
    }

    @Test
    public void TestLoadingGeneralCar(){
        generalCarShop.load(volvo);
        generalCarShop.load(saab);
        System.out.println(generalCarShop.getStorage());
    }

    @Test
    public void TestLoadingSpecificCars(){
        saab95CarShop.load(saab);
        volvo240CarShop.load(volvo);
        System.out.println(saab95CarShop.getStorage());
        System.out.println(volvo240CarShop.getStorage());
    }

    @Test
    public void TestLoadingTooManyCars(){
        generalCarShop.load(saab);
        generalCarShop.load(saab);
        generalCarShop.load(volvo);
        assertEquals(capacity,generalCarShop.getStorage().size(),0);
    }

    @Test
    public void TestUnloading(){
        generalCarShop.load(saab);
        System.out.println(generalCarShop.unload());
    }

    //TODO test only loading specific cars, all cars, unloading
}
