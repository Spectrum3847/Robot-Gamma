package subsystems;

import driver.OpticalEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.HW;
import framework.Init;

public class Shooter extends Subsystem {

    
    private Jaguar motor_f, motor_r;
    private OpticalEncoder encoder;
    public DigitalInput encoder_in;
    private final Jaguar flickmotor;
   
    // Initialize your subsystem here
    public Shooter() {
        super("Shooter");
        
        encoder = new OpticalEncoder(HW.SHOOTER_ENCODER);
        //encoder_in = new DigitalInput(HW.SHOOTER_ENCODER);
        
        motor_f = new Jaguar(HW.FRONT_SHOOTER_MOTOR);
        motor_r = new Jaguar(HW.REAR_SHOOTER_MOTOR);
        flickmotor = new Jaguar(HW.FLICK_SHOOTER_MOTOR);
        
        encoder.start();
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(Init.manualshootcollect);   // set default command
    }
    
    //sets shooter motors to PWM value (-1.0->1.0)
    public void setShooter(double speed){
        setFrontMotor(speed); 
        setRearMotor(speed);
    }
    
    public void setFrontMotor(double speed) {
        motor_f.set(speed);
    }
    
    public void setRearMotor(double speed) {
        motor_r.set(speed);
    }
    
    public void setFrontMotorDashboard(){
        setFrontMotor(SmartDashboard.getNumber("FrontMotorInput"));
    }
    
    public void setRearMotorDashboard(){
        setRearMotor(SmartDashboard.getNumber("RearMotorInput"));
    }
    
    public double getFrontMotor (){
        return motor_f.get();
    }
 
    public double getRearMotor (){
        return motor_r.get();
    }
    public void setFlick(double speed) {
        flickmotor.set(speed);
    }
    
    public double getRate() {
        return encoder.getRate();
    }
    
    public void resetEncoder() {
        encoder.reset();
    }
    
    public OpticalEncoder getEncoder() {
        return encoder;
    }
    
    public boolean getInput() {
        return encoder_in.get();
    }
}
