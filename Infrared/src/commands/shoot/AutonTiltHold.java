package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonTiltHold extends CommandBase {
    protected void initialize() {
    }

    protected void execute() {
        shooterTilt.motor.set(-0.225);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
