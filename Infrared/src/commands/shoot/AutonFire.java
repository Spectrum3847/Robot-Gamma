package commands.shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author matthew
 */
public class AutonFire extends CommandGroup {

    protected void initialize() {
        addSequential(new Flick());
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
