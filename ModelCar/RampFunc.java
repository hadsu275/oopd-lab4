package ModelCar;

import java.util.ArrayList;

public class RampFunc implements TruckRamp {
    private boolean rampUp;
    private boolean loadMode;
    private boolean fairDistance;
    private int maxCapacity;
    private ArrayList<PersonalCar> loadedCars;
    private Vehicle vehicle;

    public RampFunc(Vehicle vehicle) {
        this.rampUp = true;
        this.loadMode = false;
        this.fairDistance = true;//  rimlig distans// ce med godsen;
        this.maxCapacity = 4;
        this.loadedCars = new ArrayList<>(maxCapacity);
        this.vehicle = vehicle;

    }

    public void setRampVehicle(Vehicle vehicle) {
        if (vehicle instanceof Iveco) {
            this.vehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("Du kan inte ha ett ramp på denna typ av bil.");
        }
    }
    @Override
    public void startLoadMode() {
        if (vehicle.getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Lastbilen står ej stilla.");
        }
        if (this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är redan i LoadMode.");
        }
        this.loadMode = true;

    }

    @Override
    public void exitLoadMode() {
        if (!this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är inte i LoadMode.");
        }
        this.loadMode = false;
    }

    @Override
    public boolean getLoadMode() {
        return this.loadMode;
    }

    @Override
    public void setRampDown() {
        if (!this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är ej i LoadMode.");
        }
        if (!this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan nere.");
        }
        this.rampUp = false;
    }

    @Override
    public void setRampUp() {
        if (!this.loadMode) {
            throw new IllegalArgumentException("Lastbilen är ej i LoadMode.");
        }
        if (this.rampUp) {
            throw new IllegalArgumentException("Rampen är redan uppe.");
        }
        this.rampUp = true;
    }

    @Override
    public boolean getIsRampUp() {
        return this.rampUp;
    }

    @Override
    public void loadCar(PersonalCar personalCar) {
        if (this.rampUp || !this.loadMode) {
            throw new IllegalArgumentException("Lastbilen skall stå still, ha rampen nere och vara i LoadMode.");
        }
        if (!this.fairDistance) {
            throw new IllegalArgumentException("Lastbilen är inte på ett rimligt avstånd till rampen.");
        }
        if (this.loadedCars.size() >= maxCapacity) {
            throw new IllegalArgumentException("Lastbilen kan inte lasta fler än " + maxCapacity + " bilar.");

        }
        this.loadedCars.add(personalCar);

    }

    @Override
    public void setFairDistance(boolean boolDistance) {
        if (this.fairDistance == boolDistance) {
            throw new IllegalArgumentException("FairDistance är redan det värdet.");
        }

        this.fairDistance = boolDistance;
    }

    @Override
    public boolean getFairDistance() {
        return this.fairDistance;
    }

    @Override
    public void unloadCar() {
        if (this.rampUp || !this.loadMode) {
            throw new IllegalArgumentException("Lastbilen ska stå stilla, ha rampen nere och vara i LoadMode.");
        }
        if (this.loadedCars.isEmpty()) {
            throw new IllegalArgumentException("Lastbilen har ingen bil lastad.");
        }

        this.loadedCars.remove(this.loadedCars.size() - 1);
    }

    @Override
    public ArrayList<PersonalCar> getLoadedCars() {
        return new ArrayList<>(this.loadedCars);

    }
}