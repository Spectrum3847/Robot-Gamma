package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class DashboardCollect extends CommandBase {
    
    public DashboardCollect() {
        requires(CommandBase.shooter);
    }
    
    protected void initialize() {
        SmartDashboard.putBoolean("dashboardShootingCMD", true);
        shooter.resetEncoders();
        
        shooter.getFrontEncoder().start();
        shooter.getRearEncoder().start();

    }

    protected void execute() {
        shooter.setBangBang(SmartDashboard.getNumber(Dashboard.FRONT_COLLECTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_COLLECTER_RPM_KEY), true);
        
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
        
        SmartDashboard.putBoolean("dashboardCollectingCMD", false);
    }

    protected void interrupted() {
        end();
    }
}
