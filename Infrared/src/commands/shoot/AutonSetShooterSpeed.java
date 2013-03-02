package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonSetShooterSpeed extends CommandBase {

    protected void initialize() {
    }

    protected void execute() {
        shooter.setFrontMotor(SmartDashboard.getNumber("Auton Shooter Front Speed"));                             //Set shooter speed
        shooter.setRearMotor(SmartDashboard.getNumber("Auton Shooter Rear Speed"));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
