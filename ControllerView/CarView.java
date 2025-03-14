package ControllerView;
import ModelCar.CarTraits;
import ModelCar.UpdateInterface;

import javax.swing.*;
import java.awt.*;
/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements UpdateInterface {
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarTraits carC;


    public DrawPanel drawPanel = new DrawPanel(X, Y-240);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");


    JPanel brakePanel = new JPanel();
    JSpinner brakeSpinner = new JSpinner();
    JLabel brakeLabel = new JLabel("Amount of brake");


    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saabon");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton removeCarButton = new JButton("RemoveC");
    //String[] str = { "volvo", "saab", "sca" };
    //JComboBox<String> carList = new JComboBox<>(str);
    JButton addCar = new JButton("Add car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarTraits cc){
        this.carC = cc;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step



        gasSpinner = new JSpinner(spinnerModel);



        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
        SpinnerModel brakeModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step

        brakeSpinner = new JSpinner(brakeModel);


        brakePanel.setLayout(new BorderLayout());
        brakePanel.add(brakeLabel, BorderLayout.PAGE_START);
        brakePanel.add(brakeSpinner, BorderLayout.PAGE_END);
        this.add(brakePanel);


        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(addCar, 0);

        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(startButton, 6);
        controlPanel.add(stopButton, 7);
        controlPanel.add(gasButton, 8);
        controlPanel.add(removeCarButton, 9);
        //controlPanel.add(carList, 10);
        //carList.setVisible(true);
        controlPanel.setPreferredSize(new Dimension((X/2)+15, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/7-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/7-15,200));
        this.add(stopButton);

        ;
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        drawPanel.activeCars(carC.getCars());
        drawPanel.repaint();

    }
}
