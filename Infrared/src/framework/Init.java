package framework;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author matthew
 */
public class Init {

    public static Command tankdrive = new commands.drive.ManualTankDrive();
    public static Command shooterSpeed = new commands.ManualShooterSpeed();
    public static Command halodirve = new commands.drive.ManualHaloDrive();
    public static Command lift = new commands.ManualLiftControl();
    public static Command solenoid = new commands.ES();

    public static void init() {
    }

    public static void periodic() {
    }
}
