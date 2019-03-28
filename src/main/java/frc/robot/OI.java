/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  // driver joystick and buttons
  static Joystick driverStick = new Joystick(0);
  static JoystickButton retractCargoIntake = new JoystickButton(driverStick, RobotMap.retractCargoIntakeButtonNumber);
  static JoystickButton releaseCargoIntake = new JoystickButton(driverStick, RobotMap.releaseCargoIntakeButtonNumber);
  static JoystickButton hatchAuto = new JoystickButton(driverStick, RobotMap.hatchAutoButtonNumber);
  static JoystickButton cargoOuttakeAuto = new JoystickButton(driverStick, RobotMap.cargoOuttakeAutoButtonNumber);
  static JoystickButton hatchRelease = new JoystickButton(driverStick, RobotMap.hatchReleaseButtonNumber);

  // operator board and buttons
  static Joystick operatorBoard = new Joystick(1);
  static JoystickButton elevatorDown = new JoystickButton(operatorBoard, RobotMap.elevatorDownButtonNumber);
  static JoystickButton cargoOuttakeLeft = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeLeftButtonNumber);
  static JoystickButton cargoOuttakeRight = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeRightButtonNumber);
  static JoystickButton elevatorPreset = new JoystickButton(operatorBoard, RobotMap.elevatorPresetButtonNumber);
  static JoystickButton elevatorUp = new JoystickButton(operatorBoard, RobotMap.elevatorUpButtonNumber);
  static JoystickButton intake = new JoystickButton(operatorBoard, RobotMap.intakeButtonNumber);
  static JoystickButton hatchMechanismSwitch = new JoystickButton(operatorBoard, RobotMap.hatchMechanismSwitchNumber);
  static JoystickButton calibrate = new JoystickButton(operatorBoard, RobotMap.calibrateButtonNumber);

  // six position switch levels
  // First level of the rocket for the hatch
  double sixPositionSwitchReading = Math.round(operatorBoard.getRawAxis(2) * 100) / 100;

  public OI() {

    // DRIVER STICK
    retractCargoIntake.whileHeld(new RetractCargoIntake()); 
    releaseCargoIntake.whileHeld(new ReleaseCargoIntake());
    
    Robot.driverCameras.getServer().setSource(RobotMap.frontCamera);

    //auto functions 
    //hatchAuto.whileHeld(new HatchAuto());
    //cargoOuttakeAuto.whileHeld(new CargoLineAuto());

    
    //OPERATOR BOARD
    //calibrate button 
    //calibrate.whenPressed(new Calibrate());
    
    //elevator buttons
    elevatorDown.whileHeld(new ElevatorDown());
    elevatorUp.whileHeld(new ElevatorUp());
    
    for(int i = 1; i < RobotMap.presetDialValues.length-1; i++) {
      if(sixPositionSwitchReading > RobotMap.presetDialValues[i] && sixPositionSwitchReading < RobotMap.presetDialValues[i+1]) {
        if(i < RobotMap.elevatorTickGoals.length)
        {
          elevatorPreset.whenPressed(new ElevatorTo(RobotMap.elevatorTickGoals[i]));
        }
        else {
          System.err.println("WARNING: Elevator Position: " + i + " not implemented!");
        }
        break;
      }
    }

    // cargoOuttakeAuto
    cargoOuttakeRight.whileHeld(new CargoOuttakeRight());
    cargoOuttakeLeft.whileHeld(new CargoOuttakeLeft());
    

    // cargo intake button
    intake.whileHeld(new IntakeCargo());

    // hatch buttons
    hatchRelease.whenPressed(new ReleaseHatchPanel());
    hatchRelease.whenReleased(new RetractHatchPanel());
    hatchMechanismSwitch.whenPressed(new RetractHatch());
    hatchMechanismSwitch.whenReleased(new ExtendHatch());
  }

  // Creating the joystick
  public Joystick getDriverStick() {
    return driverStick;
  }

  // Creating the Operator Board
  public Joystick getOperatorBoard() {
    return operatorBoard;
  }
}