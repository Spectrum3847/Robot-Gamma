package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonSetShooter extends CommandBase {
    
    public AutonSetShooter() {
    }
    
    protected void initialize() {

    }

    protected void execute() {
        shooter.setFrontMotor(SmartDashboard.getNumber("Auton Front Shooter Speed"));                             
        shooter.setRearMotor(SmartDashboard.getNumber("Auton Rear Shooter Speed"));   
        SmartDashboard.putNumber("ShooterFront", shooter.getFrontMotor());
        SmartDashboard.putNumber("ShooterRear", shooter.getRearMotor());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0);
    }

    protected void interrupted() {
        end();
    }
}
