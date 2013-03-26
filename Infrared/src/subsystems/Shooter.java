package subsystems;

import driver.OpticalEncoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;
import framework.Init;
import framework.Utilities;

public class Shooter extends Subsystem {

    
    public Jaguar motor_f, motor_m, motor_r;
    private OpticalEncoder encoder_f;
    private OpticalEncoder encoder_m;
    private OpticalEncoder encoder_r;
    
    // Initialize your subsystem here
    public Shooter() {
        super("Shooter");
        
        encoder_f = new OpticalEncoder(HW.SHOOTER_FRONT_ENCODER);
        encoder_m = new OpticalEncoder(HW.SHOOTER_MIDDLE_ENCODER);
        encoder_r = new OpticalEncoder(HW.SHOOTER_REAR_ENCODER);
        
        motor_f = new Jaguar(HW.FRONT_SHOOTER_MOTOR);
        motor_m = new Jaguar(HW.MIDDLE_SHOOTER_MOTOR);
        motor_r = new Jaguar(HW.REAR_SHOOTER_MOTOR);
    }
    
    
    public void initDefaultCommand() {
        this.setDefaultCommand(Init.dashboardShootCollect);
    }
    
    public void setShooter(double front, double middle, double rear){
        setFrontMotor(front); 
        setMiddleMotor(middle);
        setRearMotor(rear);
    }
    
    public void setFrontMotor(double speed) {
        motor_f.set(speed);
    }
    
    public void setMiddleMotor(double speed) {
        motor_m.set(speed);
    }
    
    public void setRearMotor(double speed) {
        motor_r.set(speed);
    }
    
//    public void setFrontMotorDashboard(){
//        setFrontMotor(SmartDashboard.getNumber("FrontMotorInput"));
//    }
//    
//    public void setMiddleMotorDashboard(){
//        setRearMotor(SmartDashboard.getNumber("MiddleMotorInput"));
//    }
//    
//    public void setRearMotorDashboard(){
//        setRearMotor(SmartDashboard.getNumber("RearMotorInput"));
//    }
    
    public void setBangBang(double setpoint_f, double setpoint_m, double setpoint_r, boolean collect){
        if(encoder_f.getRate() > setpoint_f)
            setFrontMotor(0.0);
        else setFrontMotor(collect?-1.0:1.0);
        
        if(encoder_m.getRate() > setpoint_m)
            setMiddleMotor(0.0);
        else setMiddleMotor(collect?-1.0:1.0);
        
        if(encoder_r.getRate() > setpoint_r)
            setRearMotor(0.0);
        else setRearMotor(collect?-1.0:1.0);
    }
    
    public double getFrontMotor() {
        return motor_f.get();
    }
    
    public double getMiddleMotor() {
        return motor_m.get();
    }
    
    public double getRearMotor (){
        return motor_r.get();
    }
    
    public double FrontMotorRate() {
        return encoder_f.getRate();
    }
    
    public double MiddleMotorRate() {
        return encoder_m.getRate();
    }
    
    public double RearMotorRate() {
        return encoder_r.getRate();
    }
    
    public OpticalEncoder getFrontEncoder() {
        return encoder_f;
    }
        
    public OpticalEncoder getMiddleEncoder() {
        return encoder_m;
    }
    
    public OpticalEncoder getRearEncoder() {
        return encoder_r;
    }
    
    public void startEncoders() {
        encoder_f.start();
        encoder_m.start();
        encoder_r.start();
    }
    
    public void stopEncoders() {
        encoder_f.stop();
        encoder_m.stop();
        encoder_r.stop();
    }
    public void resetEncoders() {
        encoder_f.reset();
        encoder_m.reset();
        encoder_r.reset();
    }
    
    public boolean atSpeeds(double front, double middle, double rear, double tolerance) {
        if(Utilities.abs(encoder_f.getRate() - front) < tolerance && Utilities.abs(encoder_m.getRate()- middle) < tolerance && Utilities.abs(encoder_r.getRate() - rear) < tolerance)
        {
            return true;
        }
        return false;
    }
}
