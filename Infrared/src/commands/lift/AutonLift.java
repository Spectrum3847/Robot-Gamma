package commands.lift;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.OI;

/**
 *
 * @author matthew
 */
public class AutonLift extends CommandBase {
    protected void initialize() {
        setTimeout(SmartDashboard.getNumber("Auton Lift Time"));
    }

    protected void execute() {
        lift.setSpeed(SmartDashboard.getNumber("Lift Auton Speed"));
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        lift.setSpeed(0.0);
    }

    protected void interrupted() {
        end();
    }
    
}
