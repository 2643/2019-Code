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
  Joystick driverStick = new Joystick(0);
  JoystickButton retractCargoIntake = new JoystickButton(driverStick, RobotMap.retractCargoIntakeButtonNumber);
  JoystickButton releaseCargoIntake = new JoystickButton(driverStick, RobotMap.releaseCargoIntakeButtonNumber);

  // operator board and buttons
  Joystick operatorBoard = new Joystick(1);
  JoystickButton cancelAutoSafety = new JoystickButton(operatorBoard, RobotMap.cancelAutoSafetyButtonNumber);
  JoystickButton elevatorDown = new JoystickButton(operatorBoard, RobotMap.elevatorDownButtonNumber);
  JoystickButton cargoOuttakeLeft = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeLeftButtonNumber);
  JoystickButton cargoOuttakeRight = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeRightButtonNumber);
  JoystickButton elevatorPreset = new JoystickButton(operatorBoard, RobotMap.elevatorPresetButtonNumber);
  JoystickButton elevatorUp = new JoystickButton(operatorBoard, RobotMap.elevatorUpButtonNumber);
  JoystickButton intake = new JoystickButton(operatorBoard, RobotMap.intakeButtonNumber);
  JoystickButton hatchRelease = new JoystickButton(operatorBoard, RobotMap.hatchReleaseButtonNumber);
  JoystickButton hatchMechanismSwitch = new JoystickButton(operatorBoard, RobotMap.hatchMechanismSwitchNumber);
  JoystickButton hatchAuto = new JoystickButton(operatorBoard, RobotMap.hatchAutoButtonNumber);
  JoystickButton cargoOuttakeAuto = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeAutoButtonNumber);

  // six position switch levels
  // First level of the rocket for the hatch
  double sixPositionSwitchReading = Math.round(operatorBoard.getRawAxis(2) * 100) / 100;

  public OI() {

    // DRIVER STICK
    retractCargoIntake.whenPressed(new RetractCargoIntake()); //TODO implement using current
    releaseCargoIntake.whenPressed(new ReleaseCargoIntake());

    if(driverStick.getPOV() == 0){
      Robot.driverCameras.setRightServoAngle(RobotMap.forwardAngle);
      Robot.driverCameras.setCameraSource(RobotMap.rightCamera);
    }else if(driverStick.getPOV() == 90){
      Robot.driverCameras.setCameraSource(RobotMap.rightCamera);
      Robot.driverCameras.setRightServoAngle(RobotMap.rightAngle);
    }else if(driverStick.getPOV() == 180){  
      Robot.driverCameras.setLeftServoAngle(RobotMap.backwardAngle);
      Robot.driverCameras.setCameraSource(RobotMap.leftCamera);
    }else if(driverStick.getPOV() == 270){
      Robot.driverCameras.setLeftServoAngle(RobotMap.leftAngle);
      Robot.driverCameras.setCameraSource(RobotMap.leftCamera);
    }

    //OPERATOR BOARD
    //safety button
    cancelAutoSafety.cancelWhenPressed(new HatchAuto()); //TODO cancel the auto routines; THAT ARE NOT WRITTEN YET!!!!

    //auto functions 
    hatchAuto.whileHeld(new HatchAuto());
    cargoOuttakeAuto.whileHeld(new CargoLineAuto());
    
    //elevator buttons
    elevatorDown.whenPressed(new ElevatorDown());
    elevatorUp.whenPressed(new ElevatorUp());
    

    if(sixPositionSwitchReading >= RobotMap.rocketHatchLevel1[0] && sixPositionSwitchReading <= RobotMap.rocketHatchLevel1[1]){
        elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketlevel1));
    }else if(sixPositionSwitchReading >= RobotMap.rocketCargoLevel2[0] && sixPositionSwitchReading <= RobotMap.rocketCargoLevel2[1]){
      elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketLevel2)); 
    }else if(sixPositionSwitchReading >= RobotMap.rocketHatchLevel3[0] && sixPositionSwitchReading <= RobotMap.rocketHatchLevel3[1]){
      elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketLevel3)); 
    }else if(sixPositionSwitchReading >= RobotMap.rocketCargoLevel4[0] && sixPositionSwitchReading <= RobotMap.rocketCargoLevel4[1]){
      elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketLevel4)); 
    }else if(sixPositionSwitchReading >= RobotMap.rocketHatchLevel5[0] && sixPositionSwitchReading <= RobotMap.rocketHatchLevel5[1]){
      elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketLevel5)); 
    }else if(sixPositionSwitchReading >= RobotMap.rocketCargoLevel6[0] && sixPositionSwitchReading <= RobotMap.rocketCargoLevel6[1]){
      elevatorPreset.whenPressed(new ElevatorTo(RobotMap.rocketLevel6)); 
    } // TODO Govind, go optimize.

    // cargoOUttakeAuto
    cargoOuttakeRight.whenPressed(new CargoOuttakeRight());
    cargoOuttakeLeft.whenPressed(new CargoOuttakeLeft());
    

    // cargo intake button
    intake.whenPressed(new IntakeCargo());

    // hatch buttons
    hatchRelease.whenPressed(new ReleaseHatch());
    hatchMechanismSwitch.whileHeld(new ExtendHatch());
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
