package framework;

import commands.CommandBase;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author matthew
 */
public class Teleop {
        public static void init()
        {
            Init.halodirve.start();
            Init.shooterSpeed.start();
            Init.lift.start();
            System.out.println("Teleop Init");
        }
        
        public static void periodic()
        {
            Scheduler.getInstance().run();
            //CommandBase.solendoids.solenoid_ON();
        }
}
