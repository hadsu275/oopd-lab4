package ModelCar;

import java.awt.*;

public class CarFactory {
    public static Vehicle createVolvo240(){
        return new Volvo240();
    }
    public static Vehicle createSaab95(){
        return new Saab95();
    }
    public static Vehicle createScania(){
        return new Scania();
    }
    public static Vehicle createIveco(){
        return new Iveco();
    }



}
