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
        shooter.resetEncoders();
        
        shooter.getFrontEncoder().start();
        shooter.getRearEncoder().start();
    }

    protected void execute() {
        double trigger_val = -OI.gamepad_aux.getTriggers();// + -abs(OI.gamepad.getTriggers());
        
        shooter.setFrontMotor(trigger_val/(trigger_val<0?2:1));                             //If we are collecting divide the front wheel by 2
        shooter.setMiddleMotor(trigger_val);
        shooter.setRearMotor(trigger_val);
        
        SmartDashboard.putNumber("ShooterFront", shooter.getFrontMotor());
        SmartDashboard.putNumber("ShooterRear", shooter.getRearMotor());
        
        SmartDashboard.putNumber("Front RPM", shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Rear RPM", shooter.getRearEncoder().getRate());
        //SmartDashboard.putNumber("Front Shooter Motor Speed", shooter.getFrontEncoder().getRate());
        //SmartDashboard.putNumber("Rear Shooter Motor Speed", shooter.getRearEncoder().getRate());
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.setShooter(0,0,0);
        shooter.getFrontEncoder().stop();
        shooter.getRearEncoder().stop();
    }

    protected void interrupted() {
        end();
    }
}