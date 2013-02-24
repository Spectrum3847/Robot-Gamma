package framework;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author matthew
 */
public class Teleop {
        public static void init()
        {
            Init.gamepaddrive.start();
            Init.shooter.start();
            Init.liftcontrol.start();
            Init.test.start();
        }
        
        public static void periodic()
        {
            Scheduler.getInstance().run();
        }
}