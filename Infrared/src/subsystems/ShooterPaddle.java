package subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

public class ShooterPaddle extends Subsystem {

    private Victor Paddle;
   
    // Initialize your subsystem here
    public ShooterPaddle() {
        super("ShooterPaddle");
        Paddle = new Victor(HW.PADDLE_MOTOR);
    }
    
    
    public void initDefaultCommand() {
    }
    
    public void setPaddleSpeed(double speed){
        Paddle.set(speed);
    }
    
    public void FWD(){
        setPaddleSpeed(1);
    }
    
    public void REV(){
        setPaddleSpeed(-1);
    }
    
    public void off(){
        setPaddleSpeed(0);
    }
}
