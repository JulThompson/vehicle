package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving{
    private int modelNumber;
    /** modelNum specifies the model number. Tesla cares about that
    stuff. Tesla Model Z’s have a 340 mile range on a full charge. For a Tesla, the make is Tesla. 
    The model is Z. The model number is an additional value.*/
    public TeslaModelZ(double startingMileage, int modelNum) {
        super("Tesla", "Z"+modelNum,startingMileage,340);
        modelNumber = modelNum;
    }

    /** Defaults mileage to 0. */
    public TeslaModelZ(int modelNum) {
        this(0,modelNum);
    }

    /** Returns the model number.*/
    public int getModelNum() {
        return modelNumber;
    }

    /** Returns the model and model number concatenated together. For
    example, returns "Z70" for modelNum 70. */
    // public String getModel() {
    //     return super.getModel();
    // }

    /** Prints out the make, model, model number, and mileage.
    Ex: "Tesla Z70 (30.0 mi)"
    You may not need to implement this method depending on how you
    implement Car.toString()
    */
    // do not need to implement toString
    public void driveAutonomously(double miles) {
        if (miles < 0) throw new IllegalArgumentException("miles in driveAutonomously are negative.");
        if (miles > getRemainingRange()) drive(getRemainingRange());
        else drive(miles);
    }
}
