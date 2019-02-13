package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class Drive extends Subsystem
{
    //Declaring Drive Masters and Slaves
    private final WPI_TalonSRX leftDriveMaster;
    private final WPI_TalonSRX leftDriveSlave;
    private final WPI_TalonSRX rightDriveMaster;
    private final WPI_TalonSRX rightDriveSlave;
    /**
     * Drive constructor 
     * @param l1 left front motor
     * @param l2 left back motor
     * @param r1 right front motor
     * @param r2 right back motor 
     */
    public Drive(WPI_TalonSRX l1, WPI_TalonSRX l2, WPI_TalonSRX r1, WPI_TalonSRX r2){
        leftDriveMaster = l1;
        leftDriveSlave = l2;

        leftDriveSlave.set(ControlMode.Follower, leftDriveMaster.getDeviceID());  

        rightDriveMaster = r1;
        rightDriveSlave = r2;

        rightDriveSlave.set(ControlMode.Follower, rightDriveMaster.getDeviceID());

        leftDriveMaster.configContinuousCurrentLimit(32, 0);
		leftDriveMaster.configPeakCurrentLimit(35, 0);
		leftDriveMaster.configPeakCurrentDuration(80, 0);
        leftDriveMaster.enableCurrentLimit(true);
        
        leftDriveSlave.configContinuousCurrentLimit(32, 0);
		leftDriveSlave.configPeakCurrentLimit(35, 0);
		leftDriveSlave.configPeakCurrentDuration(80, 0);
        leftDriveSlave.enableCurrentLimit(true);
        
        rightDriveMaster.configContinuousCurrentLimit(32, 0);
		rightDriveMaster.configPeakCurrentLimit(35, 0);
		rightDriveMaster.configPeakCurrentDuration(80, 0);
        rightDriveMaster.enableCurrentLimit(true);
        
        rightDriveSlave.configContinuousCurrentLimit(32, 0);
		rightDriveSlave.configPeakCurrentLimit(35, 0);
		rightDriveSlave.configPeakCurrentDuration(80, 0);
		rightDriveSlave.enableCurrentLimit(true);
    }
    /**
     * Sets TankDrive to default command
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    /**
     * Gets Right Encoder
     */
    public int getRightEncoder(){
        return RobotMap.RightEncoder.get();
    }
    /**
     * Gets Left Encoder
     */
    public int getLeftEncoder(){
        return RobotMap.LeftEncoder.get();
    }
    /**
     * Gets the average value of the right and left encoders
     */
    public int getAverageEncoder(){
        return (getRightEncoder() + getLeftEncoder()) / 2;
    }
    /**
     * Finds highest value of encoders
     * @return Highest value of the two
     */
    public int getMaxEncoder(){
        return Math.max(getRightEncoder(), getLeftEncoder());
    }
    /**
     * Finds lowest value of encoders
     * @return Lowest value of the two
     */
    public int getMinEncoder(){
        return Math.min(getRightEncoder(), getLeftEncoder());
    }
    /**
     * Resets left encoder
     */
    public void resetLeftEncoder(){
        RobotMap.LeftEncoder.reset();
    }
    /**
     * Resets right Encoder
     */
    public void resetRightEncoder(){
        RobotMap.RightEncoder.reset();
    }
    /**
     * Resets all encoders
     */
    public void resetAllEncoders(){
        resetLeftEncoder();
        resetRightEncoder();
    }
    /**
     * Sets speed for the left side
     * @param speed
     */
    public void setLeftSpeed(double speed){
        leftDriveMaster.set(-speed); 
    }
    /**
     * Sets speed for right side
     * @param speed
     */
    public void setRightSpeed(double speed){
        rightDriveMaster.set(speed);
    }
    /**
     * Sets speed for both sides
     */
    public void setAllSpeed(double speed){
        setLeftSpeed(speed);
        setRightSpeed(speed);
    }
    /**
     * Stops all the speed
     */
    public void stopAllSpeed(){
        setAllSpeed(0);
    }

    /**
     * Sets the position of the left side of the robot in encoder ticks
     * @param ticks int the desired position of the left side of the robot in encoder ticks
     */
    public void setLeftPosition(int ticks){
        //TODO finish writing the setLeftPosition method
    }

    /**
     * Sets the position of the right side of the robot in encoder ticks 
     * @param ticks int the desired position of the right side of the robot in encoder ticks
     */
    public void setRightPosition(int ticks){
        //TODO finish writing the setRightPosition method
    }

    /**
     * Sets the position of the robot in encoder ticks
     * @param ticks int the desired position of the robot in encoder ticks
     */
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
    public void setPosition(int ticks){
        //TODO finish writing the setPosition method
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
}