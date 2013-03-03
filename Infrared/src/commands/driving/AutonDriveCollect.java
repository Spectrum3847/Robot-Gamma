package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonDriveCollect extends CommandBase {

    protected void initialize() {
    }

    protected void execute() {
        drivebase.setRight(SmartDashboard.getNumber("DriveBase Auton Speed"));
        drivebase.setLeft(SmartDashboard.getNumber("DriveBase Auton Speed"));
        
        shooter.setFrontMotor(0.5);
        shooter.setRearMotor(1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
