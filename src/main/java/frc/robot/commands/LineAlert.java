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

public class LineAlert extends Command {
  public LineAlert() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.linedetector);
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

    if(Robot.linedetector.getLeftSensors() > 0) {
      leftRight += 1;
    }

    if(Robot.linedetector.getRightSensors() > 0) {
      leftRight += 2;
    }

    switch(leftRight) {
      case 0:
        System.out.println("No Lines detected; If expected, switch to manual mode");
        break;

      case 1:
        

        break;

      case 2:

        break;

      case 3:
        System.out.println("ERROR Switch to manual mode ERROR");
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
