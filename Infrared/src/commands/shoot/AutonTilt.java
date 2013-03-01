
package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonTilt extends CommandBase{

    protected void initialize() {
    }

    protected void execute() {
        shooterTilt.setSpeed(SmartDashboard.getNumber("Auton Tilt Speed", 0.0));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterTilt.setSpeed(0);
    }

    protected void interrupted() {
    }

}
