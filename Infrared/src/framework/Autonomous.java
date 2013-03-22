package framework;

import commands.autonomous.AutonGroup1;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * @author matthew
 */
public class Autonomous {
    public static void init()
    {
        Init.auton = ((new DigitalInput(HW.AUTON_PICK)).get())?Init.auton2:Init.auton1;
        if((new DigitalInput(HW.AUTON_KILL)).get())
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
        if((new DigitalInput(HW.AUTON_KILL)).get())
        {
            Init.auton.cancel();
        }
    }
}
