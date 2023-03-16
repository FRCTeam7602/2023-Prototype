// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.OperatorConstants.GAMEPPAD_PORT;
import static frc.robot.Constants.OperatorConstants.JOYSTICK_PORT;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClosePinchers;
import frc.robot.commands.Drive;
import frc.robot.commands.ElevatorBottom;
import frc.robot.commands.ElevatorTop;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.GetCube;
import frc.robot.commands.GetStandingCone;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.OpenPinchers;
import frc.robot.commands.ReadyPinchers;
import frc.robot.commands.RetractArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Pincher;

/**
 * The standard RobotContainer where the bulk of the robot is declared.
 */
public class RobotContainer {
  private final Arm m_arm = new Arm();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Elevator m_elevator = new Elevator();
  private final Pincher m_pincher = new Pincher();

  private final CommandJoystick m_driverController = new CommandJoystick(JOYSTICK_PORT);
  private final CommandXboxController m_elevatorController = new CommandXboxController(GAMEPPAD_PORT);

  public RobotContainer() {
    configureBindings();

    m_driveTrain.setDefaultCommand(
      new Drive(m_driveTrain, () -> -m_driverController.getY(), () -> m_driverController.getTwist())
    );
  }

  /**
   * The joystick is already bound as it is used in the default command for the
   * drive train.  The binding here are for everything but the default drive.
   */
  private void configureBindings() {

    // elevator
    m_elevatorController.axisGreaterThan(1, 0.5).onTrue(new ElevatorBottom(m_elevator, () -> m_elevatorController.getRawAxis(1)));
    m_elevatorController.axisLessThan(1, -0.5).onTrue(new ElevatorTop(m_elevator, () -> m_elevatorController.getRawAxis(1)));
    // TODO - think default command not ideal for Elevator but leaving for now
    // to try it out; maybe change over to separate up / down commands
    m_elevator.setDefaultCommand(new MoveElevator(m_elevator, () -> m_elevatorController.getHID().getPOV()));

    // arm
    m_elevatorController.axisGreaterThan(4, .5).onTrue(new ExtendArm(m_arm, () -> m_elevatorController.getRawAxis(4)));
    m_elevatorController.axisLessThan(4, -0.5).onTrue(new RetractArm(m_arm, () -> m_elevatorController.getRawAxis(4)));

    // pincher
    m_elevatorController.axisGreaterThan(2, .5).onTrue(new OpenPinchers(m_pincher, () -> m_elevatorController.getRawAxis(2)));
    m_elevatorController.axisLessThan(2, -0.5).onTrue(new ClosePinchers(m_pincher, () -> m_elevatorController.getRawAxis(2)));
    m_elevatorController.a().onTrue(new ReadyPinchers(m_pincher));
    m_elevatorController.b().onTrue(new GetStandingCone(m_pincher));
    m_elevatorController.x().onTrue(new GetCube(m_pincher));
  }

  /**
   * Do we have anything for auton???
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
