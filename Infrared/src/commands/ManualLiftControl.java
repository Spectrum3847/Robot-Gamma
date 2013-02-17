package commands;

import commands.CommandBase;
import framework.OI;

/**
 *
 * @author JAG
 */
public class ManualLiftControl extends CommandBase {
    
    public ManualLiftControl() {
        requires(CommandBase.lift);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        //shoot.setShooter((OI.driveStick_right.getAxis(Joystick.AxisType.kZ)+1)/2);
        lift.setLiftSpeed(OI.xbox_controller2.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        lift.setLiftSpeed(0);
    }

    protected void interrupted() {
        end();
    }
}
