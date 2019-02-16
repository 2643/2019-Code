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

public class CargoLineAuto extends Command {
  public CargoLineAuto() {
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
    //Checks if there isn't a line already sensed.
    if(Robot.lineDetector.getIRSensors() == 0){

      //Checks if the previously gotten value is beneath the maximum encoder reliability value.
      if ((Math.abs(RobotMap.lastLeftOne[0] - Robot.drive.getLeftEncoder()) <= RobotMap.maxReliableEncoder) &&
        (Math.abs(RobotMap.lastLeftOne[1] - Robot.drive.getRightEncoder()) <= RobotMap.maxReliableEncoder)) {
        Robot.drive.setLeftPosition(RobotMap.lastLeftOne[0] + 7); //TODO check these
        Robot.drive.setRightPosition(RobotMap.lastLeftOne[1] + 7); //TODO check these
      }
      else if ((Math.abs(RobotMap.lastRightOne[0] - Robot.drive.getLeftEncoder()) <= RobotMap.maxReliableEncoder) &&
        (Math.abs(RobotMap.lastRightOne[1] - Robot.drive.getRightEncoder()) <= RobotMap.maxReliableEncoder)) {
        Robot.drive.setLeftPosition(RobotMap.lastRightOne[0] + 7); //TODO check these
        Robot.drive.setRightPosition(RobotMap.lastRightOne[1] + 7); //TODO check these
      }
      else if ((Math.abs(RobotMap.lastLeftThree[0] - Robot.drive.getLeftEncoder()) <= RobotMap.maxReliableEncoder) &&
        (Math.abs(RobotMap.lastLeftThree[1] - Robot.drive.getRightEncoder()) <= RobotMap.maxReliableEncoder)) {
        Robot.drive.setLeftPosition(RobotMap.lastLeftThree[0] - 7); //TODO check these
        Robot.drive.setRightPosition(RobotMap.lastLeftThree[1] - 7); //TODO check these
      }
      else if ((Math.abs(RobotMap.lastRightThree[0] - Robot.drive.getLeftEncoder()) <= RobotMap.maxReliableEncoder) &&
        (Math.abs(RobotMap.lastRightThree[1] - Robot.drive.getRightEncoder()) <= RobotMap.maxReliableEncoder)) {
        Robot.drive.setLeftPosition(RobotMap.lastRightThree[0] - 7); //TODO check these
        Robot.drive.setRightPosition(RobotMap.lastRightThree[1] - 7); //TODO check these
      }

      else {
        int encoderErrorTolerance = RobotMap.encoderErrorTolerance;

        //Robot has driven to be below the PID tolerance.
        if(Math.abs(Robot.drive.LeftError) <= encoderErrorTolerance &&
          Math.abs(Robot.drive.RightError) <= encoderErrorTolerance) {
            //If the middle sensor isn't activated, continue driving fowards.
          if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) != 0 ||
            (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) != 0) {

            //Add 1 inch to current value
            int precalcL = Robot.drive.getLeftEncoder() + 4;
            int precalcR = Robot.drive.getRightEncoder() + 4;

            //Move the one inch fowards
            Robot.drive.setLeftPosition(precalcL);
            Robot.drive.setRightPosition(precalcR);
            }
          //If the middle sensor is activated, stop where it is.
          else {
            Robot.drive.setLeftPosition(Robot.drive.getLeftEncoder());
            Robot.drive.setRightPosition(Robot.drive.getRightEncoder());
          }
        }
      }
    }
      //Checks if there is an IR that's been activated.
    if(Robot.lineDetector.getIRSensors() != 0) {
      //Only Left middle is activated.
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 0 && 
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 0) {
        //Checks if it's angled too far.
        if((Robot.ultrasonicSystem.getLeftValues()[0] - Robot.ultrasonicSystem.getLeftValues()[1]) >= RobotMap.ultrasonicErrorTolerance) {

          //Temp variables, to ensure that the math is done in the proper order, as Java doesn't abide by PEMDAS.
          int alpha = Robot.ultrasonicSystem.getLeftValues()[0]-Robot.ultrasonicSystem.getLeftValues()[1];
          int beta = alpha/-7;//TODO verify my math.
          int gamma = beta + Robot.drive.getLeftEncoder();
          int gammab = -beta + Robot.drive.getRightEncoder();

          //Turns it the proper amount of ticks
          Robot.drive.setLeftPosition(gamma);
          Robot.drive.setRightPosition(gammab);
        }
        //If it isn't too far, stop the movement.
        else {
          Robot.drive.setLeftPosition(Robot.drive.getLeftEncoder());
          Robot.drive.setRightPosition(Robot.drive.getRightEncoder());
        }
      }
      //Only if Right middle is activated.
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 0 &&
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1 &&
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 0){
        //Checks that the ultrasonic is over the tolerance threshold
        if((Robot.ultrasonicSystem.getRightValues()[0] - Robot.ultrasonicSystem.getRightValues()[1]) >= RobotMap.ultrasonicErrorTolerance) {

          //Temp variables, to ensure that the math is done in the proper order, as Java doesn't abide by PEMDAS.
          //Alpha is the error off in MMs
          int alpha = Robot.ultrasonicSystem.getRightValues()[0]-Robot.ultrasonicSystem.getRightValues()[1];
          //Divide by 7 to get tick distance
          int beta = alpha/-7;//TODO verify my math.
          //Drive in the direction
          int gamma = -beta + Robot.drive.getLeftEncoder();
          //Also drive in the right direction
          int gammab = beta + Robot.drive.getRightEncoder();

          //Drive to the proper position
          Robot.drive.setLeftPosition(gamma);
          Robot.drive.setRightPosition(gammab);
        }
      }
      //Checks if any of the middle sensor has been tripped.
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 ||
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1) {

        //Checks if the front sensor has been tripped
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 1) {

          //Add to make the robot move 1 inch fowards.
          int precalcL = Robot.drive.getLeftEncoder() + 4;
          int precalcR = Robot.drive.getRightEncoder() + 4;

          //Make the robot move 1 inch fowards.
          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }

        //Checks if the back sensor has been tripped
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 1) {
          
          //Subtract to make the robot move 1 inch backwards.
          int precalcL = Robot.drive.getLeftEncoder() - 4;
          int precalcR = Robot.drive.getRightEncoder() - 4;

          //Make the robot move 1 inch backwards
          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }
      }

      //Checks that the middle sensor is NOT tripped
      if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 0 ||
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 0) {

        //Checks that the back sensor IS tripped
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 1) {

          //Subtract to make the robot move 1.8 inches backwards
          int precalcL = Robot.drive.getLeftEncoder() - 7;
          int precalcR = Robot.drive.getRightEncoder() - 7;
          
          //Move the robot
          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }

        //Checks that the front sensor IS tripped
        if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 1 ||
        (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 1) {

          //Add to make the robot move 1.8 inches backwards
          int precalcL = Robot.drive.getLeftEncoder() + 7;
          int precalcR = Robot.drive.getRightEncoder() + 7;
          
          //Move the robot
          Robot.drive.setLeftPosition(precalcL);
          Robot.drive.setRightPosition(precalcR);
        }
      }
    }
    //Checks if all of the positions have been met, if they have, end().
    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L1) == 0 &&
    (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L2) == 1 &&
    (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_L3) == 0 &&
    (Robot.ultrasonicSystem.getLeftValues()[0] - Robot.ultrasonicSystem.getLeftValues()[1]) <= RobotMap.ultrasonicErrorTolerance) {
      end();
    }

    if((Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R1) == 0 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R2) == 1 &&
      (Robot.lineDetector.getIRSensors() & LineDetector.SENSOR_R3) == 0 &&
      (Robot.ultrasonicSystem.getRightValues()[0] - Robot.ultrasonicSystem.getRightValues()[1]) <= RobotMap.ultrasonicErrorTolerance) {
      end();
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
    Robot.drive.setLeftPosition(Robot.drive.getLeftEncoder());
    Robot.drive.setRightPosition(Robot.drive.getRightEncoder());
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end(); 
  }
}
