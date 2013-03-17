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
        //shooter.setBangBang(SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY), false);
        //shooter.setShooter(SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY));shooter.setBangBang(SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY), false);
        shooter.setBangBang(SmartDashboard.getNumber("FRONT MOTOR IN"), SmartDashboard.getNumber(Dashboard.MIDDLE_SHOOTER_RPM_KEY), SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY), false);
        //shooter.motor_f.set(SmartDashboard.getNumber("FRONT MOTOR IN"));
        //shooter.motor_m.set(SmartDashboard.getNumber("MIDDLE MOTOR IN"));
        //shooter.motor_r.set(SmartDashboard.getNumber("REAR MOTOR IN"));
        SmartDashboard.putNumber("Front RPM", shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Rear RPM", shooter.getRearEncoder().getRate());
        //System.out.println("Front Ticks: " + Integer.toString(shooter.getFrontEncoder().getTicks()) + " Rear Ticks: " + Integer.toString(shooter.getRearEncoder().getTicks()));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0,0,0);

        SmartDashboard.putBoolean("dashboardShootingCMD", false);
    }

    protected void interrupted() {
        end();
    }
}
