package commands.autonomous;

import commands.driving.AutonDriveCollect;
import commands.lift.AutonLift;
import commands.shoot.AutonFire;
import commands.shoot.AutonSetShooter;
import commands.shoot.AutonTilt;
import commands.shoot.AutonTiltHold;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonFourDiscs extends CommandGroup
{
    public AutonFourDiscs(boolean calledseven) {
        super();
        addSequential(new AutonDriveCollect(), SmartDashboard.getNumber("Auton Collect Drive Time" + (calledseven?" 7 Disc":"")));
        addParallel(new AutonSetShooter());
        addSequential(new WaitCommand(.3));
        addSequential(new AutonLift(), SmartDashboard.getNumber("Auton Lift Time"));
        addSequential(new AutonTilt(), SmartDashboard.getNumber("Auton Tilt Time"));
        addParallel(new AutonTiltHold());
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
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
