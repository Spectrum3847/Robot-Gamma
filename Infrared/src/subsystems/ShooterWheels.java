package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

public class ShooterWheels extends Subsystem {

    private Jaguar Wheel1;
    private Jaguar Wheel2;
   
    // Initialize your subsystem here
    public ShooterWheels() {
        super("ShooterWheels");
        
        Wheel1 = new Jaguar(HW.SHOOTER_FRONT_MOTOR);
        Wheel2 = new Jaguar(HW.SHOOTER_BACK_MOTOR);
    }
    
    
    public void initDefaultCommand() {
    }
    
    //sets shooter motors to PWM value (-1.0->1.0)
    public void setShooterWheel1(double speed){
       Wheel1.set(speed);
    }
    
    public void setShooterWheel2(double speed){
        Wheel2.set(speed);
    }
    
    public double getShooterWheel1(){
        return Wheel1.get();
    }
    
    public double getShooterWheel2(){
        return Wheel2.get();
    }
}
