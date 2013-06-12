package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 *
 * @author matthew
 */
public class DashboardShoot extends CommandBase {
    double front, middle, rear;
    boolean enabled = false;
    BangBang thread = new BangBang();

    public DashboardShoot() {
        requires(CommandBase.shooter);
    }
    
    private class BangBang extends Thread {
        public synchronized void run()
        {
            while(enabled)
            {
                shooter.setBangBang(front, middle, rear);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    protected void initialize() {
        SmartDashboard.putBoolean("dashboardShootingCMD", true);
        shooter.startEncoders();
        lights.disableLights();
        enabled = true;
        thread = new BangBang();
        thread.start();
    }

    protected void execute() {
        front = SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_RPM_KEY ) + SmartDashboard.getNumber(Dashboard.FRONT_SHOOTER_OFFSET);
        middle = SmartDashboard.getNumber(Dashboard.MIDDLE_SHOOTER_RPM_KEY);
        rear = SmartDashboard.getNumber(Dashboard.REAR_SHOOTER_RPM_KEY);
        //shooter.setBangBang(front, middle, rear);
        
        //if (CommandBase.flicker.getFlick() == 0){
        //   shooter.setBangBang(front, middle, rear); 
        //} else{
        //    shooter.setShooter(1, 1, 1);
        //}
        
        SmartDashboard.putNumber("Front RPM", shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Middle RPM", shooter.getMiddleEncoder().getRate());
        SmartDashboard.putNumber("Rear RPM", shooter.getRearEncoder().getRate());
        SmartDashboard.putBoolean("Shooter To Speed", shooter.atSpeeds(front, middle, rear, 200));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        enabled = false;
        shooter.setShooter(0,0,0);
        shooter.resetEncoders();
        shooter.stopEncoders();
        
        lights.enableLights();
        

        SmartDashboard.putBoolean("dashboardShootingCMD", false);
    }

    protected void interrupted() {
        enabled = false;
        end();
    }
}
