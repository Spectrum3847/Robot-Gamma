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
        lights.toggleLights();
    }

    protected void execute() {
        if(shooter.motor_f.get() > 0.1)
        {
            flicker.setFlick(time.get()<0.25?0.8:-0.8);
        }
    }

    protected boolean isFinished() {
        return time.get()>0.4?true:false;
    }

    protected void end() {
        time.stop();
        lights.toggleLights();
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
