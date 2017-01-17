package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.commands.MotorCommand;
import org.usfirst.frc.team2415.robot.utilities.PixyCam;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BoardSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public CANTalon talon;
	public PixyCam pixy;
//	private Ultrasonic ultrasonic;
	
	public BoardSubsystem() {
		talon = new CANTalon(2);
		pixy = new PixyCam(0,0);
//		ultrasonic = new Ultrasonic(0,0);
//		
		talon.enable();
		talon.configMaxOutputVoltage(0.5);

		pixy.setGoal(2);
		
//		
//		ultrasonic.setAutomaticMode(true);
	}
	
	public void setMotor(double vel){
    	talon.set(vel);
    }
    
//    public boolean validRange() {
//    	return ultrasonic.isRangeValid();
//    }
//    
//    public double ultrasonicRange() {
//    	return ultrasonic.getRangeMM();
//    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MotorCommand());
    }
    
    public void updateStatus() {
    	SmartDashboard.putNumber("Y-value", Robot.operator.getY());
    	SmartDashboard.putNumber("Number of rotations", (talon.getPosition()/4096));
    }
    
}


