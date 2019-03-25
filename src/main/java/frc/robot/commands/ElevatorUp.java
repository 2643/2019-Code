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
/**
 * Moves Elevator Up
 */
public class ElevatorUp extends Command {
  public ElevatorUp() {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize() {
    
  }

  @Override
  protected void execute() {
   Robot.elevator.setElevatorSpeed(RobotMap.elevatorSpeed);
   //Robot.elevator.setElevatorPosition(RobotMap.rotations);
    //System.out.println(RobotMap.elevatorMotor.getEncoder().getPosition());
  }

  @Override
  protected boolean isFinished() {
    /* Check if the encoder is still below the softlimit
    *  If it is, continue, otherwise stop
    */
    // if (Robot.elevator.getElevatorEncoder() < RobotMap.elevatorEncoderMaxLimit) {
    //   return false;
    // }
    // else {
    //   return true;
    // }
    return false;
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
