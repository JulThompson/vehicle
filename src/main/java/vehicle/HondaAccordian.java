package vehicle;

public class HondaAccordian extends GasPoweredCar {
    private int year;
    /** modelYear specifies the year this car was made. Honda cares about
    that stuff. All Honda Accordian models have 14.5 gallon tanks and
    33.2 MPG. */
    public HondaAccordian(double startingMileage, int modelYear) {
        super("Honda", "Accordian", startingMileage, 33.2, 14.5);
        year = modelYear;
    }
    /** Defaults mileage to 0. */
    public HondaAccordian(int year) {
        super("Honda", "Accordian", 0, 33.2, 14.5);
        this.year = year;
    }
    /** Prints out the model year, make and model, and mileage.
    Ex: "2019 Honda Accordian (<mileage> mi)"
    Coding tip: Write this method to re-use the behavior of the
    superclass toString. Don’t copy-and-paste the same code here. */
    public String toString()  {
        return String.format("%s %s %s (%.1f mi)",year,getMake(),getModel(),getMileage());
    }
}
