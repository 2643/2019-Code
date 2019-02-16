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

public class LastLineDetected extends Command {
  public LastLineDetected() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lineDetector);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 1){
      RobotMap.lastLeftOne[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastLeftOne[1] = RobotMap.RightEncoder.getRaw();
    }
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1){
      RobotMap.lastLeftTwo[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastLeftTwo[1] = RobotMap.RightEncoder.getRaw();
    } 
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 1){
      RobotMap.lastLeftThree[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastLeftThree[1] = RobotMap.RightEncoder.getRaw();
    } 
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 1){
      RobotMap.lastRightOne[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastRightOne[1] = RobotMap.RightEncoder.getRaw();
    } 
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1){
      RobotMap.lastRightTwo[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastRightTwo[1] = RobotMap.RightEncoder.getRaw(); 
    } 
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 1){
      RobotMap.lastRightThree[0] = RobotMap.LeftEncoder.getRaw();
      RobotMap.lastRightThree[1] = RobotMap.RightEncoder.getRaw();
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
