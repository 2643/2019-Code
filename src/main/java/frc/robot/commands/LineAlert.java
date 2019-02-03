/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
/**
 * Says when a line is detected
 */
public class LineAlert extends Command {
  public LineAlert() {
    requires(Robot.lineDetector);
  }
;
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    int value = 0;

    value = Robot.lineDetector.getIRSensors();

        if(value%3 == 0) {
          //Make Left MIDDLE light shine
        }

        if(value%5 == 0) {
          //Make Left FRONT light shine
        }

        if(value%7 == 0) {
          //Make Left BACK light shine
        }

        if(value%11 == 0) {
          //Make Right MIDDLE light shine
        }

        if(value%13 == 0) {
          //Make Right FRONT light shine
        }

        if(value%17 == 0) {
          //Make Right BACK light shine
        }
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
  }
}
