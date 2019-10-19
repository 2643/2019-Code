/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Sets the elevator to a given height
 */
public class ElevatorTo extends Command {
  int rotations;
  boolean finished = false; 

  /**
   * Sets the elevator to a given height
   * @param elevatorLevelInTicks height above the ground in inches that the elevator needs to go to
   */
  public ElevatorTo() {
    requires (Robot.elevator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.setElevatorPosition(-58);
  }

  @Override
  protected boolean isFinished() {
    //Checks to see if the bottom limit switch or the top limit switch is hit
    //TODO check this end condition for the elevator please before using it
    if(Robot.elevator.getElevatorUpperLimitSwitch() || (Robot.elevator.getElevatorEncoder() <= -58)){
      return true;
    }else{
      return false;
    }
  }

  @Override
  protected void end() {
    //TODO test this end for the elevator please before implementing this
    Robot.elevator.setElevatorPosition(Robot.elevator.getElevatorEncoder());
  }

  @Override
  protected void interrupted() {
    Robot.elevator.setElevatorPosition(Robot.elevator.getElevatorEncoder());

  }
}
