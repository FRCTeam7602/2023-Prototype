// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pincher;

public class OpenPinchers extends CommandBase {
  /** Creates a new OpenPinchers. */

  private final Pincher m_pincher;

  public OpenPinchers(Pincher pincher) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pincher = pincher;
    addRequirements(m_pincher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}