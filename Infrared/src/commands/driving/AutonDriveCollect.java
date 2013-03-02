package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonDriveCollect extends CommandBase {

    protected void initialize() {
        setTimeout(SmartDashboard.getNumber("Auton Collect Drive Time"));
    }

    protected void execute() {
        drivebase.setCheesyDrive(SmartDashboard.getNumber("DriveBase Auton Speed"),0,false);
        shooter.setFrontMotor(0.5);
        shooter.setRearMotor(1);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drivebase.setCheesyDrive(0, 0, false);
        shooter.setShooter(0.0);
    }

    protected void interrupted() {
        end();
    }
    
}
