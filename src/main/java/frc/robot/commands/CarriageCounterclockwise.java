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
 * Turns chains on carriage counterclockwise
 */
public class CarriageCounterclockwise extends Command {
  public CarriageCounterclockwise() {
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

    //Check if pot is over the counterclockwise limit, if true, accel negatively, otherwise stop.
    //TODO check direction of potentiometer.
    //TODO Specifically in which way it increases/decreases.
    Robot.carriage.setCarriageSpeed(-RobotMap.carriageMotorSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /* Check for potentiometer position,
    *  If at under greater than min, continue
    *  Else, stop immediately.
    */
    if (RobotMap.carriagePot.get() > RobotMap.carriageCounterclockwiseMin) {
      return false;
    }
    else {
      return true;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.carriage.setCarriageSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Just in case
    end();
  }
}
