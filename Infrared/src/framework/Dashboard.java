package framework;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Dashboard {

    static final boolean ENABLE_SPECTRUM_DASHBOARD = true;
    static final boolean TURN_PID_TUNING = false;
    static final boolean COLLECTOR_TESTING = false;
    static final double SHORT_DELAY = .2;
    static double shortOldTime = 0.0;
    static final double LONG_DELAY = 2;
    static double longOldTime = 0.0;

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
            //Put things here that are updated by other commands or only need to be intialized
            SmartDashboard.putBoolean("HaloDriveCommand", Init.gamepaddrive.isRunning());
            SmartDashboard.putBoolean("LiftControlCommand", Init.liftcontrol.isRunning());
            SmartDashboard.putBoolean("TiltCommand", Init.manualshootertilt.isRunning());
            SmartDashboard.putBoolean("ShootCollectCommand", Init.manualshootcollect.isRunning());
            SmartDashboard.putBoolean("LockTiltCommand", Init.locktilt.isRunning());
            SmartDashboard.putNumber("LockTilt", .3);
            
            //Intialize Single calls here, useful for PID data
            
            SmartDashboard.putNumber("CheesySensetivity", 1.5);
            SmartDashboard.putNumber("FrontMotorInput", 0);
            SmartDashboard.putNumber("RearMotorInput", 0);
            /*if (TURN_PID_TUNING) {
                SmartDashboard.putData(CommandBase.drivebase);
            }*/
            
            //Auto Dashboard Variables
            SmartDashboard.putNumber("Auton Tilt Speed", 1);
            SmartDashboard.putNumber("Auton Tilt Lock Speed", 0.4);
            SmartDashboard.putNumber("Auton Tilt Lower Speed", 0.2);
            SmartDashboard.putNumber("Lift Auton Speed", 1.0);
            SmartDashboard.putNumber("DriveBase Auton Speed", 0.4);
            SmartDashboard.putNumber("Auton Shooter Front Speed", 0.7);
            SmartDashboard.putNumber("Auton Shooter Rear Speed", 1);
            
            SmartDashboard.putNumber("Auton Collect Drive Time", 1.0);
            SmartDashboard.putNumber("Auton Lift Time", 7);
            SmartDashboard.putNumber("Auton Tilt Time", 0.5);
            SmartDashboard.putNumber("Auton Fire Time", 0.6);
        }
    }

    public static void updateDashboard() {

        if (ENABLE_SPECTRUM_DASHBOARD) {

            if ((Timer.getFPGATimestamp() - shortOldTime) > SHORT_DELAY) {
                //All Dashboard commands that should be updated after the quick SHORT_DELAY

                SmartDashboard.putNumber("Drive Left", CommandBase.drivebase.getLeft());
                SmartDashboard.putNumber("Drive Right", CommandBase.drivebase.getRight());
                SmartDashboard.putNumber("Left Y", OI.gamepad.getLeftY());
                SmartDashboard.putNumber("Right X", OI.gamepad.getRightX());
                shortOldTime = Timer.getFPGATimestamp();
            }

            if ((Timer.getFPGATimestamp() - longOldTime) > LONG_DELAY) {
                //Thing that should be updated every LONG_DELAY
                //SmartDashboard.putData(Scheduler.getInstance());
                
                
                
                longOldTime = Timer.getFPGATimestamp();
                
            }
        }
    }
}
