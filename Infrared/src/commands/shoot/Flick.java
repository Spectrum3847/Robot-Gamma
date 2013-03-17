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
        //requires(flicker);
        time  = new Timer();
        time.start();
    }

    protected void execute() {
        flicker.setFlick(time.get()<0.25?0.75:-0.75);
    }

    protected boolean isFinished() {
        return time.get()>0.4?true:false;
    }

    protected void end() {
        time.stop();
        flicker.setFlick(0);
    }
    
    public synchronized boolean isInterruptable() {
        return false;
    }
    protected void interrupted() {
        time.stop();
        flicker.setFlick(0);
    }
}
