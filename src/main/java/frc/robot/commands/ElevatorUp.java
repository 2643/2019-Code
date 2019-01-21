/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class ElevatorUp extends Command {
  public ElevatorUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.elevator.setElevatorSpeed(RobotMap.elevatorSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    
    /* Check if the encoder is still below the softlimit
    *  If it is, continue, otherwise stop
    */
    if (Robot.elevator.getElevatorEncoder() < RobotMap.elevatorEncoderMaxLimit) {
      return false;
    }
    else {
      return true;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevator.setElevatorSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
