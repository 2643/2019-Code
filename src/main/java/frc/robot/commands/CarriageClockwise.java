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
 * Turns the chain on the carriage clockwise //TODO Check whether this makes it turn left or right
 */
public class CarriageClockwise extends Command {
  public CarriageClockwise() {
    requires(Robot.carriage);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.carriage.setCarriageSpeed(RobotMap.carriageMotorSpeed);
  }

  @Override
  protected boolean isFinished() {
    /* Check for potentiometer position,
    *  If at under maximum, continue
    *  Else, stop immediately.
    */
    if (RobotMap.carriagePot.get() < RobotMap.carriageClockwiseMax) {
      return false;
    }
    else {
      return true;
    }
  }

  @Override
  protected void end() {
    //Just in case
    Robot.carriage.setCarriageSpeed(0);
  }
  
  @Override
  protected void interrupted() {
    end();
  }
}
