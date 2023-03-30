// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * Our robot-wide constant with some more specific groupings like for limits
 * or Operator Inputs.
 */
public final class Constants {
  //Drive Controllers
  public static final int OMNI_LEFT_CONTROLLER = 1;
  public static final int OMNI_RIGHT_CONTROLLER = 2;
  public static final int DRIVE_LEFT_CONTROLLER = 3;
  public static final int DRIVE_RIGHT_CONTROLLER = 4;

  // Elevator and pincher controllers
  public static final int ELEVATOR_CONTROLLER = 5;
  public static final int PINCHER_CONTROLLER = 6;
  public static final int ARM_CONTROLLER = 7;

  // Current limits to try to help avoid brownouts
  public static final int DRIVE_CURRENT_LIMIT = 55;
  public static final int PINCHER_CURRENT_LIMIT = 35;

  // Sensors
  public static final int ELEVATOR_SENSOR_ECHO_PORT = 7;
  public static final int ELEVATOR_SENSOR_PING_PORT = 6;

  // Velocity and scaling values for motors
  public static final float ARM_MOVE_VELOCITY = 0.2f;
  public static final float ARM_SLOW_SCALING = 1.0f;
  public static final float ELEVATOR_MOVE_VELOCITY = 0.2f;
  public static final float ELEVATOR_SLOW_SCALING = 1.0f;
  public static final float PINCHER_MOVE_VELOCITY = 0.3f;
  public static final float PINCHER_CONTROL_SCALING = 12.0f;

  // Arm limits
  public static class Arm {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 20;
  }

  // Elevator limits and stops
  public static class Elevator {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 60;
  }

  // Pincher limits and stops
  public static class Pincher {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 23;
    public static final int CUBE_STOP = 36;
    public static final int CONE_STOP = 37;
    public static final int READY_STOP = 10;
  }

  // Lights
  public static class Lights {
    // the total number of LEDs connected since we control each individually
    public static final int LED_COUNT = 60;
    // note that this port is a PWM port in RoboRio (not a CAN address)
    public static final int PORT = 9;
    // the light colors are RGB values 0-255
    public static final int[] COLOR_PURPLE = {255, 0, 255};
    public static final int[] COLOR_YELLOW = {255, 240, 0};
  }

  // Controllers
  public static class OperatorConstants {
    public static final int JOYSTICK_PORT = 0;
    public static final int GAMEPPAD_PORT = 1;

    // gamepad trigger axis 4 should be right / left while
    // axis 5 should be forward / back on right stick
    public static final int ARM_TRIGGER_AXIS = 5;
    public static final int ELEVATOR_TRIGGER_AXIS = 1;
    public static final int PINCHER_CLOSE_AXIS = 3;
    public static final int PINCHER_OPEN_AXIS = 2;
  }
}
