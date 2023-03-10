// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmJoystick;
import frc.robot.commands.Drive;
import frc.robot.commands.ElevatorBottom;
import frc.robot.commands.ElevatorTop;
import frc.robot.commands.MoveElevator;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Arm m_arm = new Arm();
  private final Elevator m_elevator = new Elevator();
  private final DriveTrain m_driveTrain = new DriveTrain();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandJoystick m_driverController =
    new CommandJoystick(OperatorConstants.JOYSTICK_PORT);

  private final CommandXboxController m_elevatorController =
    new CommandXboxController(OperatorConstants.GAMEPPAD_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_arm.setDefaultCommand(
      new ArmJoystick(m_arm, () -> m_elevatorController.getLeftTriggerAxis(), () -> m_elevatorController.getRightTriggerAxis()));
    m_elevator.setDefaultCommand(new MoveElevator(m_elevator, () -> m_elevatorController.getHID().getPOV()));
    m_driveTrain.setDefaultCommand(
      new Drive(m_driveTrain, () -> -m_driverController.getY(), () -> m_driverController.getTwist())
    );
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    //m_elevatorController.leftStick(new )
    //m_elevatorController.getRawAxis(1)
    m_elevatorController.axisGreaterThan(1, 0.5).onTrue(new ElevatorBottom(m_elevator, () -> m_elevatorController.getRawAxis(1)));
    m_elevatorController.axisLessThan(1, -0.5).onTrue(new ElevatorTop(m_elevator, () -> m_elevatorController.getRawAxis(1)));
    
;  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}
