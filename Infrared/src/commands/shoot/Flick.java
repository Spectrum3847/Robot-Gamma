
package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class Flick extends CommandBase {

    protected void initialize() {
        shooter.flickShooter(false);
    }

    protected void execute() {
        shooter.flickShooter(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.flickShooter(false);
    }

    protected void interrupted() {
        shooter.flickShooter(false);
    }

}
