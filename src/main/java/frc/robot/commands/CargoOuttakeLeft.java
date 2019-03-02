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
 * Shoots the cargo out towards the left
 */
public class CargoOuttakeLeft extends Command {
  public CargoOuttakeLeft() {
    requires(Robot.cargoOuttake);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.cargoOuttake.setCargoSpeed(RobotMap.cargoOuttakeLeftSpeed); //TODO change if needed
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.cargoOuttake.setCargoSpeed(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
