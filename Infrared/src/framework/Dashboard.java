package framework;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Dashboard {

    static final boolean ENABLE_SPECTRUM_DASHBOARD = true;
    static final double SHORT_DELAY = .2;
    static double shortOldTime = 0.0;
    static final double LONG_DELAY = 2;
    static double longOldTime = 0.0;
    
    public static String FRONT_SHOOTER_RPM_KEY = "INSERT FRONT SHOOTER MOTOR RPM HERE";
    public static String MIDDLE_SHOOTER_RPM_KEY = "INSERT MIDDLE SHOOTER MOTOR RPM HERE";
    public static String REAR_SHOOTER_RPM_KEY = "INSERT REAR SHOOTER MOTOR RPM HERE";
    
    public static String FRONT_COLLECT_RPM_KEY = "FRONT COLLECT RPM";
    public static String MIDDLE_COLLECT_RPM_KEY = "MIDDLE COLLECT RPM";
    public static String REAR_COLLECT_RPM_KEY = "REAR COLLECT RPM";
    
    public static String FRONT_SHOOTER_OFFSET = "CURRENT FRONT RPM OFFSET";
    
    public static String FRONT_MOTOR_ANALOG_SCALE_KEY = "FRONT MOTOR ANALOG SCALE VALUE";
    public static String MIDDLE_MOTOR_ANALOG_SCALE_KEY = "MIDDLE MOTOR ANALOG SCALE VALUE";
    public static String REAR_MOTOR_ANALOG_SCALE_KEY = "REAR MOTOR ANALOG SCALE VALUE";
    
    public static String CHEESY_SENSITIVITY_KEY = "CHEESY SENSITIVITY";
    
    public static String AUTON_SWITCH_KEY = "Auton On";
    public static String AUTON_TYPE_KEY = "Auton 5 Disk";
    
    public static String FRONT_MOTOR_ANALOG_COLLECT_SCALE_KEY = "FRONT MOTOR ANALOG COLLECT SCALE VALUE";
    public static String MIDDLE_MOTOR_ANALOG_COLLECT_SCALE_KEY = "MIDDLE MOTOR ANALOG COLLECT SCALE VALUE";
    public static String REAR_MOTOR_ANALOG_COLLECT_SCALE_KEY = "REAR MOTOR ANALOG SCALE COLLECT VALUE";
    
    public static String FRONT_MOTOR_TIMEDROP = "FRONT MOTOR TIMEDROP";
    public static String MIDDLE_MOTOR_TIMEDROP = "MIDDLE MOTOR TIMEDROP";
    public static String REAR_MOTOR_TIMEDROP = "REAR MOTOR TIMEDROP";
    
    public static String FRONT_MOTOR_BANGLOW = "FRONT MOTOR BANG-LOW";
    public static String MIDDLE_MOTOR_BANGLOW = "MIDDLE MOTOR BANG-LOW";
    public static String REAR_MOTOR_BANGLOW = "REAR MOTOR BANG-LOW";
    
    public static String AUTO_FLICK_TIME = "Auto Flick Time";

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
            //SmartDashboard.putData("MANUAL SHOOT", Init.dashboardShootCollect);
            //SmartDashboard.putData("PIDShoot", Init.PIDShootCommand);
            SmartDashboard.putNumber(FRONT_SHOOTER_RPM_KEY, 9000);
            SmartDashboard.putNumber(MIDDLE_SHOOTER_RPM_KEY, 5500);
            SmartDashboard.putNumber(REAR_SHOOTER_RPM_KEY, 3900);
            
            SmartDashboard.putNumber(FRONT_COLLECT_RPM_KEY, 0);
            SmartDashboard.putNumber(MIDDLE_COLLECT_RPM_KEY, 6000);
            SmartDashboard.putNumber(REAR_COLLECT_RPM_KEY, 4300);
            
            SmartDashboard.putNumber(FRONT_SHOOTER_OFFSET, 0);
            
            SmartDashboard.putNumber(Dashboard.FRONT_MOTOR_ANALOG_SCALE_KEY, 1);
            SmartDashboard.putNumber(Dashboard.MIDDLE_MOTOR_ANALOG_SCALE_KEY, 1);
            SmartDashboard.putNumber(Dashboard.REAR_MOTOR_ANALOG_SCALE_KEY, 1);
            
            SmartDashboard.putNumber(Dashboard.FRONT_MOTOR_ANALOG_COLLECT_SCALE_KEY, 0);
            SmartDashboard.putNumber(Dashboard.MIDDLE_MOTOR_ANALOG_COLLECT_SCALE_KEY, 0.6);
            SmartDashboard.putNumber(Dashboard.REAR_MOTOR_ANALOG_COLLECT_SCALE_KEY, 0.65);
            
            SmartDashboard.putNumber(Dashboard.CHEESY_SENSITIVITY_KEY, 1.32);
            
            SmartDashboard.putBoolean(AUTON_SWITCH_KEY, true);
            SmartDashboard.putBoolean(AUTON_TYPE_KEY, false);
            
            SmartDashboard.putNumber(REAR_MOTOR_TIMEDROP, 0);
            SmartDashboard.putNumber(MIDDLE_MOTOR_TIMEDROP, .012);
            SmartDashboard.putNumber(FRONT_MOTOR_TIMEDROP, .017);
            
            SmartDashboard.putNumber(REAR_MOTOR_BANGLOW, .8);
            SmartDashboard.putNumber(MIDDLE_MOTOR_BANGLOW, .4);
            SmartDashboard.putNumber(FRONT_MOTOR_BANGLOW, .6);
            
            SmartDashboard.putNumber(AUTO_FLICK_TIME, .2);
        }
    }

    public static void updateDashboard() {

        if (ENABLE_SPECTRUM_DASHBOARD) {

            if ((Timer.getFPGATimestamp() - shortOldTime) > SHORT_DELAY) {
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
