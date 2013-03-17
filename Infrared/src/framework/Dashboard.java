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
    
    public static String TILT_SPEED_KEY = "Auton Tilt Speed";
    public static String TILT_LOCK_SPEED_KEY = "Auton Tilt Lock Speed";
    public static String DRIVEBASE_SPEED_KEY = "DriveBase Auton Speed";
    public static String FRONT_SHOOTER_SPEED_KEY = "Auton Front Shooter Speed";
    public static String REAR_SHOOTER_SPEED_KEY = "Auton Rear Shooter Speed";
    
    public static String COLLECT_DRIVE_TIME_KEY = "Auton Collect Drive Time";
    public static String TILT_TIME_KEY = "Auton Tilt Time";
    public static String FIRE_TIME_KEY = "Auton Fire Time";
    
    public static String AUTON_ENABLED_KEY = "Auton Enabled";
    
    public static String FRONT_SHOOTER_RPM_KEY = "INSERT FRONT SHOOTER MOTOR RPM HERE";
    public static String MIDDLE_SHOOTER_RPM_KEY = "INSERT MIDDLE SHOOTER MOTOR RPM HERE";
    public static String REAR_SHOOTER_RPM_KEY = "INSERT REAR SHOOTER MOTOR RPM HERE";
    
    public static String FRONT_COLLECTER_RPM_KEY = "INSERT FRONT COLLECTER MOTOR RPM HERE";
    public static String MIDDLE_COLLECTER_RPM_KEY = "INSERT MIDDLE SHOOTER MOTOR RPM HERE";
    public static String REAR_COLLECTER_RPM_KEY = "INSERT REAR COLLECTER MOTOR RPM HERE";
    
    public static String FRONT_MOTOR_ANALOG_SCALE_KEY = "FRONT MOTOR ANALOG SCALE VALUE";
    public static String MIDDLE_MOTOR_ANALOG_SCALE_KEY = "MIDDLE MOTOR ANALOG SCALE VALUE";
    public static String REAR_MOTOR_ANALOG_SCALE_KEY = "REAR MOTOR ANALOG SCALE VALUE";
    
    public static String CHEESY_SENSITIVITY = "CheesySensetivity";

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
            //Put things here that are updated by other commands or only need to be intialized
            SmartDashboard.putBoolean("CheesyDriveCommand", Init.gamepaddrive.isRunning());
            SmartDashboard.putBoolean("HaloDriveCommand", Init.gamepaddrive.isRunning());
            SmartDashboard.putBoolean("LiftControlCommand", Init.liftcontrol.isRunning());
            //SmartDashboard.putBoolean("ShootCollectCommand", Init.manualshootcollect.isRunning());
            
            //Intialize Single calls here, useful for PID data
            
            SmartDashboard.putNumber(CHEESY_SENSITIVITY, 1.5);
            SmartDashboard.putNumber("FrontMotorInput", 0);
            SmartDashboard.putNumber("RearMotorInput", 0);
            
            SmartDashboard.putBoolean(AUTON_ENABLED_KEY, true);
            
            SmartDashboard.putNumber(TILT_SPEED_KEY, 1.0);
            SmartDashboard.putNumber(TILT_LOCK_SPEED_KEY, 0.3);
            SmartDashboard.putNumber(DRIVEBASE_SPEED_KEY, 0.5);
            SmartDashboard.putNumber(FRONT_SHOOTER_SPEED_KEY, 1.0);
            SmartDashboard.putNumber(REAR_SHOOTER_SPEED_KEY, 0.7);

            SmartDashboard.putNumber(COLLECT_DRIVE_TIME_KEY, 2.5);
            SmartDashboard.putNumber(COLLECT_DRIVE_TIME_KEY + " 7 Disc", 2.5);
            SmartDashboard.putNumber(TILT_TIME_KEY, 0.4);
            SmartDashboard.putNumber(FIRE_TIME_KEY, 0.5);
            
            SmartDashboard.putNumber(FRONT_SHOOTER_RPM_KEY, 0);
            SmartDashboard.putNumber(MIDDLE_SHOOTER_RPM_KEY, 0);
            SmartDashboard.putNumber(REAR_SHOOTER_RPM_KEY, 0);
                    
            SmartDashboard.putNumber(FRONT_COLLECTER_RPM_KEY, 0);
            SmartDashboard.putNumber(MIDDLE_COLLECTER_RPM_KEY, 0);
            SmartDashboard.putNumber(REAR_COLLECTER_RPM_KEY, 0);
            
            SmartDashboard.putNumber(Dashboard.FRONT_MOTOR_ANALOG_SCALE_KEY, 1);
            SmartDashboard.putNumber(Dashboard.MIDDLE_MOTOR_ANALOG_SCALE_KEY, 1);
            SmartDashboard.putNumber(Dashboard.REAR_MOTOR_ANALOG_SCALE_KEY, 1);
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
