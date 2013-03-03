package commands.shoot;

import commands.CommandBase;
import framework.Init;

/**
 *
 * @author matthew
 */
public class AutonFire extends CommandBase {

    protected void initialize() {
    }

    protected void execute() {
        shooter.setFrontMotorDashboard();
        shooter.setRearMotorDashboard();
        Init.flick.start();
    }

    protected boolean isFinished() {
        return Init.flick.isCanceled();
    }

    protected void end() {
        shooter.setFrontMotor(0);
        shooter.setRearMotor(0);
    }

    protected void interrupted() {
    }

}
