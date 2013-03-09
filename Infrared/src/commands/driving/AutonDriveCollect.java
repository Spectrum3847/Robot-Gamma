package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class AutonDriveCollect extends CommandBase {
    private String promt = Dashboard.DRIVEBASE_SPEED_KEY;
    
    public AutonDriveCollect() {
    }
    
    public AutonDriveCollect(String s) {
        promt = s;
    }

    protected void initialize() {
        drivebase.setCheesyDrive(SmartDashboard.getNumber(promt), 0, false);
        
        shooter.setFrontMotor(-0.75);
        shooter.setRearMotor(-1.0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivebase.setCheesyDrive(SmartDashboard.getNumber(promt), 0, false);
        
        shooter.setFrontMotor(0);
        shooter.setRearMotor(0);
    }

    protected void interrupted() {
        end();
    }   
}