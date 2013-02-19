package commands.driving;

import commands.CommandBase;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 * @author matthew
 */
public class AutonomousDistanceLeft extends PIDCommand {
    
    public AutonomousDistanceLeft(double Kp, double Ki, double Kd) {
        super(Kp, Ki, Kd);
        this.getPIDController().setSetpoint(0.0);
    }

    protected double returnPIDInput() {
        return CommandBase.drivebase.getLeftEncoder().getDistance();
    }
    
    public PIDController getController(){
        return this.getPIDController();
    }

    protected void usePIDOutput(double output) {
        CommandBase.drivebase.setLeft(output);
    }

    protected void initialize() {
        CommandBase.drivebase.getLeftEncoder().reset();
        CommandBase.drivebase.getLeftEncoder().start();
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
        CommandBase.drivebase.getLeftEncoder().reset();
        CommandBase.drivebase.getLeftEncoder().stop();
        CommandBase.drivebase.setLeft(0.0);
    }

    protected void interrupted() {
        end();
    }

}
