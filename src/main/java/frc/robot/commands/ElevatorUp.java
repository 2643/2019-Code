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
    if(Robot.elevator.getElevatorUpperLimitSwitch() || (Robot.elevator.getElevatorEncoder() <= -55)){
      Robot.elevator.setElevatorPosition(-55);
    }
    else{
    Robot.elevator.setElevatorSpeed(RobotMap.elevatorSpeed);
    }
  }

  @Override
  protected boolean isFinished() {
    /* Check if the encoder is still below the softlimit
    *  If it is, continue, otherwise stop
    */
    if (Robot.elevator.getElevatorUpperLimitSwitch()) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  protected void end() {
    Robot.elevator.setElevatorSpeed(0);
    Robot.elevator.setElevatorPosition(Robot.elevator.getElevatorEncoder());
    // if (Robot.elevator.getElevatorUpperLimitSwitch()) {
    //   Robot.elevator.stopElevatorPID();
    // }
    // else {
     
    // }
    
  }

  @Override
  protected void interrupted() {
    if(!Robot.oi.getDriverStick().getRawButton(RobotMap.elevatorUpButtonNumber)){
      end();
    }
  }
}
