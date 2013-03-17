package driver;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import framework.Utilities;

/**
 *
 * @author David
 * 
 * This class implements the Optical Encoder,
 * which is defined as a Counter. It counts the number of
 * ticks, or color change in the case of our wheel, which
 * is used to get rate.
 */
public class OpticalEncoder extends Counter {
    private double rate = 0;
    private double threshold = 200;
    
    public OpticalEncoder(int channel){
        super(channel);
    }
    
    public int getTicks(){
        return get();
    }
    
    public double getRate(){
        //rate = Utilities.abs(getPeriod()-rate)<threshold?(1.0/getPeriod()*60.0):rate;
        return 1.0/getPeriod()*60.0;
    }
}