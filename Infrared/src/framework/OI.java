package framework;

import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final Joystick driveStick_left = new Joystick(HW.usbPort_two);
    public static final Joystick driveStick_right = new Joystick(HW.usbPort_one);
    
        //Use this constructor to setup up button schedulers for commands
    public OI() {
        
    }
}
