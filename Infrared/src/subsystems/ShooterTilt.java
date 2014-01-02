package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.HW;
import framework.Init;

/**
 *
 * @author matthew
 */
public class ShooterTilt extends Subsystem{

    private Jaguar motor;
   
    // Initialize your subsystem here
    public ShooterTilt() {
        super("ShooterTilt");
        motor = new Jaguar(HW.TILT_SHOOTER_MOTOR);
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(Init.manualshootertilt);   // set default command
    }
    
    //sets shooter motors to PWM value (-1.0->1.0)
    public void setSpeed(double speed){
        motor.set(speed); 
    }
    
    public void setDashboardSpeed(){
        motor.set(-1 * SmartDashboard.getNumber("LockTilt"));
    }
    
    public double getSpeed (){
        return motor.get();
    }
}