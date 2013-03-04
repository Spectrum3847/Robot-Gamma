package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonDriveCollect extends CommandBase {
    private String promt = "DriveBase Auton Speed";
    
    public AutonDriveCollect() {
    }
    
    public AutonDriveCollect(String s) {
        promt = s;
    }

    protected void initialize() {
    }

    protected void execute() {
        drivebase.setRight(SmartDashboard.getNumber(promt));
        drivebase.setLeft(SmartDashboard.getNumber(promt));
        
        shooter.setFrontMotor(0.5);
        shooter.setRearMotor(1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivebase.setRight(SmartDashboard.getNumber(promt));
        drivebase.setLeft(SmartDashboard.getNumber(promt));
        
        shooter.setFrontMotor(0.5);
        shooter.setRearMotor(1.0);
    }

    protected void interrupted() {
    }
    
}
