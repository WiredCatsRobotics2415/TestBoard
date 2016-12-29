
package org.usfirst.frc.team2415.robot;

import org.usfirst.frc.team2415.robot.commands.FiveCommand;
import org.usfirst.frc.team2415.robot.commands.NegFiveCommand;
import org.usfirst.frc.team2415.robot.commands.ZeroCommand;
import org.usfirst.frc.team2415.robot.subsystems.BoardSubsystem;
import org.usfirst.frc.team2415.robot.subsystems.PistonSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static BoardSubsystem boardSubsystem;
	public static PistonSubsystem pistonSubsystem;
	
	public static WiredCatJoystick operator;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		boardSubsystem = new BoardSubsystem();
		pistonSubsystem = new PistonSubsystem();
		
		operator = new WiredCatJoystick(1);
		
		operator.buttons[3].whileHeld(new ZeroCommand());
		operator.buttons[2].whileHeld(new FiveCommand());
		operator.buttons[5].whileHeld(new NegFiveCommand());
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
      
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
  
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	Robot.boardSubsystem.updateStatus();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {

    }
}