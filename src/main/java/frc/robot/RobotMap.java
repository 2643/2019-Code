/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
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

  //update variables
  static WPI_TalonSRX Elevator = new WPI_TalonSRX(0);
  static WPI_TalonSRX ElevatorSlave = new WPI_TalonSRX(0);
  static int ElevatorLimitSwitch = 0;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  static int SolenoidPort1 = 1; //TODO Change this port once you get it.
  static int SolenoidPort2 = 2; //TODO Change this port once you get it.
  static int CompressorPort = 0; //TODO Change this port once you get it.
  static DoubleSolenoid HatchPiston = new DoubleSolenoid(SolenoidPort1, SolenoidPort2);
  static Compressor Compressor = new Compressor(CompressorPort);
}
