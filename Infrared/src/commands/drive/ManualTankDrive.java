package commands.drive;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.OI;


/*
 * @author Matthew
 */
public class ManualTankDrive extends CommandBase {
    
    
    
    public ManualTankDrive()
    {
     //   setInterruptible(false);
        requires(CommandBase.drivebase);
    }
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
     drivebase.disableTurnController();
     SmartDashboard.putBoolean("Tank", true);           //Tell Smart Dashboard we are in tank mode
     drivebase.getLeftEncoder().start();
     drivebase.getRightEncoder().start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivebase.setLeft(OI.driveStick_left.getY());
        SmartDashboard.putNumber("Left Encoder", drivebase.getLeftEncoder().getDistance());
        drivebase.setRight(OI.driveStick_right.getY());
        SmartDashboard.putNumber("Right Encoder", drivebase.getRightEncoder().getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true or it is interrupted.
    protected void end() {
        drivebase.setLeft(0);
        drivebase.setRight(0);
        drivebase.getLeftEncoder().reset();
        drivebase.getRightEncoder().reset();
        drivebase.getLeftEncoder().stop();
        drivebase.getRightEncoder().stop();
        SmartDashboard.putBoolean("Tank", false);           //Tell Smart Dashboard we are not in tank mode
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
