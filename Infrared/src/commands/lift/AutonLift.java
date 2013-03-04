package commands.lift;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class AutonLift extends CommandBase {
    private String promt = "Lift Auton Speed";
    
    public AutonLift() {
    }
    
    public AutonLift(String s) {
        promt = s;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        lift.setSpeed(SmartDashboard.getNumber(promt));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
