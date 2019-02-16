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

public class CarriageCenter extends Command {
  public CarriageCenter() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.carriage);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /* Checks for potentiometer position
    *  If carriage is not centered, moves the motor until it is centered
    */
    //TODO check to make sure this works 
    if(RobotMap.carriagePot.get() < RobotMap.carriageCenterValue){
      RobotMap.carriageMotor.set(RobotMap.carriageMotorSpeed);
    }
    //TODO check to make sure this works 
    else if(RobotMap.carriagePot.get() > RobotMap.carriageCenterValue){
      RobotMap.carriageMotor.set(-RobotMap.carriageMotorSpeed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Checks whether carriage is centered or not
    if(RobotMap.carriagePot.get() == RobotMap.carriageCenterValue){
      return true;
    } else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.carriageMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
