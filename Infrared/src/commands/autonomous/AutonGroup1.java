package commands.autonomous;

import commands.lift.AutonDrive;
import commands.lift.AutonLift;
import commands.shoot.AutoFireSingle;
import commands.shoot.AutonSetShooter;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author matthew
 */
public class AutonGroup1 extends CommandGroup
{
    public AutonGroup1() {
        super();
        this.addParallel(new AutonSetShooter(), 10);
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new AutoFireSingle());
        this.addSequential(new AutonLift(), 0.5);
        this.addSequential(new AutonDrive(-1), 2);
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