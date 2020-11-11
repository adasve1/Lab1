import java.awt.*;
import java.awt.image.ConvolveOp;

public class mainCar{
    public static void main(String[] args) {
        Volvo240 volvo = new Volvo240();
        volvo.incrementSpeed(79);
        Car testBil = new Car(4,100,0,Color.blue,"Tesla",0,0);
        testBil.incrementSpeed(101);
        System.out.println(testBil.getCurrentSpeed());
        System.out.println("Volvo speed: " + volvo.getCurrentSpeed());

        //volvo.decrementSpeed(80);
        //testBil.decrementSpeed(101);
        System.out.println("Volvo: " + volvo.getCurrentSpeed());
        System.out.println("testBil: " + testBil.getCurrentSpeed());

        volvo.gas(0.7);
        System.out.println("volvo speed: "+ volvo.getCurrentSpeed());

        volvo.brake(0.2);
        System.out.println("Volvo speed " + volvo.getCurrentSpeed());

    }

}
