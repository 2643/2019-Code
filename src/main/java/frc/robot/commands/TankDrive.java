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
 * Sets speeds to Drivestick axis
 */
public class TankDrive extends Command {
  public TankDrive() {

    requires(Robot.drive);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //Setting joystick axis
    Robot.drive.setLeftSpeed(RobotMap.multiplier*Robot.oi.getDriverStick().getRawAxis(RobotMap.leftDriverAxis));
    Robot.drive.setRightSpeed(RobotMap.multiplier*Robot.oi.getDriverStick().getRawAxis(RobotMap.rightDriverAxis));
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drive.stopAllSpeed();
  } 

  @Override
  protected void interrupted() {
    end();
  }
}
