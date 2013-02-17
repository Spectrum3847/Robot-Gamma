/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.CommandBase;
/**
 *
 * @author JAG
 */
public class ES extends CommandBase {
    
    public ES() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(CommandBase.solendoids);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        CommandBase.solendoids.solenoid_ON();
        System.out.println("Command ON");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        CommandBase.solendoids.solenoid_OFF();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
