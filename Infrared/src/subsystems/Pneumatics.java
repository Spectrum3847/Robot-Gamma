/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.HW;

/**
 *
 * @author David
 */
public class Pneumatics extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Compressor compressor;
    
    public static Solenoid brakes;
    public static Solenoid hooks;
    
    public Pneumatics(){
        compressor = new Compressor(HW.PRESSURE_SENSOR,HW.COMPRESSOR);
        brakes = new Solenoid(HW.BRAKES);
        hooks = new Solenoid(HW.HOOKS);
    }
    
    public boolean isMaxPSI(){
        return compressor.getPressureSwitchValue();
    }
    
    public void runCompressor(){
        compressor.start();
    }
    
    public void stopCompressor(){
        compressor.stop();
    }
    
    public boolean isCompressor(){
        return compressor.enabled();
    }

    protected void initDefaultCommand() {
    }
    
    public void engageBrakes(){
        brakes.set(true);
        
        SmartDashboard.putBoolean("Brakes Engaged", true); //Brakes are engaged
    }
    
    public void releaseBrakes(){
        brakes.set(false);
        SmartDashboard.putBoolean("Brakes Engaged", false); //Brakes are released
    }
    
    public void engageHooks(){
        hooks.set(true);
        
        SmartDashboard.putBoolean("Hooks Engaged", true); //Hooks are extended
    }
    
    public void releaseHooks(){
        hooks.set(false);
        SmartDashboard.putBoolean("Hooks Engaged", false); //Hooks are retracted
    }
    
    /**
     * 
     * @return state of the brakes solenoid
     */
    public boolean isBrakes(){
        return brakes.get();
    }
    
}