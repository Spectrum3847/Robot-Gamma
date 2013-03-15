package subsystems;

import driver.OpticalEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;
import framework.HW;
import framework.Init;

public class Shooter extends Subsystem {

    
    public Jaguar motor_f, motor_r;
    private OpticalEncoder encoder_f;
    private OpticalEncoder encoder_r;
    public DigitalInput encoder_in;
    
    // Initialize your subsystem here
    public Shooter() {
        super("Shooter");
        
        encoder_f = new OpticalEncoder(HW.SHOOTER_FRONT_ENCODER);
        encoder_r = new OpticalEncoder(HW.SHOOTER_REAR_ENCODER);
        //encoder_in = new DigitalInput(HW.SHOOTER_REAR_ENCODER);
        
        motor_f = new Jaguar(HW.FRONT_SHOOTER_MOTOR);
        motor_r = new Jaguar(HW.REAR_SHOOTER_MOTOR);
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
    
    public void setBangBang(double setpoint_f, double setpoint_r, boolean collect){
        if(encoder_f.getRate() > setpoint_f)
            setShooter(0.0);
        else setShooter(collect?-1.0:1.0);
        
        if(encoder_r.getRate() > setpoint_r)
            setShooter(0.0);
        else setShooter(collect?-1.0:1.0);
    }
    
    public double getFrontMotor (){
        return motor_f.get();
    }
 
    public double getRearMotor (){
        return motor_r.get();
    }
    
    public double FrontMotorRate() {
        return encoder_f.getRate();
    }
    
    public double RearMotorRate() {
        return encoder_r.getRate();
    }
    
    public void resetEncoders() {
        encoder_f.reset();
        encoder_r.reset();
    }
    
    public OpticalEncoder getFrontEncoder() {
        return encoder_f;
    }
    
    public OpticalEncoder getRearEncoder() {
        return encoder_r;
    }
    
    public boolean getInput() {
        return encoder_in.get();
    }
}
