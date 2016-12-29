package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.commands.MotorCommand;
import org.usfirst.frc.team2415.robot.commands.UltrasonicCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BoardSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CANTalon talon;
//	private Ultrasonic ultrasonic;
	
	public BoardSubsystem(){
		talon = new CANTalon(1);
//		ultrasonic = new Ultrasonic(0,0);
		
		talon.changeControlMode(TalonControlMode.Position);
		talon.set(0);
		talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		talon.setPID(0.1, 0, 0);
		talon.enable();
		talon.clearStickyFaults();
		
//		ultrasonic.setAutomaticMode(true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UltrasonicCommand());
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
    
    public void setMotor(double value){
    	talon.set(value);
    }
    
//    public boolean validRange() {
//    	return ultrasonic.isRangeValid();
//    }
//    
//    public double ultrasonicRange() {
//    	return ultrasonic.getRangeMM();
//    }
    
}

