package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

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
        shooter.resetEncoders();
        
        shooter.getFrontEncoder().start();
        shooter.getRearEncoder().start();

    }

    protected void execute() {
        shooter.setBangBang(SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY), false);
        
        SmartDashboard.putNumber("Front RPM", shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Rear RPM", shooter.getRearEncoder().getRate());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0);
        shooter.getFrontEncoder().stop();
        shooter.getRearEncoder().stop();
        
        SmartDashboard.putBoolean("dashboardShootingCMD", false);
    }

    protected void interrupted() {
        end();
    }
}
