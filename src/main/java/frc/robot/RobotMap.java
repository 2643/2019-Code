/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.*;
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
  
  /* Ports */
  //drive ports
  static int lFrontMotorPort = 0;   //TODO
  static int lBackMotorPort = 0;    //TODO
  static int rFrontMotorPort = 0;   //TODO
  static int rBackMotorPort = 0;    //TODO
  static int rEncoderPort1 = 0;     //TODO
  static int rEncoderPort2 = 1;     //TODO
  static int lEncoderPort1 = 0;     //TODO
  static int lEncoderPort2 = 1;     //TODO

  //elevator ports
  static int elevatorPort = 0;      //TODO
  static int elevatorSlavePort = 0; //TODO

  //solenoid ports
  static int Solenoid1Port1 = 1;     //TODO
  static int Solenoid1Port2 = 2;     //TODO
  static int Solenoid2Port1 = 3;     //TODO
  static int Solenoid2Port2 = 4;     //TODO

  //hatch ports 
  static int HatchMotorPort = 3;    //TODO
  public static int HatchIRSensorPort = 0; //TODO

  //carriage ports
  static int carriageMotorPort = 0;
  public static int carriagePotPort = 0;

  // IR sensor ports
  public static int irLeftPort1 = 1;
  public static int irLeftPort2 = 2;
  public static int irLeftPort3 = 3;
  public static int irLeftPort4 = 4;
  public static int irRightPort1 = 5;
  public static int irRightPort2 = 6;
  public static int irRightPort3 = 7;
  public static int irRightPort4 = 8;

  //cargo ports
  static int cargoIntakePort1 = 0; //TODO
  static int cargoIntakePort2 = 0; //TODO
  static int cargoRetractPort = 0; //TODO

  /* Motors */
  //Drive motors
  static WPI_TalonSRX lFrontMotor = new WPI_TalonSRX(lFrontMotorPort);
  static WPI_TalonSRX lBackMotor = new WPI_TalonSRX(lBackMotorPort);
  static WPI_TalonSRX rFrontMotor = new WPI_TalonSRX(rFrontMotorPort);
  static WPI_TalonSRX rBackMotor = new WPI_TalonSRX(rBackMotorPort);

  //elevator motors
  static WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(elevatorPort);
  static WPI_TalonSRX elevatorSlaveMotor = new WPI_TalonSRX(elevatorSlavePort);

  //hatch motors/solenoids
  static WPI_TalonSRX HatchTalon = new WPI_TalonSRX(HatchMotorPort);
  static DoubleSolenoid HatchPiston = new DoubleSolenoid(Solenoid1Port1, Solenoid1Port2);
  static DoubleSolenoid HatchPiston2 = new DoubleSolenoid(Solenoid2Port1, Solenoid2Port2);

  //carriage
  static WPI_TalonSRX carriageMotor = new WPI_TalonSRX(carriageMotorPort);

  //cargo
  static WPI_TalonSRX cargoIntakeMotor1 = new WPI_TalonSRX(cargoIntakePort1);
  static WPI_TalonSRX cargoIntakeMotor2 = new WPI_TalonSRX(cargoIntakePort2);
  static WPI_TalonSRX cargoRetractMotor = new WPI_TalonSRX(cargoRetractPort);

  /* Sensors */
  //drive sensors
  public static Encoder rEncoder = new Encoder(rEncoderPort1, rEncoderPort2);
  public static Encoder lEncoder = new Encoder(lEncoderPort1, lEncoderPort2);
  
  //elevator sensors
  public static DigitalInput elevatorBottomLimit = new DigitalInput(0);

  //hatch sensors
  public static DigitalInput HatchIRSwitch = new DigitalInput(HatchIRSensorPort);

  //carriage sensors
  public static int carriagePotOffset = 0; //Must be before the next line
  public static Potentiometer carriagePot = new AnalogPotentiometer(carriagePotPort, 3600, carriagePotOffset);

  //IR sensors
  public static DigitalInput irLeft1 = new DigitalInput(irLeftPort1);
  public static DigitalInput irLeft2 = new DigitalInput(irLeftPort2);
  public static DigitalInput irLeft3 = new DigitalInput(irLeftPort3);
  public static DigitalInput irLeft4 = new DigitalInput(irLeftPort4);
  public static DigitalInput irRight1 = new DigitalInput(irRightPort1);
  public static DigitalInput irRight2 = new DigitalInput(irRightPort2);
  public static DigitalInput irRight3 = new DigitalInput(irRightPort3);
  public static DigitalInput irRight4 = new DigitalInput(irRightPort4);

  /* Variables */
  //drive varibles
  public static int rightDriverAxis = 1; //TODO Change Later
  public static int leftDriverAxis = 5; //TODO Change Later

  //elevator variables
  static public double elevatorSpeed = 0.3; //Temporary elevator speed. TODO elevator PIDS will have to be implemented.
  static public int elevatorEncoderMaxLimit = 100; //this is the maximum encoder ticks allowed from the bottom upwards.
  
  //hatch variables
  public static double hatchDownSpeed = 0; //TODO
  public static double hatchUpSpeed = 0; //TODO

  //carriage variables
  public static double carriageMotorSpeed = 0.15; //Carriage motor speed preset should probably implement PIDS
  public static int carriageClockwiseMax = 2000; //TODO find out actual value of carriageClockwiseMax
  public static int carriageCounterclockwiseMin = 500; //TODO find out actual value of carriageCounterclockwiseMax

  //cargo variables
  public static double cargoIntakeSpeed = 0.5; //TODO Check
}
