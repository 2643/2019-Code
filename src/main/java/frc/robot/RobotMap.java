/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
    
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // Everything is public because vscode likes to complain a lot about it.

  /* Pot Offsets */
  //Carriage offset
  public static int carriagePotOffset = 0; //TODO Check the potentiometer offset of the carriage potentiometer

  //Cargo Offset
  public static int cargoIntakePotOffset = 0; //TODO check the potentiometer offset of the cargo intake potentiometer
  
  /* Ports */
  //drive ports
  public static int lFrontMotorPort = 0;   //TODO Check the device ID of the left front motor on the drive train on Phoenix Tuner
  public static int lBackMotorPort = 0;    //TODO Check the device ID of the left back motor on the drive train 
  public static int rFrontMotorPort = 0;   //TODO Check the device ID  of the right front motor on the drive train 
  public static int rBackMotorPort = 0;    //TODO Check the device ID of the right back motor on the drive train 
  public static int rEncoderPort1 = 0;     //TODO Check the first port of the right encoder 
  public static int rEncoderPort2 = 1;     //TODO Check the second port of the right encoder
  public static int lEncoderPort1 = 0;     //TODO Check the first port of the left encoder
  public static int lEncoderPort2 = 1;     //TODO Check the second port of the left encoder
  public static int driverCameraServoPort1 = 0; //TODO Check the PWM port that this is plugged into
  public static int driverCameraServoPort2 = 1; //TODO Check the PWN port that this is plugged into 

  //elevator ports
  public static int elevatorPort = 0;      //TODO Check the device ID of the master motor 
  public static int elevatorSlavePort = 0; //TODO Check the device ID of the slave motor

  //solenoid ports
  public static int Solenoid1Port1 = 1;     //TODO Check the first port of the first solenoid
  public static int Solenoid1Port2 = 2;     //TODO Check the second port of the first solenoid
  public static int Solenoid2Port1 = 3;     //TODO Check the first port of the second solenoid
  public static int Solenoid2Port2 = 4;     //TODO Check the second port of the second solenoid
  public static int Solenoid3Port1 = 5;     //TODO Check the first port of the third solenoid
  public static int Solenoid3Port2 = 6;     //TODO Check the second port of the third solenoid
  public static int Solenoid4Port1 = 7;     //TODO Check the first port of the fourth solenoid
  public static int Solenoid4Port2 = 8;     //TODO Check the second port of the fourth solenoid

  //hatch ports 
  public static int HatchMotorPort = 3;    //TODO Check the device ID of the hatch motor
  public static int HatchTopPort = 0; //TODO Check the port of the top limit switch
  public static int HatchBottomPort = 0; //TODO CHeck the port of the bottom limit switch 

  //carriage ports
  public static int carriageMotorPort = 0;  //TODO Check the device ID of the carriage motor
  public static int carriagePotPort = 0; //TODO Check the port of the carriage potentiometer

  // IR sensor ports
  public static int irLeftPort1 = 1;  //TODO Check the port of this left side IR sensor
  public static int irLeftPort2 = 2;  //TODO Check the port of this left side IR sensor
  public static int irLeftPort3 = 3;  //TODO CHeck the port of this left side IR sensor
  public static int irRightPort1 = 5; //TODO CHeck the port of this right side IR sensor
  public static int irRightPort2 = 6; //TODO Check the port of this right side IR sensor
  public static int irRightPort3 = 7; //tODO Check the port of this right side IR sensor

  //cargo ports
  public static int cargoIntakePort1 = 0; //TODO Check the device ID of the first cargo intake motor
  public static int cargoIntakePort2 = 0; //TODO check the device iD of the second cargo intake motor
  public static int cargoRetractPort = 0; //TODO Check the device iD of the retraction cargo intake motor
  public static int cargoIntakePotPort = 0; //TODO Check the port of the potentiometer of the cargo intake 
  public static int cargoOuttakePort = 0; //TODO Check the device ID of the cargo outtake motor

  //Ultrasonic ports
  public static int ultrasonicLeftOneTrigger = 0;
  public static int ultrasonicLeftOneEcho = 0;
  public static int ultrasonicLeftTwoTrigger = 0;
  public static int ultrasonicLeftTwoEcho = 0;
  public static int ultrasonicRightOneTrigger = 0;
  public static int ultrasonicRightOneEcho = 0;
  public static int ultrasonicRightTwoTrigger = 0;
  public static int ultrasonicRightTwoEcho = 0;

  /* Motors */
  //Drive motors
  public static WPI_TalonSRX lFrontMotor = new WPI_TalonSRX(lFrontMotorPort);
  public static WPI_TalonSRX lBackMotor = new WPI_TalonSRX(lBackMotorPort);
  public static WPI_TalonSRX rFrontMotor = new WPI_TalonSRX(rFrontMotorPort);
  public static WPI_TalonSRX rBackMotor = new WPI_TalonSRX(rBackMotorPort);
  public static Servo driverCameraServo1 = new Servo(driverCameraServoPort1);
  public static Servo driverCameraServo2 = new Servo(driverCameraServoPort2);

  //elevator motors
  public static CANSparkMax elevatorMotor = new CANSparkMax(elevatorPort, MotorType.kBrushless);

  //hatch motors/solenoids
  public static WPI_TalonSRX HatchTalon = new WPI_TalonSRX(HatchMotorPort);
  public static DoubleSolenoid HatchPiston = new DoubleSolenoid(Solenoid1Port1, Solenoid1Port2);
  public static DoubleSolenoid HatchPiston2 = new DoubleSolenoid(Solenoid2Port1, Solenoid2Port2);
  public static DoubleSolenoid ReleaseHatchPiston1 = new DoubleSolenoid(Solenoid3Port1, Solenoid3Port2);
  public static DoubleSolenoid ReleaseHatchPiston2 = new DoubleSolenoid(Solenoid4Port1, Solenoid4Port2);

  //carriage
  public static WPI_TalonSRX carriageMotor = new WPI_TalonSRX(carriageMotorPort);

  //cargo
  public static WPI_TalonSRX cargoIntakeMotor1 = new WPI_TalonSRX(cargoIntakePort1);
  public static WPI_TalonSRX cargoIntakeMotor2 = new WPI_TalonSRX(cargoIntakePort2);
  public static WPI_TalonSRX cargoRetractMotor = new WPI_TalonSRX(cargoRetractPort);
  public static WPI_TalonSRX cargoOuttakeMotor = new WPI_TalonSRX(cargoOuttakePort);

  /* Sensors */
  //drive sensors
  public static Encoder rEncoder = new Encoder(rEncoderPort1, rEncoderPort2);
  public static Encoder lEncoder = new Encoder(lEncoderPort1, lEncoderPort2);
  public static UsbCamera camera1;
  public static UsbCamera camera2;
  public static VideoSink server;
  
  //elevator sensors
  public static DigitalInput elevatorBottomLimit = new DigitalInput(0);
  public static CANEncoder elevatorEncoder = new CANEncoder(elevatorMotor);
  public static CANPIDController elevatorController = new CANPIDController(elevatorMotor);

  //hatch sensors
  public static DigitalInput HatchTopSwitch = new DigitalInput(HatchTopPort);
  public static DigitalInput HatchBottomSwitch = new DigitalInput(HatchBottomPort);

  //carriage sensors
  public static Potentiometer carriagePot = new AnalogPotentiometer(carriagePotPort, 3600, carriagePotOffset);

  //cargo sensors
  public static Potentiometer cargoIntakePot = new AnalogPotentiometer(cargoIntakePotPort, 3600, cargoIntakePotOffset);

  //IR sensors
  public static DigitalInput irLeft1 = new DigitalInput(irLeftPort1);
  public static DigitalInput irLeft2 = new DigitalInput(irLeftPort2);
  public static DigitalInput irLeft3 = new DigitalInput(irLeftPort3);
  public static DigitalInput irRight1 = new DigitalInput(irRightPort1);
  public static DigitalInput irRight2 = new DigitalInput(irRightPort2);
  public static DigitalInput irRight3 = new DigitalInput(irRightPort3);

  //gyroscope 
  public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  /* Variables */
  //drive varibles
  public static int rightDriverAxis = 1; //TODO Check on the driver gamepad
  public static int leftDriverAxis = 5; //TODO Check on the driver gamepad

  //elevator variables
  static public double elevatorSpeed = 0.3; //Temporary elevator speed. TODO elevator PIDS will have to be implemented.
  static public int elevatorEncoderMaxLimit = 100; //TODO check this upper limit on the real robot
  //This is the maximum encoder ticks allowed from the bottom upwards.
  
  //hatch variables
  public static double hatchDownSpeed = 0; //TODO Test to find a suitable speed
  public static double hatchUpSpeed = 0; //TODO Test to find a suitable speed
  public static Timer hatchPistonTimer = new Timer();
  public static int hatchPistonOutTime = 3; //TODO Test this out 
  public static int hatchReleaseTimeout = 0; //TODO Change this
  public static int hatchRetractTimeout = 0; //TODO Change this
  public static int hatchExtendTimeout = 0; //TODO Change this

  //carriage variables
  public static double carriageMotorSpeed = 0.15; //Carriage motor speed preset should probably implement PIDS
  public static int carriageClockwiseMax = 2000; //TODO find out actual value of carriageClockwiseMax
  public static int carriageCounterclockwiseMin = 500; //TODO find out actual value of carriageCounterclockwiseMax

  //cargo variables
  public static double cargoIntakeSpeed = 0.5; //TODO Check
  public static double cargoReleaseSpeed = 0.5; //TODO Test on the real robot
  public static double cargoRetractSpeed = 0.5; //TODO Test on the real robot
  public static double cargoIntakeDown = 30; //TODO Check this limit for the cargo intake potentiometer with the real robot
  public static double cargoOuttakeSpeed = 0.3; //TODO check this speed with the real robot
  
  //Gyroscope autoalign speed
  public static double autoAlignSpeed = 0.2; //TODO check this with the real robot

  public static double inchesToEncoderTicks(double inches){
    //TODO write the inchesToEncoderTicks later
    
    return 0;
  }

  public static double encoderTicksToInches(double encoder){
    //TODO write the encoderTicksToInches later
   
    return 0;
  }
  //Ultrasonic Initiation
  public static Ultrasonic ultrasonicLeftOne = new Ultrasonic(ultrasonicLeftOneTrigger, ultrasonicLeftOneEcho);
  public static Ultrasonic ultrasonicLeftTwo = new Ultrasonic(ultrasonicLeftTwoTrigger, ultrasonicLeftTwoEcho);
  public static Ultrasonic ultrasonicRightOne = new Ultrasonic(ultrasonicRightOneTrigger, ultrasonicRightOneEcho);
  public static Ultrasonic ultrasonicRightTwo = new Ultrasonic(ultrasonicRightTwoTrigger, ultrasonicRightTwoEcho);

  //driver joystick button numbers

  public static int retractCargoIntakeButtonNumber = 2;
  public static int releaseCargoIntakeButtonNumber = 3;

  //operator board button numbers

  public static int cancelAutoSafetyButtonNumber = 0; //TODO Chech Button Number
  public static int carriageCenterButtonNumber = 0; //TODO Chech Button Number
  public static int elevatorDownButtonNumber = 0; //TODO Chech Button Number
  public static int cargoOuttakeLeftButtonNumber = 0; //TODO Chech Button Number
  public static int carriageLeftButtonNumber = 0; //TODO Chech Button Number
  public static int cargoOuttakeRightButtonNumber = 0; //TODO Chech Button Number
  public static int carriageRightButtonNumber = 0; //TODO Chech Button Number
  public static int elevatorPresetButtonNumber = 0; //TODO Chech Button Number
  public static int elevatorUpButtonNumber = 0; //TODO Chech Button Number
  public static int intakeButtonNumber = 0; //TODO Chech Button Number
  public static int hatchReleaseButtonNumber = 0; //TODO Chech Button Number
  public static int hatchMechanismSwitchNumber = 0; //TODO Chech Button Number

}
