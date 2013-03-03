package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class DashboardShoot extends CommandBase {
    
    public DashboardShoot() {
        requires(CommandBase.shooter);
    }
    
    protected void initialize() {
        SmartDashboard.putBoolean("dashboardShootingCMD", true);

    }

    protected void execute() {
        shooter.setFrontMotorDashboard();                             //If we are collecting divide the front wheel by 4
        shooter.setRearMotorDashboard();
        SmartDashboard.putNumber("ShooterFront", shooter.getFrontMotor());
        SmartDashboard.putNumber("ShooterRear", shooter.getRearMotor());
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0);
        shooter.getEncoder().stop();
        
        SmartDashboard.putBoolean("dashboardShootingCMD", false);
    }

    protected void interrupted() {
        end();
    }
}
