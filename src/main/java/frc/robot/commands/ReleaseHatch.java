/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import frc.robot.*;
/**
 * Releases the hatch panel
 */
public class ReleaseHatch extends TimedCommand {
  public ReleaseHatch() {
    super(RobotMap.hatchReleaseTimeout);
    requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
    Robot.hatch.getTimer().reset();
    Robot.hatch.getTimer().start();
  }

  @Override
  protected void execute() {  
    Robot.hatch.hatchPistonOut();
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
    Robot.hatch.hatchPistonIn();
    Robot.hatch.getTimer().stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
