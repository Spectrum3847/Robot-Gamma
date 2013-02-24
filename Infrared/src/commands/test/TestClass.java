
package commands.test;

import commands.CommandBase;
import driver.MagEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class TestClass extends CommandBase {
    private MagEncoder encoder0;

    protected void initialize() {
        encoder0 = new MagEncoder(11, 12, 13);
        encoder0.start();
    }

    protected void execute() {
        SmartDashboard.putNumber("MagEncoder", encoder0.getPulseWidth());
        SmartDashboard.putNumber("MagEncoder Angle", encoder0.getAngle());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        encoder0.stop();
    }

    protected void interrupted() {
        end();
    }

}
