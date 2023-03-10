package vehicle;

public abstract class Car {
    String carMake;
    String carModel;
    double startMileage;
    /** Creates a car with a starting mileage on the odometer.
    @throws IllegalArgumentException if startingMileage is negative*/
    public Car(String make, String model, double startingMileage) {
        carMake = make;
        carModel = model;
        if (startingMileage < 0) {
            throw new IllegalArgumentException("Cannot have a car with negative mileage.");
        }
        startMileage = startingMileage;

    }

    /** Starting mileage is 0. */
    public Car(String make, String model)

    /** If able to drive the full given number of miles, returns true. If
    not, returns false.
    @throws IllegalArgumentException if miles is negative.*/
    public boolean canDrive(double miles)

    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative or if miles is
    too high given the current fuel. */
    public abstract void drive(double miles)

    /** Gives String representation of Car as
    "<make and model> (<mileage> mi)"
    Mileage should be rounded to 1 decimal place. If mileage is a whole
    number, ".0" should still display.
    */
    public String toString()

    /** Returns how many miles have been driven so far (odometer). */
    public double getMileage()

    /** Returns the make of the car. */
    public String getMake()

    /** Returns the model of the car. */
    public String getModel()

    /** Returns how many more miles the car can currently go given the
    remaining fuel/energy reserves. */
    public abstract double getRemainingRange()

    /** Adds mileage to the odometer.
     @throws IllegalArgumentException if miles is negative. */
    protected void addMileage(double miles);

    /** The car attempts to drive, in order, each of the daily number of
    miles in the list milesEachDay. Once the car cannot drive one of the
    day’s distance, no more days are attempted. Returns the number of
    days successfully driven.
    @throws IllegalArgumentException if miles is negative for any of the
    attempted days. The exception check should occur prior to any driving
    is attempted. */
    public int roadTrip(List<Double> milesEachDay)
    abstract class GasPoweredCar ext
}
