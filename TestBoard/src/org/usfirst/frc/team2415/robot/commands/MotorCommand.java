package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MotorCommand extends Command {

	double vel;
	
    public MotorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.boardSubsystem);
    }
    
    public MotorCommand(double vel){
    	requires(Robot.boardSubsystem);
    	this.vel = vel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.boardSubsystem.setMotor(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.boardSubsystem.setMotor(vel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.boardSubsystem.setMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.boardSubsystem.setMotor(0);
    }
}
