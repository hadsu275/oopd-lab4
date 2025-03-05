package ModelCar;
import ControllerView.CarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TimerListener implements ActionListener {
    private CarView frame;
    private ArrayList<Vehicle> cars;

    public TimerListener(CarView frame){
        this.frame = frame;
        this.cars = new ArrayList<>();
    }
    public void setCars(ArrayList<Vehicle> cars) {
        this.cars = cars;
    }


    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < cars.size(); i ++) {
            cars.get(i).move();
            int x = (int) Math.round(cars.get(i).x);
            int y = Math.round(i*100);


            frame.drawPanel.moveit(cars.get(i), x, y);
            // repaint() calls the paintComponent method of the panel

            frame.drawPanel.repaint();

            if (x > 700 ){
                cars.get(i).turnLeft();
                cars.get(i).turnLeft();


            }
            if (x < 0){
                cars.get(i).turnLeft();
                cars.get(i).turnLeft();
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