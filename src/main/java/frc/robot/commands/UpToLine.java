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
    int encoderErrorTolerance = RobotMap.encoderErrorTolerance;
    
    if(Robot.lineDetector.getIRSensors() == 0){
      if(Math.abs(Robot.drive.LeftError) <= encoderErrorTolerance &&
         Math.abs(Robot.drive.RightError) <= encoderErrorTolerance) {
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) != 0 ||
           (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) != 0) {
          Robot.drive.setLeftPosition(RobotMap.LeftEncoder.getRaw() + 4);
          Robot.drive.setRightPosition(RobotMap.RightEncoder.getRaw() + 4);
          }
        else {
          Robot.drive.setLeftPosition(RobotMap.LeftEncoder.getRaw());
          Robot.drive.setRightPosition(RobotMap.RightEncoder.getRaw());
        }
      }
    }
    if(Robot.lineDetector.getIRSensors() != 0) {
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 0 && 
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 0) {
        if((Robot.ultrasonicSystem.getLeftValues()[0] - Robot.ultrasonicSystem.getLeftValues()[1]) >= RobotMap.ultrasonicErrorTolerance) {

          //Temp variables, to ensure that the math is done in the proper order, as Java doesn't abide by PEMDAS.
          int alpha = Robot.ultrasonicSystem.getLeftValues()[0]-Robot.ultrasonicSystem.getLeftValues()[1];
          int beta = alpha/-7;
          int gamma = beta + RobotMap.LeftEncoder.getRaw();
          int gammab = -beta + RobotMap.RightEncoder.getRaw();

          Robot.drive.setLeftPosition(gamma);
          Robot.drive.setRightPosition(gammab);
        }
        else {
          Robot.drive.setLeftPosition(RobotMap.LeftEncoder.getRaw());
        }
      }
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 0 &&
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1 &&
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 0) 

        //Temp variables, to ensure that the math is done in the proper order, as Java doesn't abide by PEMDAS.
        if((Robot.ultrasonicSystem.getRightValues()[0] - Robot.ultrasonicSystem.getRightValues()[1]) >= RobotMap.ultrasonicErrorTolerance) {
          int alpha = Robot.ultrasonicSystem.getRightValues()[0]-Robot.ultrasonicSystem.getRightValues()[1];
          int beta = alpha/-7;
          int gamma = beta + RobotMap.LeftEncoder.getRaw();
          int gammab = -beta + RobotMap.RightEncoder.getRaw();

          Robot.drive.setRightPosition(gamma);
          Robot.drive.setLeftPosition(gammab);
        }
      }
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 ||
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1) {
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 1) {
          int precalcL = RobotMap.RightEncoder.getRaw() + 4;
          int precalcR = RobotMap.LeftEncoder.getRaw() + 4;

          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }
      }
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 ||
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1) {
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 1) {
          int precalcL = RobotMap.RightEncoder.getRaw() - 4;
          int precalcR = RobotMap.LeftEncoder.getRaw() - 4;

          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }
      }
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 0 &&
    (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 &&
    (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 0 &&
    (Robot.ultrasonicSystem.getLeftValues()[0] - Robot.ultrasonicSystem.getLeftValues()[1]) <= RobotMap.ultrasonicErrorTolerance) {
      Robot.cargoOuttake.setCargoSpeed(0.5);
  }
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 0 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 0 &&
      (Robot.ultrasonicSystem.getRightValues()[0] - Robot.ultrasonicSystem.getRightValues()[1]) <= RobotMap.ultrasonicErrorTolerance) {
        Robot.cargoOuttake.setCargoSpeed(-0.5);
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
