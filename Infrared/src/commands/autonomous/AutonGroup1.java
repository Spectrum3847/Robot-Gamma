package commands.autonomous;

import commands.CommandBase;
import commands.shoot.DashboardShoot;
import commands.shoot.FireAll;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author matthew
 */

//fires 3 discs
public class AutonGroup1 extends CommandGroup {

    public AutonGroup1() {
        super();
        requires(CommandBase.shooter);
        requires(CommandBase.drivebase);
        requires(CommandBase.lift);
        requires(CommandBase.flicker);
        
        this.addParallel(new DashboardShoot(), 2);
        this.addSequential(new WaitCommand(2));
        this.addSequential(new FireAll());
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
