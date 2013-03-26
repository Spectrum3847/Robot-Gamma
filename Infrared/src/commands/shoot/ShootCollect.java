package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;
import framework.OI;

/**
 *
 * @author matthew
 */
public class ShootCollect extends CommandBase {
    boolean collect_toggle = false, shoot_toggle = false;
    
    public ShootCollect() {
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.startEncoders();
        lights.enableLights();
    }

    protected void execute() {
        if(OI.gamepad_aux.getDPadLeftRight() != 0)
        {
            if(OI.gamepad_aux.getDPadLeftRight() > 0)
                collect_toggle = !collect_toggle;
            else
                shoot_toggle = !shoot_toggle;
        }
        
        else
        {
            double trigger_val = -OI.gamepad_aux.getTriggers();
            shooter.setFrontMotor(trigger_val*(trigger_val<0?2:SmartDashboard.getNumber(Dashboard.FRONT_MOTOR_ANALOG_SCALE_KEY)));  //If we are collecting divide the front wheel by 2
            shooter.setMiddleMotor(trigger_val*SmartDashboard.getNumber(Dashboard.MIDDLE_MOTOR_ANALOG_SCALE_KEY));
            shooter.setRearMotor(trigger_val*SmartDashboard.getNumber(Dashboard.REAR_MOTOR_ANALOG_SCALE_KEY));
        
            SmartDashboard.putNumber("Shooter Front Voltage", shooter.getFrontMotor());
            SmartDashboard.putNumber("Shooter Middle Voltage", shooter.getMiddleMotor());
            SmartDashboard.putNumber("Shooter Rear Voltage", shooter.getRearMotor());
        }
        
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
        
        lights.disableLights();
    }

    protected void interrupted() {
        end();
    }
}