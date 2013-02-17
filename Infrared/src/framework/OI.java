package framework;

import framework.HW;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final Joystick xbox_controller1 = new Joystick(HW.usbPort_one);
    public static final Joystick xbox_controller2 = new Joystick(HW.usbPort_two);
    
    public static final Button solenoid_but = new JoystickButton(xbox_controller1, 1);               //While Held
    
        //Use this constructor to setup up button schedulers for commands
    public OI() {
        solenoid_but.whileHeld(Init.solenoid);
    }
}
