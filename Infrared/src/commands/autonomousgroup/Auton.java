package commands.autonomousgroup;

import commands.CommandBase;
import commands.driving.AutonDriveCollect;
import commands.lift.AutonLift;
import commands.shoot.AutonFire;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class Auton extends CommandGroup
{
    public Auton() {
        super();
        requires(CommandBase.drivebase);
        addSequential(new AutonDriveCollect(), SmartDashboard.getNumber("Auton Collect Drive Time"));
        addSequential(new AutonLift(), SmartDashboard.getNumber("Auton Lift Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
        addSequential(new AutonFire(), SmartDashboard.getNumber("Auton Fire Time"));
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Called at end of Command
    public void end() {
        //Init.lautodrive.getController().reset();
        //Init.rautodrive.getController().reset();
    }
    
    // Call end() if interrupted
    public void interrupted() {
        end();
    }
}
