package ModelCar;

import java.awt.*;
public class Scania extends Vehicle {
    private final BedFunc bedFunc;

    public Scania() {

        super(2, 125,"Scania", Color.white);
        bedFunc = new BedFunc(this);
        bedFunc.setBedVehicle(this);

    }

    public double speedFactor(){
        return enginePower * 0.01; // 1.5
    }

    public double getTippingAngle() {
        return bedFunc.getTippingAngle();
    }

    public void increaseTipping(double angle) {
        bedFunc.increaseTipping(angle);
    }

    public void decreaseTipping(double angle) {
        bedFunc.decreaseTipping(angle);
    }

    @Override
    public void move(){
        if (bedFunc.getTippingAngle() > 0){
            if (getCurrentSpeed()!= 0){
                currentSpeed = 0;
                System.out.println("Scania kan köras om flaket är uppe: ");
            }
        }
        super.move();
    }
}
