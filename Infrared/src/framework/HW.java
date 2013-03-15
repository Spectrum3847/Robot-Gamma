package framework;

/**
 * The HW is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    /**DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int FRONT_RDRIVE_MOTOR = 10;
    public static final int REAR_RDRIVE_MOTOR = 9;
    public static final int FRONT_LDRIVE_MOTOR = 1;
    public static final int REAR_LDRIVE_MOTOR = 2;
    
    /** Kludge **/
    public static final int MIDDLE_LDRIVE_MOTOR = 5;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int FRONT_SHOOTER_MOTOR = 8;
    public static final int REAR_SHOOTER_MOTOR = 7;
    public static final int TILT_SHOOTER_MOTOR = 3;
    public static final int FLICK_SHOOTER_MOTOR = 6;
    
    public static final int LIFT_MOTOR = 4;
    
    /**PID CONSTANTS**/
    
    /**DRIVEBASE PID**/
    public static final double EBRAKE_KP = 10;
    public static final double EBRAKE_KI = 0.0;
    public static final double DRIVEBASE_KD = 3;
    public static final double DRIVEBASE_PULSE = (1.0 / 4096.0);
    public static final double EBRAKE_SETPOINT = 0.0;
    public static final double EBRAKE_INCREMENT = 2;
    //36:12 GEAR RATIO, measured in REV PER SEC.
    
    /**
    * Turn Controller PID - Straight
    */
    public static final double SKEW_KP = 0.0169;
    public static final double SKEW_KI = 0.0;
    public static final double SKEW_KD = 0.0;
    
    /**
     * Turn Controller PID - QuickTurn Left
     */
    public static final double TURN_LEFT_KP = 0.1;
    public static final double TURN_LEFT_KI = 0.0;
    public static final double TURN_LEFT_KD = 0.2;
    
     /**
     * Turn Controller PID - QuickTurn Right
     */
    public static final double TURN_RIGHT_KP = 0.1;
    public static final double TURN_RIGHT_KI = 0.0;
    public static final double TURN_RIGHT_KD = 0.28;
    
    /**DIGITAL SENSOR ALLOCATIONS**/
    public static final int RDRIVE_ENCODER_A = 1;
    public static final int RDRIVE_ENCODER_B = 2;
    public static final int LDRIVE_ENCODER_A = 3;
    public static final int LDRIVE_ENCODER_B = 4;
    
    /**DIGITAL SENSOR ALLOCATIONS - SHOOTER SYSTEM **/
    public static final int SHOOTER_FRONT_ENCODER = 5;
    public static final int SHOOTER_REAR_ENCODER = 6;
    
    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int usbPort_one = 1;
    public static final int usbPort_two = 2;
    public static final int usbPort_three = 3;
    public static final int usbPort_four = 4;
    
    
    /**SPEED/VELOCITY/DISTANCE DEFINITIONS**/
    public static final double MAX_SPEED = 1.0;
    public static final double MIN_SPEED = -1.0;

    
    /**SPI ALLOCATION**/
    public static final int spiSCK  = 6;
    public static final int spiMOSI = 7;
    public static final int spiMISO = 8;
    public static final int spiCS = 9;
    
    /**DIGITAL MODULE SLOTS**/
    public static final int DM_ONE = 1;
    
    /**INNER-CODE MISCELANEOUS**/
    public static final int NUM_COMMANDS = 5;
    public static final int SAMPLING_SIZE = 40;
    public static final double POT_CALIBRATION = 238.75347126436785+81.374;
    public static final double IRSENSOR_DELAY = 0.05;
    public static final double IRSENSOR_DETECT_THRESHOLD = 19;
    public static final int POTENTIOMETER_ERROR_RANGE = 5;
    public static final double POT_MIN_OUTPUT = -0.4;
    public static final double POT_MAX_OUTPUT = 0.6;
    public static final double AS5415_MAX_VOLTAGE = 3.3;
    public static final int GYRO_CHANNEL = 1;
}
