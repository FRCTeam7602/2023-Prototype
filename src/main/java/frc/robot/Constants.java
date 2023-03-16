// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
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
  public static final float PINCHER_MOVE_VELOCITY = 0.5f;
  public static final float PINCHER_CONTROL_SCALING = 5.0f;

  // Encoder limits and stops
  public static class Pincher {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 38;
    public static final int CUBE_STOP = 36;
    public static final int CONE_STOP = 37;
    public static final int READY_STOP = 10;
  }

  public static class OperatorConstants {
    public static final int JOYSTICK_PORT = 0;
    public static final int GAMEPPAD_PORT = 1;
  }
}
