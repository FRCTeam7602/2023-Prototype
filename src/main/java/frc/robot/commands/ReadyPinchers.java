// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pincher;

public class ReadyPinchers extends CommandBase {

  private final Pincher m_pincher;

  public ReadyPinchers(Pincher pincher) {
    m_pincher = pincher;
    addRequirements(m_pincher);
  }

  @Override
  public void initialize() {
    m_pincher.ready();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    if (!interrupted) {
      m_pincher.stop();
    }
  }

  @Override
  public boolean isFinished() {
    System.out.println("FINISH...ING");
    return m_pincher.isInPosition();
  }
}
