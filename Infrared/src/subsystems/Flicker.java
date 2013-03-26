package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

/**
 * @author matthew
 */
public class Flicker extends Subsystem {
    private Jaguar flickmotor;
    
    public Flicker() {
        super("Flicker");
        
        flickmotor = new Jaguar(HW.FLICK_SHOOTER_MOTOR);
    }
    
    public void setFlick(double speed) {
        flickmotor.set(speed);
    }

    protected void initDefaultCommand() {
    }

}
