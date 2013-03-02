package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author matthew
 */
public class Flick extends CommandBase {
    Timer time;
    double flickOutTime = .25;
    double flickOutPower = 0.8;
    double flickInTime = 0.15;
    double flickInPower = -.6;

    protected void initialize() {
        time  = new Timer();
        time.start();
    }

    protected void execute() {
        shooter.setFlick(time.get()<flickOutTime?flickOutPower:flickInPower);
    }

    protected boolean isFinished() {
        return time.get()>(flickOutTime + flickInTime)?true:false;
    }

    protected void end() {
        time.stop();
        shooter.setFlick(0);
    }

    protected void interrupted() {
        end();
    }

}
