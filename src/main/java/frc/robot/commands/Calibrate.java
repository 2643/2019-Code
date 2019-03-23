/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Calibrate extends Command {
  private int calibrateCycle = 0;  
  private double rotations = 0; 
  private boolean finished = false; 

  public Calibrate() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.setElevatorPosition(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    calibrateCycle++;
    if(calibrateCycle % 10 == 0 && RobotMap.elevatorBottomLimit.get()){
        rotations = (RobotMap.elevatorMotor.getEncoder().getPosition() + 5);
        RobotMap.elevatorMotor.getPIDController().setReference(rotations, ControlType.kPosition);
    }
    else if(calibrateCycle % 25 == 0 && !RobotMap.elevatorBottomLimit.get()){
        rotations = 0;
        RobotMap.elevatorMotor.getEncoder().setPosition(0);
        finished = true; 
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
