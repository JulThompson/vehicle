package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying {
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        // super("Ford", "Frivolous", 23.6, 20);
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    public void driveAutonomously(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Cannot drive negative miles.");
        }
        if (getRemainingRange() / 2 < miles) {
            addMileage(getRemainingRange() / 2);
            decreaseFuelLevel(getRemainingRange());
        } else {
            decreaseFuelLevel(miles * 2);
            addMileage(miles);
        }
    }


    public boolean canFly(double miles) {
        return canDrive(miles * 3);
    }

    public void fly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Cannot drive negative miles.");
        }
        if (miles > getRemainingRange() / 3) {
            throw new IllegalArgumentException("Distance not within car's range.");
        }
        decreaseFuelLevel(miles * 3);
    }
}
