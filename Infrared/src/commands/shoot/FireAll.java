package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author matthew
 */
public class FireAll extends CommandGroup {
    public FireAll() {
        super();
        requires(CommandBase.shooter);
        requires(CommandBase.flicker);
        
        this.addParallel(new DashboardShoot(), 5);
        
        /*
        this.addSequential(new AtSpeedFlick(), 0.5);
        this.addSequential(new AtSpeedFlick(), 0.5);
        this.addSequential(new AtSpeedFlick(), 0.5);
        this.addSequential(new AtSpeedFlick(), 0.5);
        */
        this.addSequential(new Flick(), 0.5);
        this.addSequential(new Flick(), 0.5);
        this.addSequential(new Flick(), 0.5);
        this.addSequential(new Flick(), 0.5);
        
    }
}
