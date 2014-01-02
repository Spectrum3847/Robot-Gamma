package commands.lift;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonLiftLower extends CommandBase {
    
    protected void initialize() {
    }

    protected void execute() {
        lift.setSpeed(SmartDashboard.getNumber(Dashboard.LIFT_LOWER_SPEED_KEY));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        lift.setSpeed(0);
    }

    protected void interrupted() {
        end();
    }
    
}