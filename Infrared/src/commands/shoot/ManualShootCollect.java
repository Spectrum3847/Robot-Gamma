package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.OI;

/**
 *
 * @author matthew
 */
public class ManualShootCollect extends CommandBase {
    
    private static double abs(double a) {
        return a<0?-a:a;
    }
    
    public ManualShootCollect() {
        requires(CommandBase.shooter);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        shooter.setShooter(-OI.gamepad_aux.getTriggers() + -abs(OI.gamepad.getTriggers()));
        shooter.setTiltMotor(OI.gamepad_aux.getRightY());
        
        SmartDashboard.putNumber("ShooterRate", shooter.getRate());
        SmartDashboard.putNumber("Optical Encoder Ticks", shooter.getEncoder().getTicks());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0);
        shooter.getEncoder().stop();
    }

    protected void interrupted() {
        end();
    }
}
