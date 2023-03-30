// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RioLights;

public class LightsPurple extends CommandBase {

  private final RioLights m_lights;

  public LightsPurple(RioLights lights) {
    m_lights = lights;
    addRequirements(m_lights);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_lights.purple();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}