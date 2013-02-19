package framework;

import commands.CommandBase;
import commands.driving.AutonomousDistanceLeft;
import commands.driving.AutonomousDistanceRight;
import commands.lift.LiftControl;
import commands.shoot.Flick;
import commands.shoot.ManualShootCollect;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author matthew
 */
public class Init {

    public static Command gamepaddrive = new commands.driving.ManualGamepadDrive();
    public static Command shooter = new commands.shoot.ManualShootCollect();
    public static Command test = new commands.test.TestClass();
    
    public static Command liftcontrol = new LiftControl();
    
    public static Command manualcollect = new ManualShootCollect();
    
    public static Command flick = new Flick();
    
    public static AutonomousDistanceLeft lautodrive = new commands.driving.AutonomousDistanceLeft(0, 0, 0);
    public static AutonomousDistanceRight rautodrive = new commands.driving.AutonomousDistanceRight(0, 0, 0);

    public static void init() {
        CommandBase.init();
    }

    public static void periodic() {
    }
}
