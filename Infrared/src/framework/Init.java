package framework;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author matthew
 */
public class Init {

    public static Command tankdrive = new commands.drive.ManualTankDrive();
    public static Command shooter = new commands.drive.ManualShoot();

    public static void init() {
    }

    public static void periodic() {
    }
}
