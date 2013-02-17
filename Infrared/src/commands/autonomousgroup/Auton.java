package commands.autonomousgroup;

import commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import framework.Init;

/**
 *
 * @author matthew
 */
public class Auton extends CommandGroup
{
    public Auton()
    {
        super();
        requires(CommandBase.drivebase);
        addParallel(Init.lautodrive);
        addParallel(Init.rautodrive);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        Init.lautodrive.getController().setSetpoint(10);
        Init.rautodrive.getController().setSetpoint(10);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Called at end of Command
    public void end(){
        Init.lautodrive.getController().reset();
        Init.rautodrive.getController().reset();
    }
    
    // Call end() if interrupted
    public void interrupted(){
        end();
    }
}
