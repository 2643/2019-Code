/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Extends hatch mechanism
 */
public class ExtendHatch extends TimedCommand {
  public ExtendHatch() {
    super(RobotMap.hatchExtendTimeout);
    requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.hatch.mechanismPistonOut();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {
    end();
  }
}
