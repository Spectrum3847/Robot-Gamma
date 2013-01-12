package commands.autonomousgroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author matthew
 */
public class Auton extends CommandGroup
{
    public Auton()
    {
        
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Called at end of Command
    public void end(){
    }
    
    // Call end() if interrupted
    public void interrupted(){
        end();
    }
}
