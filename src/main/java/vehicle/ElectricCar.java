package vehicle;

public abstract class ElectricCar extends Car{
    double maxMiles;
    double milesLeft;
    /** Note: Car begins with a full charge (and thus range).
    @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);
        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException("milesOnMaxCharge is nonpositive.");
        }
        maxMiles = milesOnMaxCharge;
        milesLeft = milesOnMaxCharge;
    }

    /** Defaults mileage to 0.
    @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
    public ElectricCar (String make, String model, double milesOnMaxCharge) {
        this(make,model,0,milesOnMaxCharge);
    }

    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative.
    @throws IllegalArgumentException if miles is too high given the
    current charge.*/
    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("miles is negative");
        }
        else if (miles > milesLeft) {
            throw new IllegalArgumentException("miles is greater than milesLeft");
        }
        decreaseCharge(miles);
    }

    /** Returns how many more miles the car can currently go without
    recharging. */
    public double getRemainingRange() {
        return milesLeft;
    }

    /** Returns how many miles the car could go on a full charge. */
    public double getMaxRange() {
        return maxMiles;
    }

    /** Recharges the car to max range capability. */
    public void recharge() {
        milesLeft = maxMiles;
    }

    /** Decreases the amount of energy in the battery based by the number
    of miles passed as an argument. */
    protected void decreaseCharge(double miles) {
        milesLeft -= miles;
    }
}

