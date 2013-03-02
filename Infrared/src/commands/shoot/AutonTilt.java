
package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonTilt extends CommandBase{

    protected void initialize() {
        this.setTimeout(SmartDashboard.getNumber("Auton Tilt Time", 0.0));
    }

    protected void execute() {
        shooterTilt.setSpeed(-1 * SmartDashboard.getNumber("Auton Tilt Speed"));
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        //shooterTilt.setSpeed(SmartDashboard.getNumber("Auton Tilt Lock Speed"));
    }

    protected void interrupted() {
    }

}
