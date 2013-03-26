package framework;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * @author matthew
 */
public class Autonomous {
    public static void init()
    {
        Init.auton = Init.auton1; //(Init.auton_pick.get())?Init.auton2:Init.auton1;
        if(Init.auton_switch.get())
        {
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
        Init.auton = Init.auton1;
        if(Init.auton_switch.get())
        {
            Init.auton.cancel();
        }
    }
}
