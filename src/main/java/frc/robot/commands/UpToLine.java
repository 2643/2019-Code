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
import frc.robot.subsystems.LineDetector;

public class UpToLine extends Command {
  public UpToLine() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    requires(Robot.lineDetector);
    requires(Robot.ultrasonicSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    int curLeftTarget = RobotMap.currentLeftEncoderTarget;
    int curRightTarget = RobotMap.currentRightEncoderTarget;

    int encoderErrorTolerance = RobotMap.encoderErrorTolerance;

    int validLinePosition = -2;

    int curLeftError = RobotMap.LeftEncoder.getRaw() - curLeftTarget;
    int curRightError = RobotMap.RightEncoder.getRaw() - curRightTarget;
    
    if(Robot.lineDetector.getIRSensors() == 0){
      if(Math.abs(curLeftError) >= encoderErrorTolerance &&
         Math.abs(curRightError) >= encoderErrorTolerance) {
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 0 ||
           (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 0) {
          Robot.drive.setLeftPosition(RobotMap.LeftEncoder.getRaw() + 2);
          Robot.drive.setRightPosition(RobotMap.RightEncoder.getRaw() + 2);
          }
        else {
          Robot.drive.setLeftPosition(RobotMap.LeftEncoder.getRaw());
          Robot.drive.setRightPosition(RobotMap.RightEncoder.getRaw());
        }
      }
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
