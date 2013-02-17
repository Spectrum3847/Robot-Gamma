package subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Solenoids extends Subsystem {

    private Solenoid solenoid_1;

    // Initialize your subsystem here
    public Solenoids() {
        super("Solenoids");
        solenoid_1 = new Solenoid(1);
    }

    public void initDefaultCommand() {
    }

    public void solenoid_ON() {
        solenoid_1.set(true);
        System.out.println("Solenoid ON");
    }

    public void solenoid_OFF() {
        solenoid_1.set(false);
        System.out.println("Solenoid OFF");
    }
}
