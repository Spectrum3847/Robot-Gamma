package framework;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author matthew
 */
public class Teleop {
    public static void init()
    {
        Autonomous.cancel();
        Init.cheesydrive.start();
        Init.liftcontrol.start();
        Init.test.start();
        Init.dashboardShootCollect.start();
    }

    static int number = 0;

    public static void periodic()
    {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }
}