package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

public class ShooterTilt extends Subsystem {

    private Jaguar LiftMotor;
   
    // Initialize your subsystem here
    public ShooterTilt() {
        super("ShooterWheels");
        
        LiftMotor = new Jaguar(HW.LIFT_MOTOR);
    }
    
    
    public void initDefaultCommand() {
    }
    
    //sets shooter motors to PWM value (-1.0->1.0)
    public void setLiftSpeed(double speed){
       LiftMotor.set(speed);
    }
    
    public double getLiftSpeed(){
        return LiftMotor.get();
    }
}
