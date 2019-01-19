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
    // Make sure encoder is at a 0 position
    Robot.elevator.elevatorEncoderReset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    // Checks if the elevator is under the encoder limit, if it is, continue. Else, stop.
    if (Robot.elevator.getEncoder() <= RobotMap.elevatorEncoderMaxLimit) {
      Robot.elevator.setPositiveSpeed(RobotMap.elevatorSpeed);
    }
    else {
      Robot.elevator.setZeroSpeed();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    // Just in case
    Robot.elevator.setZeroSpeed();
  }
}
