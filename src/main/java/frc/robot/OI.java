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

  boolean twoPressed = false; 
  boolean fourPressed = true; 

  // driver joystick and buttons
  Joystick driverStick = new Joystick(0);
  JoystickButton slowMode = new JoystickButton(driverStick, RobotMap.slowModeButtonNumber);
  JoystickButton hatchAuto = new JoystickButton(driverStick, RobotMap.hatchAutoButtonNumber);
  JoystickButton cargoOuttakeAuto = new JoystickButton(driverStick, RobotMap.cargoOuttakeAutoButtonNumber);

  // operator board and buttons
  Joystick operatorBoard = new Joystick(1);
  JoystickButton elevatorDown = new JoystickButton(operatorBoard, RobotMap.elevatorDownButtonNumber);
  JoystickButton cargoOuttakeLeft = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeLeftButtonNumber);
  JoystickButton cargoOuttakeRight = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeRightButtonNumber);
  JoystickButton elevatorPreset = new JoystickButton(operatorBoard, RobotMap.elevatorPresetButtonNumber);
  JoystickButton elevatorUp = new JoystickButton(operatorBoard, RobotMap.elevatorUpButtonNumber);
  JoystickButton intake = new JoystickButton(operatorBoard, RobotMap.intakeButtonNumber);
  JoystickButton hatchIn = new JoystickButton(operatorBoard, RobotMap.hatchInButton);
  JoystickButton hatchOut = new JoystickButton(operatorBoard, RobotMap.hatchOutButton);
  JoystickButton calibrate = new JoystickButton(operatorBoard, RobotMap.calibrateButtonNumber);
  JoystickButton outtakeCargo = new JoystickButton(operatorBoard, RobotMap.outtakeCargoButtonNumber);

  // six position switch levels
  // First level of the rocket for the hatch
  double sixPositionSwitchReading = Math.round(operatorBoard.getRawAxis(2) * 100) / 100;

  public OI() {

    // DRIVER STICK
    slowMode.toggleWhenPressed(new SlowTankDrive());
    
    Robot.driverCameras.getServer().setSource(RobotMap.frontCamera);
    Robot.driverCameras.getServer().setSource(RobotMap.frontCamera);

    //auto functions 
    //hatchAuto.whileHeld(new HatchAutoAlign());
    cargoOuttakeAuto.whileHeld(new CargoLineAuto());

    
    //OPERATOR BOARD
    //calibrate button 
    //calibrate.whenPressed(new Calibrate());
    
    //elevator buttons
    elevatorDown.whileHeld(new ElevatorDown());
    elevatorUp.whileHeld(new ElevatorUp());
    
    // for(int i = 1; i < RobotMap.presetDialValues.length-1; i++) {
    //   if(sixPositionSwitchReading > RobotMap.presetDialValues[i] && sixPositionSwitchReading < RobotMap.presetDialValues[i+1]) {
    //     if(i < RobotMap.elevatorTickGoals.length)
    //     {
    //       elevatorPreset.whenPressed(new ElevatorTo(RobotMap.elevatorTickGoals[i]));
    //     }
    //     else {
    //       System.err.println("WARNING: Elevator Position: " +i + " not implemented!");
    //     }
    //     break;
    //   }
    // }

    // cargoOuttakeAuto
    cargoOuttakeRight.whileHeld(new CargoOuttakeRight());
    cargoOuttakeLeft.whileHeld(new CargoOuttakeLeft());
    

    // cargo intake button
    intake.whileHeld(new IntakeCargo());
    outtakeCargo.whileHeld(new OuttakeCargo());

    // hatch buttons
    hatchIn.whileHeld(new HatchIn());
    hatchOut.whileHeld(new HatchOut());

    //Elevator to top
    elevatorPreset.whenPressed(new ElevatorTo());
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