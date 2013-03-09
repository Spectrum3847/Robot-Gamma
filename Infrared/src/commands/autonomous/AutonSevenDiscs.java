package commands.autonomous;

import commands.lift.AutonLiftLower;
import commands.shoot.AutonFire;
import commands.shoot.AutonTiltUnlock;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonSevenDiscs extends CommandGroup
{
    public AutonSevenDiscs() {
        super();
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        addSequential(new AutonFire(), SmartDashboard.getNumber(Dashboard.FIRE_TIME_KEY));
        
        addSequential(new AutonTiltUnlock());
        
        addSequential(new AutonLiftLower(), SmartDashboard.getNumber("Auton Lift Time"));
        
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