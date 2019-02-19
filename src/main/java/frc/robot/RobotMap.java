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

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
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
  public static int elevatorBottomLimitPort = 0; //TODO Check the port of the bottom limit switch 

  //solenoid ports
  public static int Solenoid1Port1 = 1;     //TODO Check the first port of the first solenoid
  public static int Solenoid1Port2 = 2;     //TODO Check the second port of the first solenoid
  public static int Solenoid2Port1 = 3;     //TODO Check the first port of the second solenoid
  public static int Solenoid2Port2 = 4;     //TODO Check the second port of the second solenoid
  public static int Solenoid3Port1 = 5;     //TODO Check the first port of the third solenoid
  public static int Solenoid3Port2 = 6;     //TODO Check the second port of the third solenoid
  public static int Solenoid4Port1 = 7;     //TODO Check the first port of the fourth solenoid
  public static int Solenoid4Port2 = 8;     //TODO Check the second port of the fourth solenoid

  // IR sensor ports
  public static int irLeftPort1 = 1;  //TODO Check the port of this left side IR sensor
  public static int irLeftPort2 = 2;  //TODO Check the port of this left side IR sensor
  public static int irLeftPort3 = 3;  //TODO Check the port of this left side IR sensor
  public static int irRightPort1 = 5; //TODO Check the port of this right side IR sensor
  public static int irRightPort2 = 6; //TODO Check the port of this right side IR sensor
  public static int irRightPort3 = 7; //TODO Check the port of this right side IR sensor

  //cargo ports
  public static int cargoIntakePort1 = 0; //TODO Check the device ID of the first cargo intake motor
  public static int cargoIntakePort2 = 0; //TODO Check the device ID of the second cargo intake motor
  public static int cargoRetractPort = 0; //TODO Check the device ID of the retraction cargo intake motor
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

  //DriveTrainPIDTarget
  public static double RightEncoderTarget = 0;
  public static double LeftEncoderTarget = 0;
  

  /* Motors */
  //Drive motors
  public static WPI_TalonSRX LeftFrontMotor = new WPI_TalonSRX(lFrontMotorPort);
  public static WPI_TalonSRX LeftBackMotor = new WPI_TalonSRX(lBackMotorPort);
  public static WPI_TalonSRX RightFrontMotor = new WPI_TalonSRX(rFrontMotorPort);
  public static WPI_TalonSRX RightBackMotor = new WPI_TalonSRX(rBackMotorPort);
  public static Servo leftDriverCameraServo = new Servo(driverCameraServoPort1);
  public static Servo rightDriverCameraServo = new Servo(driverCameraServoPort2);

  //elevator motors
  public static CANSparkMax elevatorMotor = new CANSparkMax(elevatorPort, MotorType.kBrushless);

  //hatch solenoids
  public static DoubleSolenoid HatchPiston = new DoubleSolenoid(Solenoid1Port1, Solenoid1Port2);
  public static DoubleSolenoid HatchPiston2 = new DoubleSolenoid(Solenoid2Port1, Solenoid2Port2);
  public static DoubleSolenoid ReleaseHatchPiston1 = new DoubleSolenoid(Solenoid3Port1, Solenoid3Port2);
  public static DoubleSolenoid ReleaseHatchPiston2 = new DoubleSolenoid(Solenoid4Port1, Solenoid4Port2);

  //cargo intake 
  public static WPI_TalonSRX cargoIntakeMotor1 = new WPI_TalonSRX(cargoIntakePort1);
  public static WPI_TalonSRX cargoIntakeMotor2 = new WPI_TalonSRX(cargoIntakePort2);
  public static WPI_TalonSRX cargoRetractMotor = new WPI_TalonSRX(cargoRetractPort);
  
  //cargo outtake
  public static WPI_TalonSRX cargoOuttakeMotor = new WPI_TalonSRX(cargoOuttakePort);

  //cargo sensors

  /* Sensors */
  //drive sensors
  public static Encoder RightEncoder = new Encoder(rEncoderPort1, rEncoderPort2);
  public static Encoder LeftEncoder = new Encoder(lEncoderPort1, lEncoderPort2);
  public static UsbCamera leftCamera;
  public static UsbCamera rightCamera;
  public static VideoSink server;
  
  //Ultrasonic Initiation
  public static Ultrasonic ultrasonicLeftOne = new Ultrasonic(ultrasonicLeftOneTrigger, ultrasonicLeftOneEcho);
  public static Ultrasonic ultrasonicLeftTwo = new Ultrasonic(ultrasonicLeftTwoTrigger, ultrasonicLeftTwoEcho);
  public static Ultrasonic ultrasonicRightOne = new Ultrasonic(ultrasonicRightOneTrigger, ultrasonicRightOneEcho);
  public static Ultrasonic ultrasonicRightTwo = new Ultrasonic(ultrasonicRightTwoTrigger, ultrasonicRightTwoEcho);

  //elevator sensors
  public static DigitalInput elevatorBottomLimit = new DigitalInput(elevatorBottomLimitPort);
  public static CANEncoder elevatorEncoder = new CANEncoder(elevatorMotor);
  public static CANPIDController elevatorController = new CANPIDController(elevatorMotor);

  //IR sensors
  public static DigitalInput irLeft1 = new DigitalInput(irLeftPort1);
  public static DigitalInput irLeft2 = new DigitalInput(irLeftPort2);
  public static DigitalInput irLeft3 = new DigitalInput(irLeftPort3);
  public static DigitalInput irRight1 = new DigitalInput(irRightPort1);
  public static DigitalInput irRight2 = new DigitalInput(irRightPort2);
  public static DigitalInput irRight3 = new DigitalInput(irRightPort3);

  //gyroscope 
  //TODO ProbablyanAsian: change to PigeonIMU

  /* Variables */
  //drive variables
  public static int rightDriverAxis = 5; 
  public static int leftDriverAxis = 1; 
  public static int rightAngle; //TODO Check this on the servo 
  public static int backwardAngle; //TODO Check this on the servo 
  public static int forwardAngle; //TODO Check this on the servo 
  public static int leftAngle; //TODO Check this on the servo 

  //elevator variables
  public static double elevatorSpeed = 0.3; //Temporary elevator speed. //TODO Check power requirement.
  public static int elevatorEncoderMaxLimit = 100; //TODO check this upper limit on the real robot 
  //This is the maximum encoder ticks allowed from the bottom upwards.

  public static int rocketlevel1; //TODO find the rocket heights in encoder ticks //TODO Sanjana: Change to an Array.
  public static int rocketLevel2; //TODO find the rocket heights in encoder ticks 
  public static int rocketLevel3; //TODO find the rocket heights in encoder ticks 
  public static int rocketLevel4; //TODO find the rocket heights in encoder ticks
  public static int rocketLevel5; //TODO find the rocket heights in encoder ticks 
  public static int rocketLevel6; //TODO find the rocket heights in encoder ticks 
 
  
  //hatch variables
  public static int hatchReleaseTimeout = 2; //TODO Change this

  //cargo variables
  public static double cargoIntakeSpeed = 0.5; //TODO Check
  public static double cargoReleaseSpeed = 0.5; //TODO Test on the real robot
  public static double cargoRetractSpeed = 0.5; //TODO Test on the real robot
  public static double cargoOuttakeSpeed = 0.3; //TODO check this speed with the real robot

  //Line targets
  public static int encoderErrorTolerance = 4; //in encoder ticks //TODO change this.
  public static int ultrasonicErrorTolerance = 33; // in millimeters. //TODO change this.

  public static int halfIRDistance = 3; //in ticks, from the middle between the sensors. //TODO change this. //TODO William: check encoder Ratios.
  public static int IRDistance = 7; // in ticks, distance between 2 sensors //TODO, check to make sure.
  public static int oneInchEncoder = 4; 

  //DO NOT CHANGE WHTHOUT ASKING 
  public static int[] lastLeftOne = new int[2];
  public static int[] lastLeftThree = new int[2];

  public static int[] lastRightOne = new int[2];
  public static int[] lastRightThree = new int[2];

  public static int maxReliableEncoder = 20; //currently around 5 inches //maximum distance we can trust the last known line encoder position to stay valid.
  public static int maxUltrasonicDist = 457; //Defined in MMs, currently around 13 inches
  //No touchy either I(CargoAutoCode) need these 
  public static enum IRState {
    IDLE, TRUE, WAIT;
  }

  public static IRState curIRStateLeftOne;
  public static int counterLeftOne = 0;
  public static IRState curIRStateLeftTwo;
  public static int counterLeftTwo = 0;
  public static IRState curIRStateLeftThree;
  public static int counterLeftThree = 0;
  public static IRState curIRStateRightOne;
  public static int counterRightOne = 0;
  public static IRState curIRStateRightTwo;
  public static int counterRightTwo = 0;
  public static IRState curIRStateRightThree;
  public static int counterRightThree = 0;


  //driver joystick button numbers

  public static int retractCargoIntakeButtonNumber = 2;
  public static int releaseCargoIntakeButtonNumber = 3;

  //operator board button numbers

  public static int cancelAutoSafetyButtonNumber = 0; //TODO Check Button Number
  public static int elevatorDownButtonNumber = 0; //TODO Check Button Number
  public static int cargoOuttakeLeftButtonNumber = 0; //TODO Check Button Number
  public static int cargoOuttakeRightButtonNumber = 0; //TODO Check Button Number
  public static int elevatorPresetButtonNumber = 0; //TODO Check Button Number
  public static int elevatorUpButtonNumber = 0; //TODO Check Button Number
  public static int intakeButtonNumber = 0; //TODO Check Button Number
  public static int hatchReleaseButtonNumber = 0; //TODO Check Button Number
  public static int hatchMechanismSwitchNumber = 0; //TODO Check Button Number
  public static int hatchAutoButtonNumber = 0; //TODO check button number
  public static int cargoOuttakeAutoButtonNumber = 0; //TODO check button number

  //Networktables for vision
  public static NetworkTable visionTable = NetworkTableInstance.getDefault().getTable("vision");

  //operator board values for the six position switch 
  //DO NOT MESS WITH IT!
  public static double[] rocketHatchLevel1 = {-1.00, -0.7};
  public static double[] rocketCargoLevel2 = {-0.69, -0.2};
  public static double[] rocketHatchLevel3 = {-0.19, 0.15};
  public static double[] rocketCargoLevel4 = {0.16, 0.4};
  public static double[] rocketHatchLevel5 = {0.41, 0.6};
  public static double[] rocketCargoLevel6 = {0.61, 0.85};
  public static double[] nothingSelected = {0.86, 1.0};
}
