package vehicle;

public interface SelfDriving {
    /** @throws IllegalArgumentException if miles is negative.*/
    public void driveAutonomously(double miles);
}

interface Flying {
    /** @throws IllegalArgumentException if miles is negative.*/
    public boolean canFly(double miles);
    
    /** @throws IllegalArgumentException if miles is negative.
     @throws IllegalArgumentException if miles exceeds the remaining
    range of the car.
    */
    public void fly(double miles);
}
