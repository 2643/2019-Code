/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Calibrate extends Command {
  private int calibrateCycle = 0;  
  private double rotations = 0; 
  private boolean finished = false; 
  private boolean reset = false; 

  /**
   * Elevator needs to be at the bottom in order to run this
   */
  public Calibrate() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    //if not hitting the limit switch don't calibrate
    if(RobotMap.elevatorBottomLimit.get() == false){
      finished = true; 
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    calibrateCycle ++;
    
    // if(!reset){
    //   Robot.elevator.setElevatorPosition(0);
    //   if(calibrateCycle % 5 == 0 && Math.round(RobotMap.elevatorMotor.getEncoder().getPosition()) == 0){
    //     reset = true; 
    //   }
    // }
    // else if(RobotMap.elevatorBottomLimit.get()){
    //   if(calibrateCycle % 10 == 0){
    //     rotations = (RobotMap.elevatorMotor.getEncoder().getPosition() + 2);
    //     RobotMap.elevatorMotor.getPIDController().setReference(rotations, ControlType.kPosition);
    //   }
    // }else if(!RobotMap.elevatorBottomLimit.get()){
    //   rotations = 0;
    //   RobotMap.elevatorMotor.getEncoder().setPosition(0);
    //   RobotMap.elevatorMotor.getPIDController().setReference(0, ControlType.kPosition);
    //   finished = true; 
    // }

    /*************************************************************************************/

    //zero should be two encoder ticks above the very bottom of the elevator
    if(!reset){
      RobotMap.elevatorMotor.getPIDController().setReference(-2, ControlType.kPosition);
      reset = true; 
    }
    //if it has been reset and some time has passed, make where it is at the new zero
    else if(reset && calibrateCycle % 10 == 0){
      RobotMap.elevatorMotor.getEncoder().setPosition(0);
      RobotMap.elevatorMotor.getPIDController().setReference(0, ControlType.kPosition);
      finished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.elevatorMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
