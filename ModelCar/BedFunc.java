package ModelCar;

import java.util.Objects;

public class BedFunc implements TruckBed {
    private double tippingAngle;
    private final double maxTippingAngel = 70.0;
    private Vehicle vehicle;

    public BedFunc(Vehicle vehicle) {
        this.vehicle = vehicle;

    }

    public void setBedVehicle(Vehicle vehicle) {
        if (vehicle instanceof Scania) {
            this.vehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("Du kan inte ha ett flak på denna typ av bil.");
        }
    }

    @Override
    public double getTippingAngle(){
        return tippingAngle;
    }

    @Override
    public void increaseTipping(double angle) {
        if (vehicle.getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        if (angle < 0){
            throw new IllegalArgumentException("Angel kan inte var minder än noll");
        }

        tippingAngle = Math.min(tippingAngle + angle, maxTippingAngel );
    }

    @Override
    public void decreaseTipping(double angle) {
        if (vehicle.getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        if (angle < 0){
            throw new IllegalArgumentException("Angel kan inte var minder än noll");
        }
        tippingAngle = Math.max(tippingAngle - angle, 0 );
    }
}
