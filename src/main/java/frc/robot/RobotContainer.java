// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.OperatorConstants.ARM_TRIGGER_AXIS;
import static frc.robot.Constants.OperatorConstants.GAMEPPAD_PORT;
import static frc.robot.Constants.OperatorConstants.JOYSTICK_PORT;
import static frc.robot.Constants.OperatorConstants.PINCHER_CLOSE_AXIS;
import static frc.robot.Constants.OperatorConstants.PINCHER_OPEN_AXIS;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClosePinchers;
import frc.robot.commands.Drive;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.LightsOff;
import frc.robot.commands.LightsPurple;
import frc.robot.commands.LightsYellow;
import frc.robot.commands.OpenPinchers;
import frc.robot.commands.ReadyPinchers;
import frc.robot.commands.RetractArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PidElevator;
import frc.robot.subsystems.Pincher;
import frc.robot.subsystems.RioLights;

/**
 * The standard RobotContainer where the bulk of the robot is declared.
 */
public class RobotContainer {
  private final Arm m_arm = new Arm();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final PidElevator m_elevator = new PidElevator();
  private final Pincher m_pincher = new Pincher();
  private final RioLights m_lights = new RioLights();

  private final CommandJoystick m_driverController = new CommandJoystick(JOYSTICK_PORT);
  private final CommandXboxController m_elevatorController = new CommandXboxController(GAMEPPAD_PORT);

  private Command getMobilityCommand(double timeout, double speed) {
    return new RunCommand(() -> {
      m_driveTrain.drive(.5, 0);
    }, m_driveTrain).repeatedly().withTimeout(timeout);
  }

  public RobotContainer() {
    configureBindings();

    m_driveTrain.setDefaultCommand(
      new Drive(m_driveTrain, () -> -m_driverController.getY(), () -> m_driverController.getTwist())
    );
  }

  public DriveTrain getDriveTrain() {
    return m_driveTrain;
  }
  /**
   * The joystick is already bound as it is used in the default command for the
   * drive train.  The binding here are for everything but the default drive.
   */
  private void configureBindings() {

    // elevator
    // m_elevatorController.axisGreaterThan(ELEVATOR_TRIGGER_AXIS, 0.5).onTrue(new ElevatorBottom(m_elevator));
    // m_elevatorController.axisLessThan(ELEVATOR_TRIGGER_AXIS, -0.5).onTrue(new ElevatorTop(m_elevator));
    // m_elevatorController.povUp().whileTrue(new ElevatorUp(m_elevator));
    // m_elevatorController.povDown().whileTrue(new ElevatorDown(m_elevator));

    // arm
    m_elevatorController.axisGreaterThan(ARM_TRIGGER_AXIS, .5)
      .whileTrue(new ExtendArm(m_arm, () -> m_elevatorController.getRawAxis(ARM_TRIGGER_AXIS)));
    m_elevatorController.axisLessThan(ARM_TRIGGER_AXIS, -0.5)
      .whileTrue(new RetractArm(m_arm, () -> m_elevatorController.getRawAxis(ARM_TRIGGER_AXIS)));

    // pincher
    m_elevatorController.axisGreaterThan(PINCHER_OPEN_AXIS, .5)
      .whileTrue(new OpenPinchers(m_pincher, () -> m_elevatorController.getRawAxis(PINCHER_OPEN_AXIS)));
    m_elevatorController.axisGreaterThan(PINCHER_CLOSE_AXIS, 0.5)
      .whileTrue(new ClosePinchers(m_pincher, () -> m_elevatorController.getRawAxis(PINCHER_CLOSE_AXIS)));
    m_elevatorController.a().onTrue(new ReadyPinchers(m_pincher));
    m_elevatorController.b().onTrue(new LightsOff(m_lights));
    m_elevatorController.x().onTrue(new LightsPurple(m_lights));
    m_elevatorController.y().onTrue(new LightsYellow(m_lights));
  }

  /**
   * Do we have anything for auton???
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(getMobilityCommand(1, -.25), getMobilityCommand(5, .5));
  }
}
