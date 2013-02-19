package framework;

import driver.Gamepad;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final Gamepad gamepad = new Gamepad(HW.usbPort_one);
    public static final Gamepad gamepad_aux = new Gamepad(HW.usbPort_two);
    
    public static final Button flick = new JoystickButton(gamepad_aux.getGamepad(), Gamepad.RIGHT_BUMPER);
    public static final Button flick2 = new JoystickButton(gamepad_aux.getGamepad(), Gamepad.LEFT_BUMPER);
    
        //Use this constructor to setup up button schedulers for commands
    public OI() {
        //flick.whileHeld(Init.flickshooter);
        //flick2.whileHeld(Init.unflickshooter);
        flick.whenPressed(Init.flick);
        flick2.whenPressed(Init.flick);
    }
}
