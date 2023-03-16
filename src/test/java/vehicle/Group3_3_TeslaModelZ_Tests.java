package vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Group3_3_TeslaModelZ_Tests {
    @Test
    public void teslaConstructorTest1() {
        TeslaModelZ tesla = new TeslaModelZ(245);
        assertEquals(tesla.getModelNum(), 23, 0.1, "Model number not correct.");
        assertEquals(tesla.getModel(), "Z23", "Model not correct.");
        assertEquals(tesla.getMileage(), 0, 0.1, "Mileage should be 0.");
        assertEquals(tesla.getMaxRange(), 340, 0.1, "Fuel capacity not correct.");
        assertEquals(tesla.getRemainingRange(), tesla.getMaxRange(), 0.1, "Car should start fully charged.");
        assertEquals(tesla.toString(), "Tesla Z23 (0.0 mi)", "toString does not match.");
    }

    @Test
    public void teslaConstructorTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ teslaExcep = new TeslaModelZ(42, -1);
        }, "Initial mileage cannot be negative.");
        TeslaModelZ tesla = new TeslaModelZ(42, 35);
        assertEquals(tesla.getModelNum(), 42, 0.1, "Model number not correct.");
        assertEquals(tesla.getModel(), "Z42", "Model not correct.");
        assertEquals(tesla.getMileage(), 35, 0.1, "Mileage not correct.");
        assertEquals(tesla.getMaxRange(), 340, 0.1, "Fuel capacity not correct.");
        assertEquals(tesla.getRemainingRange(), tesla.getMaxRange(), 0.1, "Car should start fully charged.");
        assertEquals(tesla.toString(), "Tesla Z42 (35.0 mi)", "toString does not match.");
        TeslaModelZ tesla2 = new TeslaModelZ(0, 42);
        assertEquals(tesla2.getMileage(), 0, 0.1, "Mileage should be 0.");
    }

    @Test
    public void teslaDrivingTest1() {
        TeslaModelZ tesla = new TeslaModelZ(245);
        assertThrows(IllegalArgumentException.class, () -> {
            tesla.drive(-1);
        }, "Cannot drive negative distance.");
        tesla.drive(0);
        tesla.drive(30);
        assertEquals(tesla.getMileage(), 30, 0.1, "Mileage does not match distance driven.");
        tesla.drive(200);
        assertEquals(tesla.getMileage(), 230, 0.1, "Mileage does not match distance driven.");
        assertEquals(tesla.getRemainingRange(), 340, 0.1, "Remaining range after drive incorrect.");
        assertEquals(tesla.canDrive(111), false, "Should be false, cannot drive that distance.");
        assertEquals(tesla.canDrive(110), true, "Should be true, possible distance to drive.");
        tesla.drive(110);
        assertEquals(tesla.getMileage(), 340, 0.1, "Mileage does not match distance driven.");
        tesla.recharge();
        assertThrows(IllegalArgumentException.class, () -> {
            tesla.drive(341);
        }, "Driving past empty.");
        tesla.driveAutonomously(341);
        assertEquals(tesla.getMileage(), 680, 0.1, "Mileage does not match autonomously driven distance");
    }
}
