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
import frc.robot.subsystems.CargoIntake;

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


  //driver joystick and buttons
  Joystick driverStick = new Joystick(0);
  JoystickButton retractCargoIntake = new JoystickButton(driverStick, RobotMap.retractCargoIntakeButtonNumber);
  JoystickButton releaseCargoIntake = new JoystickButton(driverStick, RobotMap.releaseCargoIntakeButtonNumber);

  //operator board and buttons 
  Joystick operatorBoard = new Joystick(1);
  JoystickButton cancelAutoSafety = new JoystickButton(operatorBoard, RobotMap.cancelAutoSafetyButtonNumber);
  JoystickButton carriageCenter = new JoystickButton(operatorBoard, RobotMap.carriageCenterButtonNumber);
  JoystickButton elevatorDown = new JoystickButton(operatorBoard, RobotMap.elevatorDownButtonNumber);
  JoystickButton cargoOuttakeLeft = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeLeftButtonNumber);
  JoystickButton carriageLeft = new JoystickButton(operatorBoard, RobotMap.carriageLeftButtonNumber);
  JoystickButton cargoOuttakeRight = new JoystickButton(operatorBoard, RobotMap.cargoOuttakeRightButtonNumber);
  JoystickButton carriageRight = new JoystickButton(operatorBoard, RobotMap.carriageRightButtonNumber);
  JoystickButton elevatorPreset = new JoystickButton(operatorBoard, RobotMap.elevatorPresetButtonNumber);
  JoystickButton elevatorUp = new JoystickButton(operatorBoard, RobotMap.elevatorUpButtonNumber);
  JoystickButton intake = new JoystickButton(operatorBoard, RobotMap.intakeButtonNumber);
  JoystickButton hatchRelease = new JoystickButton(operatorBoard, RobotMap.hatchReleaseButtonNumber);
  JoystickButton hatchMechanismSwitch = new JoystickButton(operatorBoard, RobotMap.hatchMechanismSwitchNumber);
  
  //six position switch levels 
  //First level of the rocket for the hatch 
  
  
  
  public OI(){
    //DRIVER STICK 
    retractCargoIntake.whenPressed(new RetractCargoIntake());
    releaseCargoIntake.whenPressed(new ReleaseCargoIntake());

    //OPERATOR BOARD
    //safety button
    cancelAutoSafety.cancelWhenPressed(new HatchAuto()); //TODO cancel the auto routines; THAT ARE NOT WRITTEN YET!!!!
   
    //elevator buttons
    elevatorDown.whenPressed(new ElevatorDown());
    elevatorUp.whenPressed(new ElevatorUp());
    elevatorPreset.whenPressed(new ElevatorTo()); //TODO Finish when things are soldered

    //carriage buttons
    carriageCenter.whenPressed(new CarriageCenter()); //TODO create CarriageCenter command
    carriageLeft.whenPressed(new CarriageClockwise()); //TODO check this
    carriageRight.whenPressed(new CarriageCounterclockwise()); //TODO Check this
    
    //cargo outtake buttons
    //cargoOUttakeAuto
    cargoOuttakeRight.whenPressed(new CargoOuttakeRight());
    cargoOuttakeLeft.whenPressed(new CargoOuttakeLeft());

    //cargo intake button
    intake.whenPressed(new IntakeCargo());
    
    //hatch buttons
    //hatchAuto
    /*
    if(hatchRelease.get() == true){
      hatchRelease.whenPressed(new ReleaseHatch());
      if(hatchMechanismSwitch.get() == true)
        hatchMechanismSwitch.whileHeld(new ExtendHatch());
    }else{
      hatchMechanismSwitch.whenReleased(new RetractHatch());
    }
    int hatchThing = 0;

    if(hatchMechanismSwitch.get() == false){
      hatchThing = 0;
    } else if(hatchMechanismSwitch.get() == true){
      hatchThing = 1;
    }

    switch(hatchThing){
      case 0:
        Robot.hatch.mechanismPistonOut();
        Robot.hatch.hatchPistonOut();
        Robot.hatch.hatchPistonIn();
        Robot.hatch.mechanismPistonIn();
        break;
      case 1:
        Robot.hatch.hatchPistonOut();
        Robot.hatch.hatchPistonIn();
        Robot.hatch.mechanismPistonIn();
        break;
    } */
  }

  //Creating the joystick
  public Joystick getDriverStick(){
    return driverStick;
  }

  //Creating the Operator Board
  public Joystick getOperatorBoard(){
    return operatorBoard;
  }
}
