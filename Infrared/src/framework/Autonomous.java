package framework;

import commands.autonomous.AutonFourDiscs;
import commands.autonomous.AutonSevenDiscs;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Autonomous {
    
    public static void init()
    {
        if(SmartDashboard.getBoolean(Dashboard.AUTON_ENABLED_KEY))
        {
            Init.auton = (SmartDashboard.getBoolean(Dashboard.AUTON_FOUR_SEVEN_KEY))?((Command) new AutonFourDiscs(false)):((Command) new AutonSevenDiscs());
            Init.auton.start();
        }
    }

    public static void periodic()
    {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }
    
    public static void cancel()
    {
        if(Init.auton != null) {
            Init.auton.cancel();
        }
    }
}
