import ControllerView.CarController;
import ControllerView.CarView;
import ModelCar.*;

public static void main(String[] args) {
    // Instance of this class
    ArrayList<Vehicle> cars = new ArrayList<>();

    cars.add(CarFactory.createVolvo240());
    cars.add(CarFactory.createSaab95());
    cars.add(CarFactory.createScania());
    //cars.add(CarFactory.createIveco());
    CarTraits ct = new CarTraits();
    ct.setCars(cars);

    CarView cv = new CarView("CarSim 1.0",ct);



    TimerListener timerListener =  new TimerListener(cv);
    timerListener.setCars(cars);



    CarController cc = new CarController(cars, timerListener, cv, ct);
    cc.setCars(cars);


    cc.setFrame(cv);


    if (!cars.isEmpty()){
        cars.getFirst().currentSpeed = 0;
        cars.add(new Scania());
        cars.add(new Volvo240());
        cars.add(new Saab95());

    }

    cc.getTimer().start();

}