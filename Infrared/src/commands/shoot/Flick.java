package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author matthew
 */
public class Flick extends CommandBase {
    Timer time;
    double start = 0.1;
    double end = start + 0.1;
    
    public Timer getTimer() {
        return time;
    }

    protected void initialize() {
        //requires(flicker);
        time  = new Timer();
        time.start();
        lights.enableLights();
    }

    protected void execute() {
        if(shooter.motor_f.get() > 0.1)
        {
            flicker.setFlick(time.get()<start?0.8:-0.8);
            if(time.get()>=start)
                lights.disableLights();
        }
    }

    protected boolean isFinished() {
        return time.get()>end?true:false;
    }

    protected void end() {
        time.stop();
        lights.disableLights();
        flicker.setFlick(0);
    }
    
    public synchronized boolean isInterruptable() {
        return false;
    }
    protected void interrupted() {
        time.stop();
        flicker.setFlick(0);
        lights.toggleLights();
    }
}
