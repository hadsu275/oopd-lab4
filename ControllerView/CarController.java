package ControllerView;
import ModelCar.TimerListener;
import ModelCar.Vehicle;
import javax.swing.*;
import java.util.ArrayList;

public class CarController {
    private final int delay = 50;
    private ArrayList<Vehicle> cars;
    private Timer timer;
    CarView frame;

    public CarController(ArrayList<Vehicle> cars, TimerListener timerListener) {

        this.cars = new ArrayList<>();
        this.timer = new Timer(delay, timerListener);
    }
    public void setCars(ArrayList<Vehicle> cars){
        this.cars = cars;

    }
    public ArrayList<Vehicle> getCars() {
        return cars; // Skapar en ny lista med samma innehåll
    }

    public CarView getFrame() {
        return frame;
    }

    public Timer getTimer() {
        return timer;
    }


    public void setFrame(CarView carView) {
        this.frame = carView;
    }

/*
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.x);
                int y = (int) Math.round(car.y);

                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (x > 700 ){
                    car.turnLeft();
                    car.turnLeft();
                }
                if (x < 0){
                    car.turnLeft();
                    car.turnLeft();
                }
                for (Vehicle volvo : cars){
                    if (volvo instanceof Volvo240 volvo240){
                        int xv = (int) Math.round(volvo240.x);
                        if (300 < xv && xv < 400 ){
                            volvo240.currentSpeed = 0;
                        }
                    }
                }

            }
        }
    }

 */



}