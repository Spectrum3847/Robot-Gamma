package commands.shoot;

import commands.CommandBase;
import framework.Init;

/**
 *
 * @author matthew
 */
public class AutonFireDisc extends CommandBase {

    protected void initialize() {
        Init.flick.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !Init.flick.isRunning();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
