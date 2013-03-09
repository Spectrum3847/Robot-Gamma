package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 * @author matthew
 */
public class AutonomousDistanceRight extends PIDCommand {
    
    public AutonomousDistanceRight(double Kp, double Ki, double Kd) {
        super(Kp, Ki, Kd);
        this.getPIDController().setSetpoint(0.0);
    }

    protected double returnPIDInput() {
        return CommandBase.drivebase.getRightEncoder().getDistance();
    }
    
    public PIDController getController(){
        return this.getPIDController();
    }
    
    protected void usePIDOutput(double output) {
        CommandBase.drivebase.setRight(output);
    }

    protected void initialize() {
        CommandBase.drivebase.getRightEncoder().reset();
        CommandBase.drivebase.getRightEncoder().start();
        this.getPIDController().reset();
        this.getPIDController().enable();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        this.getPIDController().reset();                //Disable and Reset PIDController
        CommandBase.drivebase.getRightEncoder().reset();
        CommandBase.drivebase.getRightEncoder().stop();
        CommandBase.drivebase.setRight(0.0);
    }

    protected void interrupted() {
        end();
    }

}