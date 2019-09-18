/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ResetElevator extends Command {

  public static boolean CalibrateSparkMax = false;
  public static int CalibrateNumber;
  public static boolean atBottom = false; 

  public ResetElevator() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     /* --
    //This is commented out because the elevator become unoperational after Govind broke it
    //It should be uncommented when the elevator is fixed mechanically

     if(RobotMap.elevatorBottomLimit.get() && !atBottom && !CalibrateSparkMax){
        //This reduces the amount of times that this piece of code runs
       if(CalibrateNumber % 10 == 0){
         RobotMap.rotations = RobotMap.elevatorMotor.getEncoder().getPosition() - 1;
         RobotMap.elevatorMotor.getPIDController().setReference(RobotMap.rotations, ControlType.kPosition);
       }
     }
     else if(!RobotMap.elevatorBottomLimit.get() && !CalibrateSparkMax){
       atBottom = true;
     }
     else if(!CalibrateSparkMax){
         CalibrateNumber ++;
         if(RobotMap.elevatorBottomLimit.get()){
           if(CalibrateNumber % 25 == 0){
             RobotMap.rotations = (RobotMap.elevatorMotor.getEncoder().getPosition() - 1);
             RobotMap.elevatorMotor.getPIDController().setReference(RobotMap.rotations, ControlType.kPosition);
             //System.out.println("Moving up");
           }
         }else if(!RobotMap.elevatorBottomLimit.get()){
             RobotMap.rotations = 0;
             RobotMap.elevatorMotor.getEncoder().setPosition(0);
             CalibrateSparkMax = true;
             //System.out.println("Zeroed");
         }
       }else{
        Scheduler.getInstance().run();
        //System.out.println(RobotMap.elevatorMotor.getEncoder().getPosition());
       }
    */
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
