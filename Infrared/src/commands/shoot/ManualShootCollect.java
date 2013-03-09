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
        double trigger_val = -OI.gamepad_aux.getTriggers();// + -abs(OI.gamepad.getTriggers());
        
        shooter.setFrontMotor(trigger_val/(trigger_val<0?2:1));                             //If we are collecting divide the front wheel by 2
        shooter.setRearMotor(trigger_val);
        
        SmartDashboard.putNumber("ShooterFront", shooter.getFrontMotor());
        SmartDashboard.putNumber("ShooterRear", shooter.getRearMotor());
        
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