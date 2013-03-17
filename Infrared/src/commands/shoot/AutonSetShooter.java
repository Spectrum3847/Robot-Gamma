package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

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
        //shooter.setFrontMotor(SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_SPEED_KEY));                             
        //shooter.setRearMotor(SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_SPEED_KEY));
        shooter.setFrontMotor(0.75);                             
        shooter.setRearMotor(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0,0,0);
    }

    protected void interrupted() {
        end();
    }
}
