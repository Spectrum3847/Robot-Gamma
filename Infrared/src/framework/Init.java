package framework;

import commands.CommandBase;
import commands.driving.AutonomousDistanceLeft;
import commands.driving.AutonomousDistanceRight;
import commands.driving.DriveSelector;
import commands.lift.LiftControl;
import commands.shoot.Flick;
import commands.shoot.LockTilt;
import commands.shoot.ManualShootCollect;
import commands.shoot.ManualShooterTilt;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author matthew
 */
public class Init {

    
    public static final DriveSelector driveSelector = new DriveSelector();
    public static Command gamepaddrive = new commands.driving.HaloDrive();
    public static Command cheesydrive = new commands.driving.CheesyDrive();
    public static Command shooter = new commands.shoot.ManualShootCollect();
    public static Command dashboardShoot = new commands.shoot.DashboardShoot();
    public static Command test = new commands.test.TestClass();
    
    public static Command liftcontrol = new LiftControl();
    public static Command locktilt = new LockTilt();
    
    public static Command manualshootertilt = new ManualShooterTilt();
    
    public static Command manualshootcollect = new ManualShootCollect();
    
    public static Command flick = new Flick();
    
    public static AutonomousDistanceLeft lautodrive = new commands.driving.AutonomousDistanceLeft(0, 0, 0);
    public static AutonomousDistanceRight rautodrive = new commands.driving.AutonomousDistanceRight(0, 0, 0);

    public static void init() {
        CommandBase.init();
        
        Dashboard.intializeDashboard();
    }

    public static void periodic() {
    }
}
