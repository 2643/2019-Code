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
  int rotations;
  boolean finished = false; 

  /**
   * Sets the elevator to a given height
   * @param elevatorLevelInTicks height above the ground in inches that the elevator needs to go to
   */
  public ElevatorTo(int elevatorLevelInTicks) {
    requires (Robot.elevator);
    rotations = (elevatorLevelInTicks);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.setElevatorPosition(rotations);
  }

  @Override
  protected boolean isFinished() {
    //Checks to see whether the height above the ground is equal to the encoder ticks for the elevator encoder
    if(Math.abs(Robot.elevator.getElevatorEncoder() - rotations) < RobotMap.elevatorTolerance){
      finished = true;
    }
    else{
      finished = false;
    }
    return finished;
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
