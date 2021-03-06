package commands.driving;

import commands.CommandBase;
import driver.Gamepad;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;
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
     drivebase.disableTurnController();
     drivebase.getLeftEncoder().start();
     drivebase.getRightEncoder().start();
     drivebase.getLeftEncoder().setReverseDirection(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double throttle = Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .1, .13);
        double wheel = Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .1, .13);
        boolean quickturn = OI.gamepad.getButton(Gamepad.RIGHT_CLICK);
        
        drivebase.setCheesySensetivity(SmartDashboard.getNumber(Dashboard.CHEESY_SENSITIVITY_KEY));
        
        double quickTurnTriggers = OI.gamepad.getTriggers();
        if (quickTurnTriggers != 0){
            drivebase.setCheesyDrive(0, -1 * quickTurnTriggers, true);
            quickturn = true;
        } else{
            drivebase.setCheesyDrive(throttle, wheel,quickturn);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivebase.setArcade(0, 0);
        drivebase.getLeftEncoder().stop();
        drivebase.getRightEncoder().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}