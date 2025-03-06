package ModelCar;

import java.awt.*;
import java.util.ArrayList;

public class Iveco extends Vehicle  {
    private final RampFunc rampFunc;

    public Iveco() {
        super(2, 130,"Iveco", Color.BLUE);
        rampFunc = new RampFunc(this);
        rampFunc.setRampVehicle(this);
    }

    public double speedFactor() {

        return enginePower * 0.01;
    }
    public void startLoadMode(){
         rampFunc.startLoadMode();
    }

    public void exitLoadMode() {
         rampFunc.exitLoadMode();
    }

    public boolean getLoadMode(){
        return rampFunc.getLoadMode();
    }

    public void setRampDown(){
        rampFunc.setRampDown();
    }

    public void setRampUp(){
        rampFunc.setRampUp();
    }

    public boolean getIsRampUp() {
        return rampFunc.getIsRampUp();
    }


    public void loadCar(PersonalCar personalCar){
        rampFunc.loadCar(personalCar);

    }

    public void setFairDistance(boolean boolDistance) {
        rampFunc.setFairDistance(boolDistance);
    }


    public boolean getFairDistance() {
        return rampFunc.getFairDistance();
    }

    public void unloadCar(){
        rampFunc.unloadCar();
    }

    public ArrayList<PersonalCar> getLoadedCars() {
        return rampFunc.getLoadedCars();

    }
}
