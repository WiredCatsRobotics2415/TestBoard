package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NegFiveCommand extends Command {

    public NegFiveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.boardSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.boardSubsystem.talon.changeControlMode(TalonControlMode.Position);
    	Robot.boardSubsystem.talon.reverseOutput(true);
    	Robot.boardSubsystem.talon.setP(0.5);
    	Robot.boardSubsystem.talon.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.boardSubsystem.talon.set(-5*4096);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
