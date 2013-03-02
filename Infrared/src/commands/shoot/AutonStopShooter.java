package commands.shoot;

import commands.CommandBase;

/**
 *
 * @author matthew
 */
public class AutonStopShooter extends CommandBase {

    protected void initialize() {
        shooter.setFrontMotor(0.0);                             //Set shooter speed
        shooter.setRearMotor(0.0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
