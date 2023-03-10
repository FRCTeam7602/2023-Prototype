// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorTop extends CommandBase {
  /** Creates a new ElevatorTop. */

  private final Elevator m_elevator;
  private final DoubleSupplier m_leftJoystick;
  private int pseudoEncoder;

  public ElevatorTop(Elevator elevator, DoubleSupplier leftJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = elevator;
    m_leftJoystick = leftJoystick;
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pseudoEncoder = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_leftJoystick.getAsDouble() < -0.8 ){
      m_elevator.elevatorTop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pseudoEncoder++ > 5;
  }
}
