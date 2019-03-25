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
/**
 * Moves elevator down
 */
public class ElevatorDown extends Command {
  public ElevatorDown() {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.setElevatorSpeed(-RobotMap.elevatorSpeed); 
   // System.out.println(RobotMap.elevatorMotor.getEncoder().getPosition());
  }

  @Override
  protected boolean isFinished() {
    /* Check if the Bottom Limit has been tripped
    *  if it has, stop, and reset encoder, else continue
    */
    if(RobotMap.elevatorBottomLimit.get()) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  protected void end() {
    Robot.elevator.setElevatorSpeed(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
