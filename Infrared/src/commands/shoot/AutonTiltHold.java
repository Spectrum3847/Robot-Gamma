package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonTiltHold extends CommandBase {
    protected void initialize() {
    }

    protected void execute() {
        shooterTilt.setSpeed(SmartDashboard.getNumber("Auton Tilt Lock Speed"));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
