package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonTilt extends CommandBase {
    protected void initialize() {
    }

    protected void execute() {
        shooterTilt.setSpeed(SmartDashboard.getNumber("Tilt Auton Speed"));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
