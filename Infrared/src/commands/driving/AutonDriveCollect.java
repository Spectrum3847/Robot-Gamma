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
        requires(drivebase);
        requires(shooter);
    }
    
    public AutonDriveCollect(String s) {
        promt = s;
        requires(drivebase);
        requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
        System.out.println(drivebase.getVictor(0).get());
        drivebase.getVictor(0).set(0.7);
        drivebase.getVictor(1).set(0.7);
        drivebase.getVictor(2).set(-0.6);
        drivebase.getVictor(3).set(-0.6);
        
        shooter.motor_f.set(-0.5);
        shooter.motor_r.set(-1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivebase.getVictor(0).set(0);
        drivebase.getVictor(1).set(0);
        drivebase.getVictor(2).set(0);
        drivebase.getVictor(3).set(0);
        
        shooter.motor_f.set(0);
        shooter.motor_r.set(0);
    }

    protected void interrupted() {
        end();
    }   
}