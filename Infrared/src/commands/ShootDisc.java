package commands;

/**
 *
 * @author matthew
 */
public class ShootDisc extends CommandBase {
    
    private static int timeout = 2;
    public ShootDisc() {
        super("ShootDisc", timeout);
        requires(shooterPaddle);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        //shoot.setShooter((OI.driveStick_right.getAxis(Joystick.AxisType.kZ)+1)/2);
        shooterPaddle.FWD();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        shooterPaddle.off();
    }

    protected void interrupted() {
        end();
    }
}
