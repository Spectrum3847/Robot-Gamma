package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.OI;


/*
 * @author Matthew
 */
public class ManualGamepadDrive extends CommandBase {
    public ManualGamepadDrive()
    {
        requires(CommandBase.drivebase);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
     drivebase.disableTurnController();
     SmartDashboard.putBoolean("Gamepad", true);           //Tell Smart Dashboard we are in tank mode
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivebase.setArcade(OI.gamepad.getLeftY(), OI.gamepad.getRightX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivebase.setArcade(0, 0);
        SmartDashboard.putBoolean("Gamepad", false);           //Tell Smart Dashboard we not in tank mode
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
