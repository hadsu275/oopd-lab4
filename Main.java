import ControllerView.CarController;
import ControllerView.CarView;
import ModelCar.*;

public static void main(String[] args) {
    // Instance of this class
    ArrayList<Vehicle> cars = new ArrayList<>();

    cars.add(CarFactory.createVolvo240());
    cars.add(CarFactory.createSaab95());
    cars.add(CarFactory.createScania());

    CarTreats ct = new CarTreats();
    ct.setCars(cars);

    CarController cc = new CarController(cars);
    cc.setCars(cars);


    cc.setFrame(new CarView("CarSim 1.0",ct));


    if (!cars.isEmpty()){
        cars.getFirst().currentSpeed = 0;
        cars.add(new Scania());

    }
    cc.getTimer().start();

}

