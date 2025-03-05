package ControllerView;
import ModelCar.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel{

    private HashMap<Vehicle, Point> map = new HashMap<>();

    BufferedImage volvoImage, volvoWorkshopImage, saab95Image, scaniaImage;

    Point volvoWorkshopPoint = new Point(300,0);
    public void removeCar(Vehicle car){
        map.remove(car);
        repaint();

    }

    public void moveit( Vehicle car, int x, int y) {
        map.put(car, new Point(x, y));


    }



    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/VolvoBrand.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car: map.keySet()){
            Point position = map.get(car);
            if (car instanceof Volvo240){
                g.drawImage(volvoImage, position.x, position.y, null);
            }
            if (car instanceof Saab95){
                g.drawImage(saab95Image, position.x, position.y, null);

            }
            if (car instanceof Scania){
                g.drawImage(scaniaImage, position.x, position.y, null);

            }
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);


    }

}