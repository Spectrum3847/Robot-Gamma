package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Init;
import framework.OI;

/**
 *
 * @author JAG
 */
public class LockTilt extends CommandBase {   
    public LockTilt() {
        requires(CommandBase.shooterTilt);
    }
    
    protected void initialize() {
        SmartDashboard.putBoolean("LockTiltCommand", true);
    }

    protected void execute() {
        shooterTilt.setDashboardSpeed();
        SmartDashboard.putNumber("shooterTilt", shooterTilt.getSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterTilt.setSpeed(0);
        
        SmartDashboard.putBoolean("LockTiltCommand", false);
    }

    protected void interrupted() {
        end();
    }
}
