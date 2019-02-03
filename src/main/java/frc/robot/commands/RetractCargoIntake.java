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
 * Retracts the cargo intake
 */
public class RetractCargoIntake extends Command {
  public RetractCargoIntake() {
    requires(Robot.cargoIntake);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.cargoIntake.setRectractSpeed(RobotMap.cargoRetractSpeed);
  }

  @Override
  protected boolean isFinished() {
    if(Robot.cargoIntake.getPotentiometer() == RobotMap.cargoIntakeDown){
      return true;
    } else{
      return false;
    }
  }

  @Override
  protected void end() {
    Robot.cargoIntake.setRectractSpeed(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
