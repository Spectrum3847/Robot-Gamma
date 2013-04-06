package commands.autonomous;

import commands.CommandBase;
import commands.driving.AutonDrive;
import commands.lift.AutonLift;
import commands.shoot.Flick;
import commands.shoot.AutonSetShooter;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author matthew
 */
public class AutonGroup2 extends CommandGroup
{
    public AutonGroup2() {
        super();
        requires(CommandBase.shooter);
        requires(CommandBase.drivebase);
        requires(CommandBase.lift);
        requires(CommandBase.flicker);
        this.addParallel(new AutonSetShooter(), 6);
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new AutonLift(), 0.5);
        this.addParallel(new AutonSetShooter(-0.65), 4);
        this.addSequential(new AutonDrive(0.85), 1.5);
        this.addSequential(new WaitCommand(1.5));
        this.addSequential(new AutonDrive(-0.85), 1.2);
        this.addParallel(new AutonSetShooter(), 6);
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
        this.addSequential(new WaitCommand(1));
        this.addSequential(new Flick());
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