package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonTilt extends CommandBase {
    
    public AutonTilt() {
        requires(shooterTilt);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        //shooterTilt.setSpeed(-SmartDashboard.getNumber(Dashboard.TILT_SPEED_KEY));
        shooterTilt.motor.set(-0.55);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
