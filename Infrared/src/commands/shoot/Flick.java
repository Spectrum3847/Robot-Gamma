package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author matthew
 */
public class Flick extends CommandBase {
    Timer time;

    protected void initialize() {
        time  = new Timer();
        time.start();
    }

    protected void execute() {
        shooter.setFlick(time.get()<0.25?0.9:-0.6);
    }

    protected boolean isFinished() {
        return time.get()>0.4?true:false;
    }

    protected void end() {
        time.stop();
        shooter.setFlick(0);
    }

    protected void interrupted() {
        time.stop();
        shooter.setFlick(0);
    }

}
