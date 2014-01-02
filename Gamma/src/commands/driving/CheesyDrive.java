package commands.driving;

import commands.CommandBase;
import driver.Gamepad;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Init;
import framework.OI;
import framework.Utilities;


/*
 * @author Matthew
 */
public class CheesyDrive extends CommandBase {
    public CheesyDrive()
    {
        requires(CommandBase.drivebase);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
     Init.driveSelector.setDefaultDriveMode(this);
     drivebase.disableTurnController();
     SmartDashboard.putBoolean("Cheesy", true);           //Tell Smart Dashboard we are in cheesy mode
     drivebase.getLeftEncoder().start();
     drivebase.getRightEncoder().start();
     drivebase.getLeftEncoder().setReverseDirection(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double throttle = Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .1, .13);
        double wheel = Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .1, .13);
        boolean quickturn = OI.gamepad.getButton(Gamepad.RIGHT_CLICK);
        
        drivebase.setCheesySensetivity(SmartDashboard.getNumber("CheesySensetivity"));
        
        double quickTurnTriggers = OI.gamepad.getTriggers();
        if (quickTurnTriggers != 0){
            drivebase.setCheesyDrive(0, -1 * quickTurnTriggers, true);
            quickturn = true;
        } else{
            drivebase.setCheesyDrive(throttle, wheel,quickturn);
        }
        SmartDashboard.putBoolean("Quick Turn", quickturn);
        SmartDashboard.putNumber("Throttle", throttle);
        SmartDashboard.putNumber("Wheel", wheel);
        
        SmartDashboard.putNumber("Left Encoder", drivebase.getLeftEncoder().get());
        SmartDashboard.putNumber("Right Encoder", drivebase.getRightEncoder().get());
        SmartDashboard.putNumber("Left Velocity", drivebase.getLeftVelocity());
        SmartDashboard.putNumber("Right Velocity", drivebase.getRightVelocity());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivebase.setArcade(0, 0);
        SmartDashboard.putBoolean("Cheesy", false);           //Tell Smart Dashboard we not in tank mode
        drivebase.getLeftEncoder().stop();
        drivebase.getRightEncoder().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}