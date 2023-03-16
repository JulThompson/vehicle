package vehicle;

// created by Jacob Berger and Julia Thompson

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Group3_3_TeslaModelZ_Tests {
    @Test
    public void teslaConstructorTest1() {
        TeslaModelZ tesla = new TeslaModelZ(245);
        assertEquals(tesla.getModelNum(), 245, 0.1, "Model number not correct.");
        assertEquals(tesla.getModel(), "Z245", "Model not correct.");
        assertEquals(tesla.getMileage(), 0, 0.1, "Mileage should be 0.");
        assertEquals(tesla.getMaxRange(), 340, 0.1, "Fuel capacity not correct.");
        assertEquals(tesla.getRemainingRange(), tesla.getMaxRange(), 0.1, "Car should start fully charged.");
        assertEquals(tesla.toString(), "Tesla Z245 (0.0 mi)", "toString does not match.");
    }

    @Test
    public void teslaConstructorTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            TeslaModelZ teslaExcep = new TeslaModelZ(-1,42);
        }, "Initial mileage cannot be negative.");
        TeslaModelZ tesla = new TeslaModelZ(42, 35);
        assertEquals(tesla.getModelNum(), 35, 0.1, "Model number not correct.");
        assertEquals(tesla.getModel(), "Z35", "Model not correct.");
        assertEquals(tesla.getMileage(), 42, 0.1, "Mileage not correct.");
        assertEquals(tesla.getMaxRange(), 340, 0.1, "Fuel capacity not correct.");
        assertEquals(tesla.getRemainingRange(), tesla.getMaxRange(), 0.1, "Car should start fully charged.");
        assertEquals(tesla.toString(), "Tesla Z35 (42.0 mi)", "toString does not match.");
        TeslaModelZ tesla2 = new TeslaModelZ(45, 0);
        assertEquals(tesla2.getMileage(), 45, 0.1, "Mileage should be 45.");
    }
}
