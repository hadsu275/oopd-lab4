package ModelCar;
import java.util.ArrayList;

public class CarTraits {
    private ArrayList<Vehicle> cars;
    public CarTraits(){
        this.cars = new ArrayList<>();

    }
    public void setCars(ArrayList<Vehicle> cars){
        this.cars = cars;

    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }


    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars){
            car.brake(brake);
        }
    }

    public void turboOn(){
        for (Vehicle car : cars){
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOn();
            }
        }
    }

    public void turboOf(){
        for (Vehicle car : cars){
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOff();
            }
        }
    }

    public void liftButton(double angle){
        for (Vehicle car : cars){
            if (car instanceof Scania scania){
                scania.increaseTipping(angle);
            }
        }
    }
    public void lowerButton(double angle){
        for (Vehicle car : cars){
            if (car instanceof Scania scania){
                scania.decreaseTipping(angle);
            }
        }
    }
    public void startButton(){
        for (Vehicle car :cars) {
            car.startEngine();
        }
    }
    public void stopButton(){
        for (Vehicle car :cars) {
            car.stopEngine();
        }

    }

}