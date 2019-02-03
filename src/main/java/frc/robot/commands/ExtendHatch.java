/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.*;

/**
 * Extends hatch mechanism
 */
public class ExtendHatch extends Command {
  public ExtendHatch() {
    requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.hatch.pistonOut();
  }

  @Override
  protected boolean isFinished() {
    if(Robot.hatch.getTimer().get() == RobotMap.hatchPistonOutTime){
      return true;
    } else{
      return false;
    }
  }

  @Override
  protected void end() {
    Robot.hatch.pistonIn();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
