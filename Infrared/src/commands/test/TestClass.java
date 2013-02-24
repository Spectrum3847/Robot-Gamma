package commands.test;

import com.sun.squawk.platform.posix.natives.Time;
import commands.CommandBase;
import driver.MagEncoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class TestClass extends CommandBase {

    protected void initialize() {
    }

    protected void execute() {
        SmartDashboard.putNumber("Alive", Timer.getFPGATimestamp());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        SmartDashboard.putNumber("Alive", 0);
    }

    protected void interrupted() {
        end();
    }

}
