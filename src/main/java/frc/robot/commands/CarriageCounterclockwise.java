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
 * Turns chains on carriage counterclockwise
 */
public class CarriageCounterclockwise extends Command {
  public CarriageCounterclockwise() {
    requires(Robot.carriage);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //TODO check direction of potentiometer.
    //TODO Specifically in which way it increases/decreases.
    Robot.carriage.setCarriageSpeed(-RobotMap.carriageMotorSpeed);
  }

  @Override
  protected boolean isFinished() {
    /* Check for potentiometer position,
    *  If at under greater than min, continue
    *  Else, stop immediately.
    */
    if (RobotMap.carriagePot.get() > RobotMap.carriageCounterclockwiseMin) {
      return false;
    }
    else {
      return true;
    }
  }

  @Override
  protected void end() {
    Robot.carriage.setCarriageSpeed(0);
  }

  @Override
  protected void interrupted() {
    //Just in case
    end();
  }
}
