package commands.autonomous;

import commands.lift.AutonLift;
import commands.shoot.AutonFire;
import commands.shoot.AutonTiltUnlock;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonSevenDiscs extends CommandGroup
{
    public AutonSevenDiscs() {
        super();
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        
        addSequential(new AutonTiltUnlock());
        
        addSequential(new AutonLift("Lift Auton Lower Speed"), SmartDashboard.getNumber("Auton Lift Time"));
        
        addSequential(new WaitCommand(.3));
        
        addSequential(new AutonFourDiscs(true));
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Called at end of Command
    public void end() {
    }
    
    // Call end() if interrupted
    public void interrupted() {
        end();
    }
}
