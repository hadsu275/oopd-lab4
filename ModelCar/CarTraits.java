package ModelCar;
import java.util.ArrayList;
import java.util.List;

public class CarTraits{
    private ArrayList<Vehicle> cars;
    private final List<UpdateInterface> observers;
    private int maxCars = 6;


    public CarTraits(){
        this.cars = new ArrayList<>();
        this.observers = new ArrayList<>();

    }
    private void notifyObservers(){
        for (UpdateInterface observer : observers){
            observer.update();
        }
    }

    public void setCars(ArrayList<Vehicle> cars){
        this.cars = cars;
        notifyObservers();

    }
    public ArrayList<Vehicle> getCars(){
        return cars;


    }
    public void addObserver(UpdateInterface observer){
        observers.add(observer);

    }
    public void removeObserver(UpdateInterface observer){
        observers.remove(observer);

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
    public void addCar(){
        int carIndex = (int) (Math.random() * 3);
        if (cars.size() < maxCars) {
            switch (carIndex) {

                case 0:
                    cars.add(CarFactory.createVolvo240());
                    break;

                case 1:
                    cars.add(CarFactory.createSaab95());
                    break;
                case 2:
                    cars.add(CarFactory.createScania());
                    break;
            }
        }
        else{
            throw new IllegalArgumentException("för många bilar ");
        }
        notifyObservers();

    }

    public void removeCar(){
        cars.removeLast();
        notifyObservers();
    }


}