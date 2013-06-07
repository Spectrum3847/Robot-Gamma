/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.shoot;

import commands.CommandBase;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author JAG
 */
public class PIDShooterFront extends PIDCommand {

    private double inputLow = 0;
    private double inputHigh = 10000;
    private double tolerance = 0;
    
    private double platypus;
    private double iguana;
    private double dipstick;
    private double frito;
    
    private double oldOutput = 0;
    
    public PIDShooterFront(double p, double i, double d, double f) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super(p,i,d,f);
        requires(CommandBase.shooter);
        getPIDController().setInputRange(inputLow, inputHigh);
        getPIDController().setOutputRange(-1000,1000);
        getPIDController().setAbsoluteTolerance(tolerance);
        platypus = p;
        iguana = i;
        dipstick = d;
        frito = f;
    } 
    
    public PIDShooterFront(double p, double i, double d) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this(p,i,d, .5);
    }
    


    public void setTolerance(double t){
        tolerance = t;
        getPIDController().setAbsoluteTolerance(tolerance);
    }
    
    public void setPID(double p, double i, double d, double f){
        platypus = p;
        iguana = i;
        dipstick = d;
        frito = f;
        getPIDController().setPID(platypus, iguana, dipstick, frito);
    }
    
    public void setP(double p){
        platypus = p;
        getPIDController().setPID(platypus, iguana, dipstick, frito);
    }
    
    public void setI(double i){
        iguana = i;
        getPIDController().setPID(platypus, iguana, dipstick, frito);
    }
    
    public void setD(double d){
        dipstick = d;
        getPIDController().setPID(platypus, iguana, dipstick, frito);
    }
    
    public void setF(double f){
        frito = f;
        getPIDController().setPID(platypus, iguana, dipstick, frito);
    }
    
    public double getP(){ 
        return getPIDController().getP();
    }
    
    public double getI(){
        return getPIDController().getI();
    }
    
    public double getD(){
        return getPIDController().getD();
    }
    
    public double getF(){
        return getPIDController().getF();
    }
    
    public double getTolerance(){
        return tolerance;
    }
    
    protected void usePIDOutput(double x){
        oldOutput += x/1000;
        CommandBase.shooter.setFrontMotor(oldOutput);
        System.out.println("Using the Front Output");
    }
    
    protected double returnPIDInput(){
        return CommandBase.shooter.FrontMotorRate();
    }
    
    public PIDController getPIDController(){
        return super.getPIDController();
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        CommandBase.shooter.startFrontEncoder();
        getPIDController().enable();
        getPIDController().setPID(.1, 0, 0, 0);
        getPIDController().setSetpoint(4000);
        System.out.println("PID SHOOT FRONT STARTED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("Front RPM", CommandBase.shooter.getFrontEncoder().getRate());
        SmartDashboard.putNumber("Front P", getP());
        SmartDashboard.putNumber("Front I", getI());
        SmartDashboard.putNumber("Front D", getD());
        SmartDashboard.putNumber("Front Setpoint", this.getSetpoint());
        SmartDashboard.putNumber("Front Error", this.getPIDController().getError());
        SmartDashboard.putNumber("Front Motor Output", CommandBase.shooter.getFrontMotor());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        CommandBase.shooter.setFrontMotor(0);
        CommandBase.shooter.resetFrontEncoder();
        CommandBase.shooter.stopFrontEncoder();
        System.out.println("PID SHOOT FRONT ENDED");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
