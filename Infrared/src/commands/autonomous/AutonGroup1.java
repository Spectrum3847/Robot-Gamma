package commands.autonomous;

import commands.CommandBase;
import commands.driving.AutonDrive;
import commands.lift.AutonLift;
import commands.shoot.AutoFireSingle;
import commands.shoot.AutonSetShooter;
import commands.shoot.Flick;
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
        requires(CommandBase.shooter);
        requires(CommandBase.drivebase);
        requires(CommandBase.lift);
        requires(CommandBase.flicker);
        this.addParallel(new AutonSetShooter(), 15);
        this.addSequential(new WaitCommand(2));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(2.5));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(2.5));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(2.5));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(2.5));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(0.5));
        this.addSequential(new AutonLift(), 0.5);
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