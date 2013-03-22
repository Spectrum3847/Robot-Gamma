package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class DashboardShoot extends CommandBase {
    double front, middle, rear;

    public DashboardShoot() {
        requires(CommandBase.shooter);
    }

    protected void initialize() {
        SmartDashboard.putBoolean("dashboardShootingCMD", true);
        shooter.startEncoders();
        lights.disableLights();
    }

    protected void execute() {
        front = SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY ) + SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_OFFSET);
        middle = SmartDashboard.getNumber(Dashboard.MIDDLE_SHOOTER_RPM_KEY);
        rear = SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY);
        shooter.setBangBang(front, middle, rear, false);
        
        SmartDashboard.putNumber("Front RPM", shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Middle RPM", shooter.getMiddleEncoder().getRate());
        SmartDashboard.putNumber("Rear RPM", shooter.getRearEncoder().getRate());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0,0,0);
        shooter.resetEncoders();
        shooter.stopEncoders();
        
        lights.enableLights();

        SmartDashboard.putBoolean("dashboardShootingCMD", false);
    }

    protected void interrupted() {
        end();
    }
}
