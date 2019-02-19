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
  int levelToGoTo;

  /**
   * Sets the elevator to a given height
   * @param elevatorLevelInTicks height above the ground in inches that the elevator needs to go to
   */
  public ElevatorTo(int elevatorLevelInTicks) {
    requires (Robot.elevator);
    levelToGoTo = (elevatorLevelInTicks);
  }

  @Override
  protected void initialize() {
    Robot.elevator.resetElevatorEncoder();
  }

  @Override
  protected void execute() {
    Robot.elevator.setElevatorPosition(levelToGoTo);
  }

  @Override
  protected boolean isFinished() {
    //Checks to see whether the height above the ground is equal to the encoder ticks for the elevator encoder
    if(Robot.elevator.getElevatorEncoder() == levelToGoTo){
      //TODO Sanjana: Fix this.
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  protected void end() {
    Robot.elevator.setElevatorSpeed(0);
    Robot.elevator.resetElevatorEncoder();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
