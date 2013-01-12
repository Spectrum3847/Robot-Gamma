package framework;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author matthew
 */
public class Teleop {
        public static void init()
        {
            Init.tankdrive.start();
            Init.shooter.start();
        }
        
        public static void periodic()
        {
            Scheduler.getInstance().run();
        }
}
