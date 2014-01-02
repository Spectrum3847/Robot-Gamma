package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.OI;
import framework.Utilities;

/**
 *
 * @author matthew
 */
public class ManualShooterTilt extends CommandBase {   
    public ManualShooterTilt() {
        requires(CommandBase.shooterTilt);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        shooterTilt.setSpeed(Utilities.deadBand(OI.gamepad_aux.getRightY(), 0.1));
        SmartDashboard.putNumber("shooterTilt", shooterTilt.getSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterTilt.setSpeed(0);
    }

    protected void interrupted() {
        end();
    }
}