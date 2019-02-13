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
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int leftEncoder = RobotMap.LeftEncoder.getRaw();
    int rightEncoder = RobotMap.RightEncoder.getRaw();

    int curLeftTarget = RobotMap.currentLeftEncoderTarget;
    int curRightTarget = RobotMap.currentRightEncoderTarget;

    int encoderErrorTolerance = RobotMap.encoderErrorTolerance;

    int curLeftError = leftEncoder - curLeftTarget;
    int curRightError = rightEncoder - curRightTarget;

    if(Robot.lineDetector.getIRSensors() > 0 && Robot.lineDetector.getIRSensors() <= 7){
      
    }

    if(Math.abs(curLeftError) >= encoderErrorTolerance){
      if(Robot.lineDetector.getIRSensors() == 0){
        Robot.drive.setLeftPosition(leftEncoder + 2);
      }
    }
    if(Math.abs(curRightError) >= encoderErrorTolerance){
      if(Robot.lineDetector.getIRSensors() == 0){
        Robot.drive.setRightPosition(rightEncoder + 2);
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
