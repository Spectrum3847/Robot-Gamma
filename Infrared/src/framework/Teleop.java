package framework;

import commands.CommandBase;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author matthew
 */
public class Teleop {
    public static Victor vic_5 = new Victor(HW.MIDDLE_LDRIVE_MOTOR);
        public static void init()
        {
            Init.cheesydrive.start();
            Init.shooter.start();
            Init.liftcontrol.start();
            Init.test.start();
            Init.manualshootertilt.start();
        }
        
        static int number = 0;
            
        public static void periodic()
        {
            Scheduler.getInstance().run();
            vic_5.set(CommandBase.drivebase.getVictor(3).get());
            //CommandBase.lcd.updateLCD();
            Dashboard.updateDashboard();
            
            if (OI.gamepad.getButton(1)){
                number = 1;
            } else if(OI.gamepad.getButton(2)){
                number = 2;
            }else if(OI.gamepad.getButton(3)){
                number = 3;
            }else if(OI.gamepad.getButton(4)){
                number = 4;
            }else if(OI.gamepad.getButton(5)){
                number = 5;
            }else if(OI.gamepad.getButton(6)){
                number = 6;
            }else if(OI.gamepad.getButton(7)){
                number = 7;
            }else if(OI.gamepad.getButton(8)){
                number = 8;
            }else if(OI.gamepad.getButton(9)){
                number = 9;
            }else if(OI.gamepad.getButton(10)){
                number = 10;
            }else if(OI.gamepad.getButton(11)){
                number = 11;
            }else if(OI.gamepad.getButton(12)){
                number = 12;
            }else if(OI.gamepad.getButton(13)){
                number = 13;
            }else if(OI.gamepad.getButton(14)){
                number = 14;
            }
            
            SmartDashboard.putNumber("Joystick Button", number);

        }
}