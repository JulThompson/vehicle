package vehicle;

import java.util.List;

public abstract class Car {
    private String carMake;
    private String carModel;
    private double mileage;
    /** Creates a car with a starting mileage on the odometer.
    @throws IllegalArgumentException if startingMileage is negative*/
    public Car(String make, String model, double startingMileage) {
        if (startingMileage < 0) {
            throw new IllegalArgumentException("Cannot have a car with a negative mileage.");
        }
        carMake = make;
        carModel = model;
        mileage = startingMileage;

    }

    /** Starting mileage is 0. */
    public Car(String make, String model) {
        carMake = make;
        carModel = model;
        mileage = 0;
    }

    /** If able to drive the full given number of miles, returns true. If
    not, returns false.
    @throws IllegalArgumentException if miles is negative.*/
    public boolean canDrive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Cannot drive negative miles.");
        }
        if (miles <= getRemainingRange()) {
            return true;
        } else {
            return false;
        }
    }

    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative or if miles is
    too high given the current fuel. */
    public abstract void drive(double miles);

    /** Gives String representation of Car as
    "<make and model> (<mileage> mi)"
    Mileage should be rounded to 1 decimal place. If mileage is a whole
    number, ".0" should still display.
    */
    public String toString() {
        return String.format("%s %s (%.1f mi)",carMake,carModel,mileage);
    }

    /** Returns how many miles have been driven so far (odometer). */
    public double getMileage() {
        return mileage;
    }

    /** Returns the make of the car. */
    public String getMake() {
        return carMake;
    }

    /** Returns the model of the car. */
    public String getModel() {
        return carModel;
    }

    /** Returns how many more miles the car can currently go given the
    remaining fuel/energy reserves. */
    public abstract double getRemainingRange();

    /** Adds mileage to the odometer.
     @throws IllegalArgumentException if miles is negative. */
    protected void addMileage(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Cannot drive negative miles.");
        }
        mileage += miles;
    }

    /** The car attempts to drive, in order, each of the daily number of
    miles in the list milesEachDay. Once the car cannot drive one of the
    day’s distance, no more days are attempted. Returns the number of
    days successfully driven.
    @throws IllegalArgumentException if miles is negative for any of the
    attempted days. The exception check should occur prior to any driving
    is attempted. */
    public int roadTrip(List<Double> milesEachDay) {
        int daysDriven = 0;
        for (double miles: milesEachDay) {
            if (miles < 0) {
                throw new IllegalArgumentException("Cannot drive negative miles.");
            }
            if (canDrive(miles) == false) {
                return daysDriven;
            }
            drive(miles);
            daysDriven++;
        }
        return daysDriven;
    }
}

