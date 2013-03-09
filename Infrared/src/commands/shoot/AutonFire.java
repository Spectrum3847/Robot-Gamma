package commands.shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author matthew
 */
public class AutonFire extends CommandGroup {

    public AutonFire() {
        addSequential(new Flick());
    }
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
