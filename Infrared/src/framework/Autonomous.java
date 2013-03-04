package framework;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * @author matthew
 */
public class Autonomous {
    
    public static Victor vic_5 = new Victor(HW.MIDDLE_LDRIVE_MOTOR);
    public static void init()
    {
        Init.autonFourDiscs.start();
    }

    public static void periodic()
    {
        Scheduler.getInstance().run();
        vic_5.set(CommandBase.drivebase.getVictor(3).get());
        Dashboard.updateDashboard();
    }
}
