package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.commands.MotorCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BoardSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CANTalon talon;
	
	public BoardSubsystem(){
		talon = new CANTalon(1);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new MotorCommand());
    }
    
    public double getPosition(){
    	return Math.abs((talon.getPosition()*360/4096) % 360);
    }
    
    public double getPulsePosition(){
    	return Math.abs((talon.getPulseWidthPosition()*360/4096) % 360);
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Absolute Encoder Value", getPulsePosition());
    	SmartDashboard.putNumber("Relative Encoder Value", getPosition());
    }
}

