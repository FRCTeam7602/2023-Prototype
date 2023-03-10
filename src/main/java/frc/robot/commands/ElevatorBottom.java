// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorBottom extends CommandBase {
  /** Creates a new ElevatorBottom. */

  private final Elevator m_elevator;
  private final DoubleSupplier m_leftJoystick;

  // TODO - replace me with use of actual encoder; this was added to get
  // initial debugging when setting up the triggers
  private int pseudoEncoder;

  public ElevatorBottom(Elevator elevator, DoubleSupplier leftJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = elevator;
    m_leftJoystick = leftJoystick;
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Elevator initialize");
    pseudoEncoder = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_leftJoystick.getAsDouble() > 0.8) {
      m_elevator.elevatorBottom();
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
    // TODO - probably want to be watching both a physical limit switch
    // as well as the range finder
    return pseudoEncoder++ > 5;
  }
}
