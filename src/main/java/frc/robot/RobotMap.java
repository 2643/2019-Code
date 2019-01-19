/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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

  //update variables/input ports
  static WPI_TalonSRX elevator = new WPI_TalonSRX(0);
  static WPI_TalonSRX elevatorSlave = new WPI_TalonSRX(0);
  static public double elevatorSpeed = 0.3;
  public int elevatorEncoderLimit = 100;
  static public DigitalInput elevatorBottomLimit = new DigitalInput(0);

  public static int HatchMotor = 0;
  public static double HatchMotorSpeed = 0;
  public static int HatchLimitSwitchPort = 0; //TODO change this later
  

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  static int SolenoidPort1 = 1; //TODO Change this port once you get it.
  static int SolenoidPort2 = 2; //TODO Change this port once you get it.
  static int CompressorPort = 0; //TODO Change this port once you get it.
  static int HatchMotorPort = 3; //TODO Change this port once you get it.
  static int rEncoderPort1 = 0; //TODO Change this port once you get it.
  static int rEncoderPort2 = 1; //TODO Change this port once you get it.
  static int lEncoderPort1 = 0; //TODO Change this port once you get it.
  static int lEncoderPort2 = 1; //TODO Change this port once you get it.


  static DoubleSolenoid HatchPiston = new DoubleSolenoid(SolenoidPort1, SolenoidPort2);
  static WPI_TalonSRX HatchTalon = new WPI_TalonSRX(HatchMotorPort);
  public static Encoder rEncoder = new Encoder(rEncoderPort1, rEncoderPort2);
  public static Encoder lEncoder = new Encoder(lEncoderPort1, lEncoderPort2);
  public static DigitalInput HatchLimitSwitch = new DigitalInput(HatchLimitSwitchPort);

}
