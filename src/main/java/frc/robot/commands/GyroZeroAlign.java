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

public class GyroZeroAlign extends Command {
  public GyroZeroAlign() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    requires(Robot.gyroscope);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    double alpha = Robot.gyroscope.getGyroAngle();
    int beta = 0;

    while(beta<250 || alpha<5 && alpha>355) {
    
      alpha = Robot.gyroscope.getGyroAngle();

      beta += 1;

      if(alpha>5 && alpha<180) {
        Robot.drive.setLeftSpeed(RobotMap.autoAlignSpeed);
        Robot.drive.setRightSpeed(-RobotMap.autoAlignSpeed);
      }

      else if(alpha>180 && alpha<355) {
        Robot.drive.setLeftSpeed(-RobotMap.autoAlignSpeed);
        Robot.drive.setRightSpeed(RobotMap.autoAlignSpeed);
      }

      else if(alpha<5 && alpha>355) {
        Robot.drive.setAllSpeed(0.0);
        beta = 255;
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double alpha = Robot.gyroscope.getGyroAngle();
    if(alpha<5 && alpha>355) {
      return(true);
    }
    else {
      return(false);
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.setAllSpeed(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
