package ControllerView;
import ModelCar.CarTraits;
import ModelCar.TimerListener;
import ModelCar.Vehicle;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarController {
    private final int delay = 50;
    private ArrayList<Vehicle> cars;
    private Timer timer;
    CarView frame;
    private int gasAmount = 0;
    private int brakeAmount = 0;
    CarTraits carC;


    public CarController(ArrayList<Vehicle> cars, TimerListener timerListener, CarView cv, CarTraits carC) {
        this.cars = cars;
        this.timer = new Timer(delay, timerListener);
        this.carC = carC;
        carC.addObserver(cv);
        this.setupListeners(cv);


    }
    public void setCars(ArrayList<Vehicle> cars) { this.cars = cars;
    }
    public ArrayList<Vehicle> getCars() { return cars; // Skapar en ny lista med samma innehåll
    }
    public CarView getFrame() { return frame;
    }
    public Timer getTimer() { return timer;
    }
    public void setFrame(CarView carView) {
        this.frame = carView;
    }



    private void setupListeners(CarView carView) {

        carView.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();

            }
        });

        carView.brakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                brakeAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        carView.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(brakeAmount);
            }
        });
        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });
        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOf();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftButton(15.5);
            }
        });

        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerButton(15.5);
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startButton();
            }
        });

        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopButton();
            }
        });


        carView.addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.addCar();
            }
        });
        carView.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.drawPanel.removeCar(cars.getLast());
                carC.removeCar();
            }
        });


    }
}