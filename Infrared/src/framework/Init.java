package framework;

import commands.CommandBase;
import commands.autonomous.AutonGroup1;
import commands.autonomous.AutonGroup2;
import commands.lift.LiftControl;
import commands.shoot.Flick;
import commands.shoot.PIDShoot;
import commands.shoot.PIDShooterFront;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author matthew
 */
public class Init {

    
    public static Command cheesydrive = new commands.driving.CheesyDrive();
    public static Command dashboardShoot = new commands.shoot.DashboardShoot();
    public static Command dashboardShootCollect = new commands.shoot.ShootCollect();
    public static PIDShoot PIDShootCommand = new commands.shoot.PIDShoot();
    public static Command test = new commands.test.TestClass();
    
    public static Command inc = new commands.shoot.FrontShooterInc();
    public static Command dec = new commands.shoot.FrontShooterDec();
    
    public static Command liftcontrol = new LiftControl();
    
    public static Command flick = new Flick();
    
    public static Command auton1 = new AutonGroup1();
    public static Command auton2 = new AutonGroup2();
    public static Command auton;
    
    public static DigitalInput auton_switch = new DigitalInput(HW.AUTON_KILL);
    public static DigitalInput auton_pick = new DigitalInput(HW.AUTON_PICK);

    public static void init() {
        CommandBase.init();
        
        Dashboard.intializeDashboard();
    }

    public static void periodic() {
    }
}
