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
 * Sets the elevator to a given height
 */
public class ElevatorTo extends Command {
  int levelToGoTo;

  /**
   * Sets the elevator to a given height
   * @param elevatorLevelInInches height above the ground in inches that the elevator needs to go to
   */
  public ElevatorTo(int elevatorLevelInInches) {
    requires (Robot.elevator);
    levelToGoTo = (elevatorLevelInInches);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.setElevatorPosition(levelToGoTo);
  }

  @Override
  protected boolean isFinished() {
    if(RobotMap.encoderTicksToInches(Robot.elevator.getElevatorEncoder()) == levelToGoTo){
      return true;
    }
    else{
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
