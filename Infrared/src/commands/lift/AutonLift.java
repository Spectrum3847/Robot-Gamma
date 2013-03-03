package commands.lift;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonLift extends CommandBase {
    protected void initialize() {
    }

    protected void execute() {
        lift.setSpeed(SmartDashboard.getNumber("Lift Auton Speed"));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
