package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author matthew
 */
public class AutonTiltUnlock extends CommandBase {
    Timer time;

    protected void initialize() {
        time  = new Timer();
        time.start();
    }

    protected void execute() {
        lift.setSpeed(time.get()<0.25?0.75:-0.6);
    }

    protected boolean isFinished() {
        return time.get()>0.4?true:false;
    }

    protected void end() {
        time.stop();
        lift.setSpeed(0);
    }

    protected void interrupted() {
        time.stop();
        lift.setSpeed(0);
    }

}