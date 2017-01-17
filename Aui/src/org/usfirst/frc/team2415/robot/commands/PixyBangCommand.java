package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PixyBangCommand extends Command {

	boolean finisher;
	long startTime;
	double finisherTime;
	
    public PixyBangCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.boardSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Pixy: " + Robot.boardSubsystem.pixy.get() + "\t Finisher Time: " + finisherTime);
    	Robot.boardSubsystem.setMotor(Robot.boardSubsystem.pixy.pixyPOut(0.5, 0.1));
    	finisher = (Robot.boardSubsystem.pixy.pixyPOut(0.5, 0.1) == 0);
    	if (finisher == false) {
    		finisherTime = 0;
    		startTime = System.currentTimeMillis();	
    	}
    	finisherTime = (System.currentTimeMillis() - startTime)/1000.0;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	return false;
        return finisherTime >= 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boardSubsystem.setMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
}
