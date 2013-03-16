package commands.autonomous;

import commands.driving.AutonDriveCollect;
import commands.lift.AutonLift;
import commands.shoot.AutonFire;
import commands.shoot.AutonSetShooter;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonFourDiscs extends CommandGroup
{
    public AutonFourDiscs(boolean calledseven) {
        super();
        /*
        addSequential(new AutonDriveCollect(), SmartDashboard.getNumber(Dashboard.COLLECT_DRIVE_TIME_KEY + (calledseven?" 7 Disc":"")));
        addParallel(new AutonSetShooter());
        addSequential(new AutonLift(), SmartDashboard.getNumber(Dashboard.LIFT_TIME_KEY));
        addSequential(new AutonTilt(), SmartDashboard.getNumber(Dashboard.TILT_TIME_KEY));
        addParallel(new AutonTiltHold());
        addSequential(new WaitCommand(1));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        */
        
        addSequential(new AutonDriveCollect(), 4);
        addParallel(new AutonSetShooter());
        addSequential(new AutonLift(), 4);
        addSequential(new WaitCommand(1));
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
        addSequential(new AutonFire(), 1);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Called at end of Command
    public void end() {
        this.cancel();
    }
    
    // Call end() if interrupted
    public void interrupted() {
        end();
    }
}