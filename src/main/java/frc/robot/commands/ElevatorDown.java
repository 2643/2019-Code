/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorDown extends Command {
  public ElevatorDown() {
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

    //If the robot hits the bottom limit, then it'll stop and reset the encoder, otherwise accelerate in negative speed
    if(RobotMap.elevatorBottomLimit.get()) {
      Robot.elevator.setElevatorSpeed(0);
      Robot.elevator.elevatorEncoderReset();
    }
    else {
      Robot.elevator.setElevatorSpeed(-RobotMap.elevatorSpeed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /* Check if the Bottom Limit has been tripped
    *  if it has, stop, and reset encoder, else continue
    */
    if(RobotMap.elevatorBottomLimit.get()) {
      Robot.elevator.setElevatorSpeed(0);
      Robot.elevator.elevatorEncoderReset();
      return true;
    }
    else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Just in case
    Robot.elevator.setElevatorSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    
  }
}
