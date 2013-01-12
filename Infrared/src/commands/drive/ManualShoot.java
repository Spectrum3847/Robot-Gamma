package commands.drive;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import framework.OI;

/**
 *
 * @author matthew
 */
public class ManualShoot extends CommandBase {
    
    public ManualShoot() {
        requires(CommandBase.shoot);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        //shoot.setShooter((OI.driveStick_right.getAxis(Joystick.AxisType.kZ)+1)/2);
        shoot.setShooter(OI.driveStick_right.getAxis(Joystick.AxisType.kZ));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shoot.setShooter(0);
    }

    protected void interrupted() {
        end();
    }
}
