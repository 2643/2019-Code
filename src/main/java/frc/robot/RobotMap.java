/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;


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
  
  /**Porst */
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
  static int SolenoidPort1 = 1;     //TODO
  static int SolenoidPort2 = 2;     //TODO

  //hatch ports 
  static int HatchMotorPort = 3;    //TODO
  public static int HatchLimitSwitchPort = 0; //TODO

  /**Motors */
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
  static DoubleSolenoid HatchPiston = new DoubleSolenoid(SolenoidPort1, SolenoidPort2);

  /**Sensors */
  //drive sensors
  public static Encoder rEncoder = new Encoder(rEncoderPort1, rEncoderPort2);
  public static Encoder lEncoder = new Encoder(lEncoderPort1, lEncoderPort2);
  
  //elevator sensors
  static public DigitalInput elevatorBottomLimit = new DigitalInput(0);

  //hatch sensors
  public static DigitalInput HatchLimitSwitch = new DigitalInput(HatchLimitSwitchPort);

  //TODO update all variables/input ports
  static public double elevatorSpeed = 0.3;
  static public int elevatorEncoderLimit = 100; //these are encoder ticks
 
  public static double HatchMotorSpeed = 0;
}
