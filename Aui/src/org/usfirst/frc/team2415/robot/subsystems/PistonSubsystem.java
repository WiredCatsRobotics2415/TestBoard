package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.commands.PistonCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PistonSubsystem extends Subsystem {
    
	private DigitalInput button;
	private Solenoid solenoid1;
	private Solenoid solenoid2;

	public PistonSubsystem(){
		solenoid1 = new Solenoid(20, 0);
		solenoid2 = new Solenoid(20, 1);
		button = new DigitalInput(1);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PistonCommand());
    }
    
    public void fire(boolean toggle) {
    	solenoid1.set(toggle);
    	solenoid2.set(!toggle);
    }
    
    public boolean pressed(){
    	return button.get();
    }
}

