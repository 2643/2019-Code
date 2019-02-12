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

  double LeftCurrentEncoderInput = 0;
  double RightCurrentEncoderInput = 0;
  double RightEncoderTarget = 0;
  double LeftEncoderTarget = 0;

  double RightD = SmartDashboard.getNumber("Set D", 0.0);
  double RightP = SmartDashboard.getNumber("Set P", 0.05);

  double LeftD = SmartDashboard.getNumber("Set D", 0.0);
  double LeftP = SmartDashboard.getNumber("Set P", 0.05);

  double RightIntgorSum = 0;
  double RightI = SmartDashboard.getNumber("Set I", 0.0);

  double LeftIntgorSum = 0;
  double LeftI = SmartDashboard.getNumber("Set I", 0.0);

  double RightPreviousEncoderInput = 0;
  double LeftPreviousEncoderInput = 0;

  double LeftError = 0;
  double RightError = 0;

  double RightDelta = 0;
  double LeftDelta = 0;

  double LeftOutput = 0;
  double RightOutput = 0;

  double RightOldVel = 0;
  double RightOldPos = 0;

  double RightCurrentVel = 0;
  double RightCurrentAccel = 0;

  double LeftOldVel = 0;
  double LeftOldPos = 0;

  double LeftCurrentVel = 0;
  double LeftCurrentAccel = 0;

  double AGain = 0;
  double ALimit = 18;

  double unlimitedAccel = 0;

  double MaxOutput = 0;
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
        /*
      RobotMap.RightFrontMotor.set(oi.getDriverStick().getRawAxis(5));
      RobotMap.RightBackMotor.set(oi.getDriverStick().getRawAxis(5));
  
      RobotMap.LeftBackMotor.set(-oi.getDriverStick().getRawAxis(1));
      RobotMap.LeftFrontMotor.set(-oi.getDriverStick().getRawAxis(1));
    */
    System.out.println("Left Encoder " + RobotMap.LeftEncoder.getRaw());
    System.out.println("Right Encoder " + RobotMap.RightEncoder.getRaw());
    

    //System.out.println("Right Accel" + RightCurrentAccel);
    //System.out.println("Left Vel" + LeftCurrentAccel);
    /**Encoder Target */

    LeftCurrentEncoderInput = RobotMap.LeftEncoder.getRaw();
    RightCurrentEncoderInput = RobotMap.RightEncoder.getRaw();

    RightEncoderTarget = RobotMap.RightEncoderTarget;
    LeftEncoderTarget = RobotMap.LeftEncoderTarget;

    //RightEncoderTarget = RightEncoderTarget + (OI.getDriverStick().getRawAxis(5) * 5);
    //LeftEncoderTarget = LeftEncoderTarget + (OI.getDriverStick().getRawAxis(1) * 5);
    
    RightD = SmartDashboard.getNumber("Set D", 0.0);
    RightP = SmartDashboard.getNumber("Set P", 0.05);
    RightI = SmartDashboard.getNumber("Set I", 0.0);
  
    LeftD = SmartDashboard.getNumber("Set D", 0.0);
    LeftP = SmartDashboard.getNumber("Set P", 0.05);
    LeftI = SmartDashboard.getNumber("Set I", 0.0);

    RightCurrentVel = RightCurrentEncoderInput - RightPreviousEncoderInput;
    LeftCurrentVel = LeftCurrentEncoderInput - LeftPreviousEncoderInput;

    RightCurrentAccel = RightCurrentVel - RightOldVel;
    LeftCurrentAccel = LeftCurrentVel - LeftOldVel;

    unlimitedAccel = RightCurrentAccel;
    //System.out.println(unlimitedAccel);

    RightError = RightEncoderTarget - RightCurrentEncoderInput;
    LeftError = LeftEncoderTarget - LeftCurrentEncoderInput;

    RightIntgorSum = RightIntgorSum + RightError;
    LeftIntgorSum = LeftIntgorSum + LeftError;
    
    ALimit = SmartDashboard.getNumber("Alimit", 18);

    /*if(RightCurrentAccel > SmartDashboard.getNumber("ALimit", 18)){
      RightCurrentAccel = SmartDashboard.getNumber("Alimit", 18);
    }
    if(RightCurrentAccel < -SmartDashboard.getNumber("Alimit", 18)){
      RightCurrentAccel = -SmartDashboard.getNumber("ALimit", 18);
    }
    if(LeftCurrentAccel > SmartDashboard.getNumber("ALimit", 18)){
      LeftCurrentAccel = SmartDashboard.getNumber("Alimit", 18);
    }
    if(LeftCurrentAccel < -SmartDashboard.getNumber("Alimit", 18)){
      LeftCurrentAccel = -SmartDashboard.getNumber("ALimit", 18);
    }
    if(-ALimit < RightCurrentAccel && RightCurrentAccel < ALimit){
      RightCurrentAccel = 0;
    }
    if(-ALimit < LeftCurrentAccel && LeftCurrentAccel < ALimit){
      LeftCurrentAccel = 0;
    }
    */

    //System.out.println("Right Accel" + RightCurrentAccel);

    if(RightIntgorSum > SmartDashboard.getNumber("RightIntgorSumLimit", 25)){
      RightIntgorSum = SmartDashboard.getNumber("RightIntgorSumLimit", 25);
    }
    if(RightIntgorSum < -SmartDashboard.getNumber("RightIntgorSumLimit", 25)){
      RightIntgorSum = -SmartDashboard.getNumber("RightIntgorSumLimit", 25);
    }

    if(LeftIntgorSum > SmartDashboard.getNumber("LeftIntgorSumLimit", 25)){
      LeftIntgorSum = SmartDashboard.getNumber("LeftIntgorSumLimit", 25);
    }
    if(LeftIntgorSum < -SmartDashboard.getNumber("LeftIntgorSumLimit", 25)){
      LeftIntgorSum = -SmartDashboard.getNumber("LeftIntgorSumLimit", 25);
    }

    AGain = SmartDashboard.getNumber("AGain", 0);


    
    /**PID Output Workout Stuff*/
    LeftOutput = (-LeftP * LeftError)+(LeftIntgorSum * LeftI)+(LeftD * LeftDelta)+(LeftCurrentAccel * AGain);

    RightOutput = (-RightP * RightError)+(RightIntgorSum * RightI)+(RightD * RightDelta)+(RightCurrentAccel * AGain);

    MaxOutput = SmartDashboard.getNumber("Set Max Output", .5);

    /**Left Output Limiter*/
    
    if(LeftOutput > MaxOutput){
      LeftOutput = MaxOutput;
    }
    if(LeftOutput < -MaxOutput){
      LeftOutput = -MaxOutput;
    }
    /**Right Output Limiter*/
    
    if(RightOutput > MaxOutput){
      RightOutput = MaxOutput;
    }
    if(RightOutput < -MaxOutput){
      RightOutput = -MaxOutput;
    }
   RobotMap.LeftFrontMotor.set(-LeftOutput);
   RobotMap.LeftBackMotor.set(-LeftOutput);
   RobotMap.RightFrontMotor.set(RightOutput);
   RobotMap.RightBackMotor.set(RightOutput);

   RightPreviousEncoderInput = RightCurrentEncoderInput;
   LeftPreviousEncoderInput = LeftCurrentEncoderInput;

   RightOldVel = RightCurrentVel;
   LeftOldVel = LeftCurrentVel;
   

  //send help
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
