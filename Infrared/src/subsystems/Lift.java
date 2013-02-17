package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

public class Shooter extends Subsystem {

    
    private Jaguar motor;
   
    // Initialize your subsystem here
    public Shooter() {
        super("Shooter");
        
        motor = new Jaguar(HW.FRONT_SHOOTER_MOTOR);
    }
    
    
    public void initDefaultCommand() {
    }
    
    //sets shooter motors to PWM value (-1.0->1.0)
    public void setShooter(double speed){
        motor.set(speed); 
    }
}
