package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 * @author matthew
 */
public class FrontShooterDec extends CommandBase {

    protected void initialize() {
        double tmp = SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_OFFSET) - 100;
        SmartDashboard.putNumber(Dashboard.FRONT_SHOOTER_OFFSET, tmp);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}