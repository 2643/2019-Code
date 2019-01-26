/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.LineDetector;
import edu.wpi.first.wpilibj.command.Command;
/**
 * Says when a line is detected
 */
public class LineAlert extends Command {
  public LineAlert() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lineDetector);
    requires(Robot.cargoOuttake);
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int leftRight = 0;
    int value = 0;

    if(Robot.lineDetector.getLeftSensors() > 1) {
      leftRight += 1;
      value = Robot.lineDetector.getLeftSensors();
    }

    if(Robot.lineDetector.getRightSensors() > 1) {
      leftRight += 2;
      value = Robot.lineDetector.getLeftSensors();
    }

    switch(leftRight) {
      case 0:
        System.out.println("No Lines detected; If lines expected, switch to manual mode");
        //no lights
        break;

      case 1: /* Left Side Line Detected. */
        if(value%3 == 0) {
          //Make Left MIDDLE light shine
        }
        if(value%5 == 0) {
          //Make Left FRONT light shine
        }
        if(value%7 == 0) {
          //Make Left BACK light shine
        }
        break;

      case 2: /* Right Side Line Detected */
        if(value%3 == 0) {
          //Make Right MIDDLE light shine
        }
        if(value%5 == 0) {
          //Make Right FRONT light shine
        }
        if(value%7 == 0) {
          //Make Right BACK light shine
        }
        break;

      case 3:
        //This should never happen. Ever.
        System.out.println("ERROR Switch to manual mode ERROR");
        System.out.println("ERROR ERROR ERROR");
        //Make all lights start flashing, to indicate errors.
        break;
    }

  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
