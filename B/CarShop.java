import java.util.ArrayList;

/**
 * A class that represents a generic car shop.
 * When specified, we can create a car shop for a specific car type.
 * @param <C> has an upper bound of Car, meaning (at this time) only Volvo240 and Saab95
 *           Can access the Car shop.
 */

public class CarShop <C extends Car>{
    private ArrayList<C> storage;
    private int capacity;
    private final int indexFirst=0;

    /**
     * Initializes a Car Shop with a set capacity of cars.
     * @param capacity is the maximum of cars they can have a specific time. Capacity is an Integer.
     */
    public CarShop(int capacity){
        this.capacity=capacity;
        storage = new ArrayList<>();
    }

    /**
     * A method which adds a car to the shop if there is room.
     * @param car is of the generic type Car.
     */
    public void load(C car){
        if (isRoomForAnotherCar(car)){
            storage.add(car);
            capacity-=1;
        }
        else System.out.println("There is no room for another car!");
    }

    /**
     * A method which removes the car which was first taken in.
     */
    public C unload(){
        if(!storage.isEmpty()) {
            C carTemp = storage.get(indexFirst);
            storage.remove(indexFirst);
            capacity+=1;
            return carTemp;

        }
        else System.out.println("Trying to remove a car from an already empty car shop!");
        return null;
    }

    /**
     * Helper method for checking if there is room for another car in the shop
     * @param car
     * @return
     */
    private boolean isRoomForAnotherCar(C car){
    return capacity >=1;
    }

    /**
     * Returns the cars that are stored in the car shop.
     * @return cars stored in car shop.
     */

    public ArrayList<C> getStorage(){
        return storage;
    }
}



