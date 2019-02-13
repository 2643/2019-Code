/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;

public class DriveTrainPID extends Command {
  public DriveTrainPID() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    /*
	  SmartDashboard.putData("Auto mode", m_chooser);
    RobotMap.LeftEncoder.reset();
    SmartDashboard.putNumber("Set LeftTarget", 0);
    SmartDashboard.putNumber("Set RightTarget", 0);
    SmartDashboard.putNumber("Set P", 0.05);
    SmartDashboard.putNumber("Set D", 0.0);
    SmartDashboard.putNumber("Set I", 0.0);
    SmartDashboard.putNumber("RightIntgorSumLimit", 25);
    SmartDashboard.putNumber("LeftIntgorSumLimit", 25);
    SmartDashboard.putNumber("Set AGain", 0.0);
    SmartDashboard.putNumber("Set Alimit", 18);
    SmartDashboard.putNumber("Set Max Output", .5);
    */
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

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
