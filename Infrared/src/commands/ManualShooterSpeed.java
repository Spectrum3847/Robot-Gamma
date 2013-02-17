package commands;

import commands.CommandBase;
import framework.OI;

/**
 *
 * @author matthew
 */
public class ManualShooterSpeed extends CommandBase {
    
    public ManualShooterSpeed() {
        requires(CommandBase.shooterWheels);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        //shoot.setShooter((OI.driveStick_right.getAxis(Joystick.AxisType.kZ)+1)/2);
        shooterWheels.setShooterWheel1(OI.xbox_controller2.getRawAxis(3));
        shooterWheels.setShooterWheel2(OI.xbox_controller2.getRawAxis(3));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterWheels.setShooterWheel1(0);
        shooterWheels.setShooterWheel2(0);
    }

    protected void interrupted() {
        end();
    }
}
